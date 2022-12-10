package com.personal.spring_prac.design_pattern.adapter;

public class WashingMachine implements Electronic220V {

    @Override
    public void connect() {
        System.out.println("세탁기 220V On");
    }
}
