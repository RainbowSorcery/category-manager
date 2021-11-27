package com.lyra.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.OAS_30);
        ApiInfo apiInfo = new ApiInfoBuilder()
                .description("商品管理系统")
                .title("商品分类管理系统")
                .build();
        docket.apiInfo(apiInfo);

        ApiSelectorBuilder apiSelectorBuilder = new ApiSelectorBuilder(docket);
        apiSelectorBuilder.paths(PathSelectors.any());
        apiSelectorBuilder.apis(RequestHandlerSelectors.withClassAnnotation(Api.class));

        return docket;
    }
}
