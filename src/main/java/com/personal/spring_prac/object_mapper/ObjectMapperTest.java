package com.personal.spring_prac.object_mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperTest {

    public static void main(String[] args) throws JsonProcessingException {

        var objectMapper = new ObjectMapper();

        // Object -> text
        // ObjectMapper 는 변환할 객체의 get method 를 활용한다. (ObjectMapper 가 참조하는 클래스 내의 다른 메소드명에 get 을 넣으면 안된다.)
        User user = new User("Roy", 30);
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // text -> Object
        // ObjectMapper 는 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text, User.class);   // 파라미터 첫번째는 json text , 두번째는 목표 객체
        System.out.println(objectUser);
    }
}
