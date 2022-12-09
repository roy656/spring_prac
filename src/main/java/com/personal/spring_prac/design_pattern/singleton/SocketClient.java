package com.personal.spring_prac.design_pattern.singleton;


// 프로그램에서 한개의 객체만 존재해야 할 경우 싱글톤 패턴을 사용.

public class SocketClient {

    private static SocketClient socketClient = null;

    private SocketClient(){     // default 생성자를 private 으로 설정해 다른곳에서 새로이 객체를 생성하지 못하게 함 (최초에 한번만 생성되도록)
    }

    public static SocketClient getInstance() {      // static 메서드를 통해서 자신의 객체를 제공한다.

        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
