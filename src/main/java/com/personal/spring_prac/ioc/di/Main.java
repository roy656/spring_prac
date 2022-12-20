package com.personal.spring_prac.ioc.di;

public class Main {

    public static void main(String[] args) {

        String url = "www.google.com/books/it?page=10&size=20&name=spring-boot";

        Encoder encoder = new Encoder(new Base64Encoder());     // Encoder 내부를 건드리지 않고 Base64Encoder 를 외부에서 주입을 받아 사용
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
