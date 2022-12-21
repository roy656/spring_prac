//package com.personal.spring_prac.ioc_and_di;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@SpringBootApplication
//public class Main {
//
//    public static void main(String[] args) {
//        SpringApplication.run(Main.class, args);
//        ApplicationContext context = ApplicationContextProvider.getContext();
//
////        Base64Encoder base64Encoder = context.getBean(Base64Encoder.class);
//        Encoder encoder = context.getBean("base64Encode", Encoder.class);
//
//        String url = "www.google.com/books/it?page=10&size=20&name=spring-boot";
//
//        String result = encoder.encode(url);
//        System.out.println(result);
//
//
//
//
//
//        /*
//        Di 과정 예제
//        String url = "www.google.com/books/it?page=10&size=20&name=spring-boot";
//
//        Encoder encoder = new Encoder(new Base64Encoder());     // Encoder 내부를 건드리지 않고 Base64Encoder 를 외부에서 주입을 받아 사용
//        String result = encoder.encode(url);
//        System.out.println(result);
//         */
//    }
//}
//
//
//@Configuration
//class AppConfig {
//
//    @Bean("base64Encode")
//    public Encoder encoder(Base64Encoder base64Encoder) {
//        return new Encoder(base64Encoder);
//    }
//}