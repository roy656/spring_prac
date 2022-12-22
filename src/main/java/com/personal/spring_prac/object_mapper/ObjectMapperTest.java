package com.personal.spring_prac.object_mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.spring_prac.object_mapper.dto.Car;
import com.personal.spring_prac.object_mapper.dto.Owner;

import java.util.Arrays;
import java.util.List;

public class ObjectMapperTest {

    public static void main(String[] args) throws JsonProcessingException {

        var objectMapper = new ObjectMapper();

        // --------Object -> text--------
        // ObjectMapper 는 변환할 객체의 get method 를 활용한다. (ObjectMapper 가 참조하는 클래스 내의 다른 메소드명에 get 을 넣으면 안된다.)
        User user = new User("Roy", 30, "010-1111-2222");
        var text = objectMapper.writeValueAsString(user);
        System.out.println(text);

        // --------text -> Object--------
        // ObjectMapper 는 default 생성자를 필요로 한다.
        var objectUser = objectMapper.readValue(text, User.class);   // 파라미터 첫번째는 json text , 두번째는 목표 객체
        System.out.println(objectUser);


        // --------json 의 node 를 직접 컨트롤 하는 예제--------
        Owner owner = new Owner();
        owner.setName("Roy");
        owner.setAge(30);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setPlateNumber("11고0000");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Olivia");
        car2.setPlateNumber("22가2000");
        car2.setType("suv");

        List<Car> carList = Arrays.asList(car1, car2);
        owner.setCarList(carList);
        System.out.println(owner);

        // owner 의 데이터를 json 으로 변경
        String json = objectMapper.writeValueAsString(owner);
        System.out.println(json);
        
    }



}
