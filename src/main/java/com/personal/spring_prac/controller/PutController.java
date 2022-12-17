package com.personal.spring_prac.controller;

import com.personal.spring_prac.dto.PutRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PutController {

    @PutMapping("/update")
    public PutRequestDto update(@RequestBody PutRequestDto requestDto) {
        System.out.println(requestDto);
        return requestDto;  // Object 자체를 반환하면 스프링부트가 알아서 ObjectMapper 를 통해 Json 으로 바꿔 보내준다.
    }

    @PutMapping("/update/{userId}")
    public PutRequestDto update02(@RequestBody PutRequestDto requestDto, @PathVariable(name = "userId") Long id) {

        System.out.println(id);

        return requestDto;
    }
}
