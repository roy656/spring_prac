package com.personal.spring_prac.http_method.dto;

import com.personal.spring_prac.http_method.dto.CarDto;
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
