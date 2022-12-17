package com.personal.spring_prac.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)  // Json 으로 응답을 내려줄때 null 값은 포함하지 않겠다는 속성. 이외에도 다른 옵션들이 많음
public class ResponseDto {

    private String name;

    private int age;

    private String address;

    private String phoneNumber;
}
