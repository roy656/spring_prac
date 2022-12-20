package com.personal.spring_prac.controller;

import com.personal.spring_prac.dto.PostRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PostController {

    // Map 사용
    @PostMapping("/members")
    public Map post(@RequestBody Map<String, Object> requestData) {

        requestData.forEach((key, value) -> {
            System.out.println("Key : " + key);
            System.out.println("Value : " + value);
        });

        return requestData;
    }


    // dto 사용
    @PostMapping("/members02")
    public PostRequestDto creatMember(@RequestBody PostRequestDto requestDto) {

        System.out.println(requestDto);

        return requestDto;
    }
}
