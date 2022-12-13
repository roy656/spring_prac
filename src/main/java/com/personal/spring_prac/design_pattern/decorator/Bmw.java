package com.personal.spring_prac.design_pattern.decorator;

public class Bmw implements ICar{

    private int price;

    public Bmw(int price) {
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void showPrice() {
        System.out.println("Bmw 의 가격은 : " + this.price + " 원 입니다.");

    }
}
