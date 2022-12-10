package com.personal.spring_prac.design_pattern.adapter;

public class Microwave implements Electronic110V {

    @Override
    public void powerOn() {
        System.out.println("전자레인지 110V On");
    }
}
