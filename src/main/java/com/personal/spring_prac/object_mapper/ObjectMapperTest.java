//package com.personal.spring_prac.object_mapper;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.node.ArrayNode;
//import com.fasterxml.jackson.databind.node.ObjectNode;
//import com.personal.spring_prac.object_mapper.dto.Car;
//import com.personal.spring_prac.object_mapper.dto.Owner;
//
//import java.util.Arrays;
//import java.util.List;
//
//public class ObjectMapperTest {
//
//    public static void main(String[] args) throws JsonProcessingException {
//
//        var objectMapper = new ObjectMapper();
//
//        // --------Object -> text--------
//        // ObjectMapper 는 변환할 객체의 get method 를 활용한다. (ObjectMapper 가 참조하는 클래스 내의 다른 메소드명에 get 을 넣으면 안된다.)
//        User user = new User("Roy", 30, "010-1111-2222");
//        var text = objectMapper.writeValueAsString(user);
//        System.out.println(text);
//
//        // --------text -> Object--------
//        // ObjectMapper 는 default 생성자를 필요로 한다.
//        var objectUser = objectMapper.readValue(text, User.class);   // 파라미터 첫번째는 json text , 두번째는 목표 객체
//        System.out.println(objectUser);
//
//
//        // --------
//        Owner owner = new Owner();
//        owner.setName("Roy");
//        owner.setAge(30);
//
//        Car car1 = new Car();
//        car1.setName("K5");
//        car1.setPlateNumber("11고0000");
//        car1.setType("sedan");
//
//        Car car2 = new Car();
//        car2.setName("Olivia");
//        car2.setPlateNumber("22가2000");
//        car2.setType("suv");
//
//        List<Car> carList = Arrays.asList(car1, car2);
//        owner.setCarList(carList);
//        System.out.println(owner);
//
//        // owner 의 데이터를 json 으로 변경
//        String json = objectMapper.writeValueAsString(owner);
//        System.out.println(json);
//
//
//        // --------json 의 node 를 각각 직접 접근 하는 예제-------- (미리 해당 json 이 어떻게 생겼는지 표준스펙을 아는 경우에 해)
//
//        // 일반 key & value 로 되어있는 json 노드
//        JsonNode jsonNode = objectMapper.readTree(json);
//        String _name = jsonNode.get("name").asText();       // as.text() 로 text 형변환
//        int _age = jsonNode.get("age").asInt();             // as.Int() 로 int 형변환
//        System.out.println("name : " + _name);
//        System.out.println("age : " + _age);
//
//        // json 노드 중 배열의 노드 처리 과정
//        JsonNode cars = jsonNode.get("carList");    // 객체에 접근할 때는 JsonNode 의 get 메서드로 간단히 가능
//        // ObjectMapper 의 ArrayNode 라는 클래스를 사용해 변환
//        ArrayNode arrayNode = (ArrayNode) cars;
//        // ObjectMapper 의 convertValue 메서드를 사용해 ArrayNode 객체를 List<Car> 로 변환
//        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
//        System.out.println("car_list : " + _cars);
//
//
//        // --------json 의 node 를 직접 변경,수정 하는 예제--------
//        // JsonNode 에 set 메서드가 있으면 간단하지만 JsonNode 에선 set 을 할수없게 막아놓음
//        // 그래서 JsonNode 를 ObjectNode 로 형변환 하여 set 과 같은 put 메서드를 이용해 데이터 변경 가능
//        ObjectNode objectNode = (ObjectNode) jsonNode;
//        objectNode.put("name", "Mari");
//        objectNode.put("age", 10);
//
//        System.out.println(objectNode.toPrettyString());
//    }
//
//
//    /*
//    이러한 조작들은 필요에 따라 AOP 에서 라든지 Filter 혹은 Interceptor 같은곳에서 활용 가능.
//     */
//
//}
