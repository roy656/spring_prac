package com.personal.spring_prac.design_pattern.singleton;

public class SingletonA {

    private SocketClient socketClient;

    public SingletonA() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
