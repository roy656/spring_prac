package com.personal.spring_prac.filter_and_interceptor.interceptor.controller;

import com.personal.spring_prac.filter_and_interceptor.interceptor.Auth;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/private")
@Auth
public class PrivateController {

    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
