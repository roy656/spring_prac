package com.personal.spring_prac.controller;

import com.personal.spring_prac.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// 여러 Response 예제 를 위한 클래스

@RestController
@RequestMapping("/api")
public class ApiController {

    // String 으로 내려주기
    @GetMapping("/text")
    public String text(@RequestParam String account) {
        return account;
    }

    // Json 으로 내려주기
    // 형태 변환 순서 : request -> ObjectMapper -> method -> Object -> ObjectMapper -> Json -> response
    @PostMapping("/json")
    public ResponseDto json(@RequestBody ResponseDto responseDto) {
        return responseDto;
    }

    // ResponseEntity<> 클래스로 내려주기
    @PutMapping("/put")
    public ResponseEntity<ResponseDto> put(@RequestBody ResponseDto responseDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
