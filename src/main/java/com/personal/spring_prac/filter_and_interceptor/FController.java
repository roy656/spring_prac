package com.personal.spring_prac.filter_and_interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/person")
public class FController {

    @PostMapping("")
    public Member member(@RequestBody Member member) {
        log.info("Member : {}", member );

        return member;
    }
}
