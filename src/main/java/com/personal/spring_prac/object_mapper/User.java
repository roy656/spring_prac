package com.personal.spring_prac.object_mapper;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class User {

    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;


    public User() {
        this.name = null;
        this.age = 0;
        this.phoneNumber = null;
    };

    public User(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
