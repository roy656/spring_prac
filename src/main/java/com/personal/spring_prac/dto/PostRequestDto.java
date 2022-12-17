package com.personal.spring_prac.dto;

import lombok.Data;

import java.util.List;

@Data
public class PostRequestDto {

    private String account;

    private String email;

    private int password;

    private String address;

    private List<CarDto> carList;
}
