package com.personal.spring_prac.rest_template.server.server_controller;

import com.personal.spring_prac.rest_template.server.dto.Person;
import com.personal.spring_prac.rest_template.server.server_service.SService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/server")
public class SController {

    private final SService service;

    public SController(SService service) {
        this.service = service;
    }

    // Client 에서 받은 데이터 그대로 echo 하는 예시
    @GetMapping("/hello")
    public Person hello(@RequestParam String name, @RequestParam int age) {
        return service.hello(name, age);
    }
}
