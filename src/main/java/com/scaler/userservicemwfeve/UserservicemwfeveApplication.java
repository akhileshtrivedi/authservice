package com.scaler.userservicemwfeve;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@OpenAPIDefinition(info = @Info(title = "Auth API", version = "1.0"))
@SpringBootApplication
public class UserservicemwfeveApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserservicemwfeveApplication.class, args);
    }

}
