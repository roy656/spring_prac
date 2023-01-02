package com.personal.spring_prac.rest_template.server.server_controller;

import com.personal.spring_prac.rest_template.server.dto.Person;
import com.personal.spring_prac.rest_template.server.server_service.SService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
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

    @PostMapping("/hi/{personId}/name/{personName}")
    public Person hi(@RequestBody Person person, @PathVariable int personId, @PathVariable String personName) {
        log.info("client request : {}", person);
        return person;
    }

    // header 값 포함 예제
    @PostMapping("/exchange/{personId}/name/{personName}")
    public Person hiIncludeHeader(@RequestBody Person person,
                                  @PathVariable int personId,
                                  @PathVariable String personName,
                                  @RequestHeader("x-Athorization") String athorization,
                                  @RequestHeader("custom-header") String customHeader) {
        log.info("client request : {}", person);
        log.info("authorization : {}, custom header : {}", athorization, customHeader);
        return person;
    }
}
