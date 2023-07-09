package com.frmv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //告诉Spring容器， 这个类是- -个配置类
@EnableSwagger2 //启用Swagger2功能
public class swaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket (DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select()
            .build();
    }
    // API文档页面显示信息
    private ApiInfo apiInfo() {
            return new ApiInfoBuilder()
            .title("FRMV") //标题
            .description("新生报到数据监控可视化系统") //描述
            .version("1.0")
            .build();
    }
}
