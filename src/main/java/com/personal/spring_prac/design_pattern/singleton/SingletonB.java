package com.personal.spring_prac.design_pattern.singleton;

public class SingletonB {

    private SocketClient socketClient;

    public SingletonB() {
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
