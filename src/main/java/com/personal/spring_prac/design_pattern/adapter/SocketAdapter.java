package com.personal.spring_prac.design_pattern.adapter;

public class SocketAdapter implements Electronic110V {      // 220V 를 받아 110V 로 바꿔 내보내야되기 때문에 110V 를 implements

    private Electronic220V electronic220V;      // 연결시켜줘야 할 220V 를 가지고 있어야 한다.

    public SocketAdapter(Electronic220V electronic220V) {       // 기본생성자에서 220V 에 핵당하는 제품을 받는다.
        this.electronic220V = electronic220V;
    }
    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
