package com.personal.spring_prac.validation.dto;

import com.personal.spring_prac.validation.annotation.YearMonth;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Member {

    private String name;
    private int age;

    @Email
    private String email;

    // 정규식 으로 핸드폰 번호 양식 설정, message 로 양식과 맞지 않을경우 표시할 메세지를 설정 할 수 있음
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호 입력 양식을 확인해 주세요")
    private String phoneNumber;

    @YearMonth
    @NotBlank
    private String reqYearMonth;        // yyyy,mm 형식

}
