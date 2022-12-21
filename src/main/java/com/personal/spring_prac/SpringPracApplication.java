package com.personal.spring_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Base64;

@SpringBootApplication
public class SpringPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracApplication.class, args);

        System.out.println(Base64.getEncoder().encodeToString("1111@gmail.com".getBytes()));
    }

}
