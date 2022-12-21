package com.personal.spring_prac.aop.aop_controller;

import com.personal.spring_prac.aop.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable Long id, @RequestParam String name) {
        return id + " " + name;
    }

    @PostMapping("/post")
    public UserDto post(@RequestBody UserDto userDto){
        return userDto;
    }
}
