package com.user_management.crud_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "User Crud API", version = "1.0", description = "APIs for managing User"))
public class CrudApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrudApiApplication.class, args);
    }
}
