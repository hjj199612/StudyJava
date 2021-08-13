package com.hjj.config;

/**
 * @author huangjj24
 * @date 2021-8-13 17:22
 **/

import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private String title;
    private String description;

    @Autowired
    public SwaggerConfig(Environment environment) {
        // this.title = environment.getProperty("hj");
        // this.description = environment.getProperty("hjj");
        this.title = "JJ";
        this.description = "HJJ";
    }

    @Bean
    public Docket createRestApi() {
        if (StringUtils.isBlank(this.title)) {
            return null;
        }
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     * 这里是接口的描述配置，不重要
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).description(description).build();
    }
}

