package com.personal.spring_prac.http_method.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.personal.spring_prac.http_method.dto.CarDto;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)   // 일괄적으로 모든 Json naming 룰 을 적용시킬수 있다.
public class PutRequestDto {

    private String name;

    private String age;

    private List<CarDto> carList;
}
