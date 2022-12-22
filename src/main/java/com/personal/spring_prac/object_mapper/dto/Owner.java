package com.personal.spring_prac.object_mapper.dto;

import lombok.Data;

import java.util.List;


@Data
public class Owner {

    private String name;
    private int age;
    private List<Car> carList;

}
