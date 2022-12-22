package com.personal.spring_prac.object_mapper.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Car {

    private String name;
    @JsonProperty("plate_number")
    private String plateNumber;
    @JsonProperty("TYPE")
    private String type;
}
