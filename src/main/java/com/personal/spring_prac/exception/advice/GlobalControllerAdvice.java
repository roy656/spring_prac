package com.personal.spring_prac.exception.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "com.personal.spring_prac.exception")  // 해당 패키지 하위의 예외를 잡겠다고 설정
public class GlobalControllerAdvice {

    // 전체 예외 잡기
    @ExceptionHandler(value = Exception.class)  // 전체 예외를 다 핸들링 하겠다.
    public ResponseEntity exception(Exception e) {
        System.out.println("-------------------");
        System.out.println(e.getClass().getName());
        System.out.println("-------------------");
        System.out.println(e.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
    }


    // 특정 예외 잡기
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

/*

GlobalControllerAdvice 에 들어가 있더라도 직접 Controller 클래스 안에 @ExceptionHandler 메서드가 있다면 그곳이 우선순위를 가지게 된다.

 */