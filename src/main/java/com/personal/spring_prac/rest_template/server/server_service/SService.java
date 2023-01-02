package com.personal.spring_prac.rest_template.server.server_service;

import com.personal.spring_prac.rest_template.server.dto.Person;
import org.springframework.stereotype.Service;

@Service
public class SService {

    public Person hello(String name, int age) {

        return new Person(name, age);
    }

}
