package com.user_management.crud_api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "User CRUD Operations API", version = "1.0", description = "This API is developed by Abhishek", contact = @Contact(name = "Abhishek Gorde", email = "abhishek@gmail.com")))
public class SwaggerConfig {
 //this class configugers title ,description and many more for Documentation

}
