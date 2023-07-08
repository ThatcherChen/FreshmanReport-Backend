package com.frmv.entity;

public class scoredStudent extends student {
    private int score;
    private int headPicture;

    public scoredStudent(student student) {
        super(student); // 假设 Student 类有一个接受 Student 作为参数的构造函数
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(int headPicture) {
        this.headPicture = headPicture;
    }
}
