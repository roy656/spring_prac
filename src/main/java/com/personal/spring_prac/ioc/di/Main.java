package com.personal.spring_prac.ioc.di;

public class Main {

    public static void main(String[] args) {

        String url = "www.google.com/books/it?page=10&size=20&name=spring-boot";

        Encoder encoder = new Encoder();
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
