package com.personal.spring_prac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Base64;

@SpringBootApplication
@ServletComponentScan
public class SpringPracApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracApplication.class, args);
    }

}
