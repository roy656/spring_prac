package com.personal.spring_prac.design_pattern.adapter;

public class AirCirculator implements Electronic220V {

    @Override
    public void connect() {
        System.out.println("공기청정기 200V On");
    }
}
