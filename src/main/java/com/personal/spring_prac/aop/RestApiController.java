package com.personal.spring_prac.aop;

import com.personal.spring_prac.aop.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/get/{id}")
    public void get(@PathVariable Long id, @RequestParam String name) {
        System.out.println("get method");
        System.out.println("get method : " + id);
        System.out.println("get methoid : " + name);
    }

    @PostMapping("/post")
    public void post(@RequestBody UserDto userDto){
        System.out.println("post method : " + userDto);
    }
}
