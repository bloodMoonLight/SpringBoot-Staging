package com.springboot.project.config;

import com.google.common.collect.Sets;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 的配置
 * @Author:zzh
 * @CreateDate:2020/11/3 10:35
 * @Description:
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket createSwagger2(){
        return new Docket(DocumentationType.SWAGGER_2)
                    .produces(Sets.newHashSet("application/json"))
                    .consumes(Sets.newHashSet("application/json"))
                    .protocols(Sets.newHashSet("http","https"))
                    .apiInfo(apiInfo())
                    .forCodeGeneration(true)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.springboot.project.controller"))
                    .paths(PathSelectors.any())
                    .build();
    }

    /**
     * Api信息
     * @return
     */
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 文档标题
                .title("Swagger2接口服务")
                // 文档描述
                .description("系统API接口文档")
                .termsOfServiceUrl("localhost:8300")
                .version("v1")
                .build();
    }
}
