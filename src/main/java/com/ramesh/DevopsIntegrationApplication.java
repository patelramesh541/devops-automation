package com.ramesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
@SpringBootApplication
@RestController
public class DevopsIntegrationApplication {

    @GetMapping
    public String message() {
        return "welcome ramesh !";
    }

    public static void main(String[] args) {

        SpringApplication.run(DevopsIntegrationApplication.class, args);
    }
}
