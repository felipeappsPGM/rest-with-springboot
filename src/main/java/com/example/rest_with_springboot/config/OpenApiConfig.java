package com.example.rest_with_springboot.config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI().info(new Info()
                        .title("Rest API with Spring Boot")
                        .version("1.0")
                        .description("A simple REST API using Spring Boot and OpenAPI")
                        .termsOfService("")
                        .license(new License().name("Apache License, Version 2.0").url(""))
        );
    }
}
