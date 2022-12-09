package com.personal.spring_prac.design_pattern.singleton;

public class SocketClientTest {

    public static void main(String[] args) {

        SingletonA singletonA = new SingletonA();
        SingletonB singletonB = new SingletonB();

        SocketClient aClient = singletonA.getSocketClient();
        SocketClient bClient = singletonB.getSocketClient();

        System.out.println("두개의 객체는 동일한가?");
        System.out.println(aClient.equals(bClient));
    }
}
