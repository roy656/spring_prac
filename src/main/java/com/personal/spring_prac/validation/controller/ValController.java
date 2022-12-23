package com.personal.spring_prac.validation.controller;


import com.personal.spring_prac.validation.dto.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ValController {

    // 입력받는 파라미터 앞에 @Valid 를 붙혀 검증을 한다. 양식에 맞지 않는경우 예외가 터지는데
    // BindingResult 를 이용하면 잘못된 값이 안에 들어오게 된
    @PostMapping("/member")
    public Object user(@Valid @RequestBody Member member, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field : " + field.getField());      // 어떤 field 에서
                System.out.println(message);                            // 어떤 에러가 발생했는지

                sb.append("field : " + field.getField() + "\n");        // 깔끔하게 StringBuilder 로 정리해서 리턴
                sb.append("message : " + message);
            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb);
        }

        return ResponseEntity.ok(member);
    }
}
