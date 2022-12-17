package com.personal.spring_prac.dto;

import lombok.Data;

@Data
public class MemberRequestDto {

    private String account;

    private String email;

    private int password;

    private String address;
}
