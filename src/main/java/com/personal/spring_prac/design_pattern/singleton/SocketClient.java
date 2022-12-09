package com.personal.spring_prac.design_pattern.singleton;

public class SocketClient {

    private static SocketClient socketClient = null;

    private SocketClient(){     // default 생성자를 private 으로 설정해 막아놓고
    }

    public static SocketClient getInstance() {      // static 메서드를 통해서 자신의 객체를 제공한다. (최초에 한번만 생성되도록)

        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
