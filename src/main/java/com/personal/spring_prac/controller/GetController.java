package com.personal.spring_prac.controller;


import com.personal.spring_prac.dto.UserRequestDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class GetController {

    @GetMapping(path = "/hello")    // http://localhost:8080/api/hello , path 명시 는 생략 가능
    public String hello() {
        return "Hello World";
    }

    @RequestMapping(path = "/hi", method = RequestMethod.GET)   // 예전 방식
    public String hi() {
        return "Hi";
    }

    @GetMapping("/path-variable/{name}")   // http://localhost:8080/api/path-variable/{name}
    public String pathVariable(@PathVariable String name) {
        System.out.println("PathVariable : " + name);
        return name;
        // path 명 과 변수 명이 달라야 될 경우 (@PathVariable(name = "name") String pathName) 처럼 name 속성을 지정하여 사용.
    }

    // Map 으로 받으면 모든 key 가 다 받아지기 때문에 어떤것이 들어올지 모른다
    @GetMapping(path = "/query-param")  // http://localhost:8080/api/query-param?name=roy&age=30&email=v0o0605@gmail.com
    public String queryParam(@RequestParam Map<String, String> queryParam) {

        StringBuilder stringBuilder = new StringBuilder();

        queryParam.entrySet().forEach( entry -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            stringBuilder.append(entry.getKey() + " = " + entry.getValue() + "\n");
        });

        return stringBuilder.toString();
    }

    // @RequestParam 어노테이션을 변수마다 붙혀서 명시적으로 변수로 받는 방식
    @GetMapping(path = "query-param02")
    public String queryParam02(@RequestParam String name, @RequestParam int age, @RequestParam String email) {

        System.out.println(name);
        System.out.println(age);
        System.out.println(email);
        return name + "" + age + "" + email;
    }

    // 어노테이션을 사용하지 않고 Dto 를 이용해서 한번에 받는 방식 (가장 추천, 많이 쓰임)
    // dto 클래스의 변수명을 매칭 해주어야 한다
    // ?name=roy&age=30&email=v0o0605@gmail.com  쿼리 파라미터 부분을 스프링부트에서 판단을 해준다.
    @GetMapping(path = "query-param03")
    public String queryParam03(UserRequestDto requestDto) {

        System.out.println(requestDto.getName());
        System.out.println(requestDto.getAge());
        System.out.println(requestDto.getEmail());

        return requestDto.toString();
    }
}
