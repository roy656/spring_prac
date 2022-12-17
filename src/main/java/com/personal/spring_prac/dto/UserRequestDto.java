package com.personal.spring_prac.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserRequestDto {

    private String name;

    private int age;

    private String email;

    @JsonProperty("phone_number")   // 실제 dto 의 변수명과 요청의 key 명 이 다를 경우 @JsonProperty 어노테이션으로 지정 가능.
    private String phoneNumber;


}
