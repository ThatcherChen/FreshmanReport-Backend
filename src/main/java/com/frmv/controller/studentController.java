package com.frmv.controller;

import com.frmv.entity.*;
import com.frmv.mapper.accountMapper;
import com.frmv.mapper.studentMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@Api(tags = "student表接口")
@RestController
public class studentController {

    @Autowired
    private studentMapper stuMapper;
    @Autowired
    private accountMapper accMapper;

    @ApiOperation(value = "查询收集到的所有学生信息")
    @GetMapping("/queryAll")
    public List<student> queryAll() {
        return stuMapper.selectList(null);
    }

    @ApiOperation(value = "信息收集并且自动绑定账号")
    @PostMapping("/infoCollect")
    public result infoCollect(@RequestBody bind bind) {
        result res = new result();
        student student = new student();
        student.setName(bind.getName());
        student.setGender(bind.getGender());
        student.setIdNumber(bind.getIdNumber());
        student.setRegion(bind.getRegion());
        student.setBirthday(bind.getBirthday());
        student.setMajor(bind.getMajor());
        student.setInterests(bind.getInterests());
        student.setReportTime(bind.getReportTime());
        student.setCollege(bind.getCollege());
        student.setDegree(bind.getDegree());
        student.setTraffic(bind.getTraffic());
        String phone = bind.getPhone();
        try {
            int i = stuMapper.insert(student);
            int id = stuMapper.queryID(student.getIdNumber());
            student.setId(id);
            int j = stuMapper.bind(id, phone);
            if (i <= 0) {
                res.setStatus(false);
                res.setResult("插入student信息失败！");
            }
            else if (j <= 0) {
                stuMapper.deleteById(id);
                res.setStatus(false);
                res.setResult("绑定账号失败！");
            } else {
                res.setStatus(true);
                res.setResult("信息收集成功！");
            }
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "查询学生是否完成信息收集，是则返回学生信息")
    @PostMapping("/queryStudent")
    public result queryStudent(@RequestBody account account){
        result res = new result();
        try{
            int stu_id = accMapper.queryStu_id(account.getPhone());
            if (stu_id <= 0) {
                res.setStatus(false);
                res.setResult("未完成信息收集");
                return res;
            }
            student student = stuMapper.queryStudent(stu_id);
            res.setStatus(true);
            res.setResult(student);
            return res;
        } catch (DataAccessException e){
            e.printStackTrace();
            res.setStatus(false);
            res.setResult("出现异常: " + e.getMessage());
            return res;
        }
    }

    @ApiOperation(value = "查询已完成信息收集的人数")
    @GetMapping("/countNumber")
    public int countNumber(){
        return stuMapper.countNumber();
    }

    @ApiOperation(value = "查询男女人数")
    @GetMapping("/countGender")
    public List<gender> countGender() {
        return stuMapper.countGender();
    }

    @ApiOperation(value = "查询各学院人数")
    @GetMapping("/countCollege")
    public List<college> countCollege() {
        return stuMapper.countCollege();
    }

    @ApiOperation(value = "查询各学院各性别人数")
    @GetMapping("/countCollegeGender")
    public List<collegeGender> countCollegeGender() {
        return stuMapper.countCollegeGender();
    }

    @ApiOperation(value = "查询学院各学位人数")
    @ApiImplicitParam(name="name",value="学院缩写名",required=true,dataType = "String")
    @GetMapping("/countCollegeDegree")
    public List<collegeDegree> countCollegeDegree(String name) {
        switch (name) {
            case "cs": return stuMapper.countOneCollegeDegree("计算机学院");
            case "sw": return stuMapper.countOneCollegeDegree("软件学院");
            case "tx": return stuMapper.countOneCollegeDegree("微电子与通信学院");
            case "ee": return stuMapper.countOneCollegeDegree("电气工程及自动化学院");
            case "bs": return stuMapper.countOneCollegeDegree("商学院");
            case "mc": return stuMapper.countOneCollegeDegree("机械工程及自动化学院");
            default: return stuMapper.countCollegeDegree();
        }
    }

    @ApiOperation(value = "查询各专业人数")
    @GetMapping("/countMajor")
    public List<major> countMajor() {
        return stuMapper.countMajor();
    }

    @ApiOperation(value = "查询各专业各性别人数")
    @GetMapping("/countMajorGender")
    public List<majorGender> countMajorGender() {
        return stuMapper.countMajorGender();
    }

    @ApiOperation(value = "查询各学位人数")
    @GetMapping("/countDegree")
    public List<degree> countDegree() {
        return stuMapper.countDegree();
    }

    @ApiOperation(value = "查询各交通方式报道人数")
    @GetMapping("/countTraffic")
    public List<traffic> countTraffic() {
        return stuMapper.countTraffic();
    }

    @ApiOperation(value = "查询各兴趣人数")
    @GetMapping("/countInterest")
    public List<interests> countInterest() {
        List<interests> numbers = new ArrayList<>();
        // 调用方法查询所有的 interests 数据
        List<String> interests = stuMapper.queryInterest();
        // 统计各兴趣个数
        Map<String, Long> interestCounts = new HashMap<>();
        for (String interest : interests) {
            String[] interestArr = interest.split(",");
            for (String value : interestArr) {
                String trimmedValue = value.trim();
                interestCounts.put(trimmedValue, interestCounts.getOrDefault(trimmedValue, 0L) + 1);
            }
        }
        // 将统计结果转换为 List<Interest> 格式
        for (Map.Entry<String, Long> entry : interestCounts.entrySet()) {
            numbers.add(new interests(entry.getKey(), entry.getValue()));
        }
        return numbers;
    }

    @ApiOperation(value = "查询各地区来源人数")
    @GetMapping("/countRegion")
    public List<region> countRegion() {
        List<region> numbers = new ArrayList<>();
        List<String> regionStrs = stuMapper.queryRegion();
        Map<String, Long> regionCounts = new HashMap<>();
        for (String regionStr: regionStrs) {
            String[] subStr = regionStr.split("-");
            for (String part: subStr) {
                if (part.endsWith("市")) {
                    regionCounts.put(part, regionCounts.getOrDefault(part, 0L) + 1);
                }
            }
        }
        for (Map.Entry<String, Long> entry : regionCounts.entrySet()) {
            numbers.add(new region(entry.getKey(), entry.getValue()));
        }
        return numbers;
    }

    @ApiOperation(value = "批量查询student信息")
    @ApiImplicitParam(name="batch",value="批量大小",required=false,dataType = "Integer")
    @GetMapping("/queryBatchStudent")
    public List<student> queryBatchStudent(Integer batch) {
        if (batch == null) {
            batch = 10;
        }
        return stuMapper.queryBatchStudent(batch);
    }

    @ApiOperation(value = "查询兴趣爱好相似的其他学生")
    @PostMapping("/querySimilarInterest")
    public result querySimilarInterest(@RequestBody account account) {
        result res = new result();
        try{
            int stu_id = accMapper.queryStu_id(account.getPhone());
            student stu = stuMapper.queryStudent(stu_id);
            String inputInterests = stu.getInterests();
            Set<String> inputInterestsSet = new HashSet<>(Arrays.asList(inputInterests.split(",")));

            List<student> allStudents = stuMapper.selectList(null);
            List<scoredStudent> scoredStudents = allStudents.stream()
                    .map(scoredStudent::new) // 使用 Student 创建 ScoredStudent
                    .filter(student -> student.getId() != stu.getId()) // 排除目标学生
                    .collect(Collectors.toList());

            scoredStudents.forEach(scoredStudent -> {
                String interests = scoredStudent.getInterests();
                if (interests == null) {
                    scoredStudent.setScore(0);
                } else {
                    Set<String> studentInterestsSet = new HashSet<>(Arrays.asList(interests.split(",")));
                    studentInterestsSet.retainAll(inputInterestsSet);
                    scoredStudent.setScore(studentInterestsSet.size());
                }
            });

            // 按照分数排序，并过滤掉分数为零的学生
            List<scoredStudent> sortedStudents = scoredStudents.stream()
                    .filter(scoredStudent -> scoredStudent.getScore() > 0)
                    .sorted(Comparator.comparing(scoredStudent::getScore).reversed())
                    .limit(100)
                    .collect(Collectors.toList());

            sortedStudents.forEach(sortedStudent -> {
                int id = sortedStudent.getId();
                account account1 = accMapper.queryAccountByID(id);
                sortedStudent.setHeadPicture(account1.getHeadPicture());
            });

            res.setStatus(true);
            res.setResult(sortedStudents);
            return res;
        } catch (Exception e){
            res.setStatus(false);
            res.setResult("出现异常: " + e);
        }
        return res;
    }

    @ApiOperation(value = "查询来源地区相似的其他学生")
    @PostMapping("/querySimilarRegion")
    public result querySimilarRegion(@RequestBody account account) {
        result res = new result();
            try{
            int stu_id = accMapper.queryStu_id(account.getPhone());
            student stu = stuMapper.queryStudent(stu_id);
            String targetRegion = stu.getRegion();
            Set<String> inputRegionSet = new HashSet<>(Arrays.asList(targetRegion.split("-")));

            List<student> allStudents = stuMapper.selectList(null);
            List<scoredStudent> scoredStudents = allStudents.stream()
                    .map(scoredStudent::new)
                    .filter(student -> student.getId() != stu.getId()) // 排除目标学生
                    .filter(student -> {
                        String studentRegion = student.getRegion();
                        if (studentRegion != null) {
                            String studentFirstRegion = studentRegion.split("-")[0];
                            String targetFirstRegion = targetRegion.split("-")[0];
                            return studentFirstRegion.equals(targetFirstRegion);
                        }
                        return false;
                    })
                    .collect(Collectors.toList());

            scoredStudents.forEach(scoredStudent -> {
                Set<String> studentRegionSet = new HashSet<>(Arrays.asList(scoredStudent.getRegion().split("-")));
                studentRegionSet.retainAll(inputRegionSet);
                scoredStudent.setScore(studentRegionSet.size());
            });

            // 按照分数排序，并过滤掉分数为零的学生
            List<scoredStudent> sortedStudents = scoredStudents.stream()
                    .filter(scoredStudent -> scoredStudent.getScore() > 0)
                    .sorted(Comparator.comparing(scoredStudent::getScore).reversed())
                    .collect(Collectors.toList());

            sortedStudents.forEach(sortedStudent -> {
                int id = sortedStudent.getId();
                account account1 = accMapper.queryAccountByID(id);
                sortedStudent.setHeadPicture(account1.getHeadPicture());
            });

            res.setStatus(true);
            res.setResult(sortedStudents);
            return res;
        } catch (Exception e){
            res.setStatus(false);
            res.setResult("出现异常: " + e);
        }
        return res;
    }

}
