package com.example.devopspractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DevopsPracticeApplication {

    @GetMapping
    public String message(){
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(DevopsPracticeApplication.class, args);
    }

}
