package com.eems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI expenseManagementOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Enterprise Expense Management API")
                        .description("API documentation for the Expense Management System")
                        .version("1.0"));
    }
}
