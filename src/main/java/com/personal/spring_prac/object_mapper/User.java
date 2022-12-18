package com.personal.spring_prac.object_mapper;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class User {

    private String name;

    private int age;


    public User() {
        this.name = null;
        this.age = 0;
    };

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
