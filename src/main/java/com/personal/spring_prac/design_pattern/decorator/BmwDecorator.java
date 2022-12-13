package com.personal.spring_prac.design_pattern.decorator;


// 기본 구조를 건들지 않고 Decorator 를 이용해 부가적으로 첨가 하면서 속성을 변화 시키는 패턴

public class BmwDecorator implements ICar{

    protected ICar bmw;
    protected String modelName;
    protected int modelPrice;

    public BmwDecorator(ICar bmw, String modelName, int modelPrice) {
        this.bmw = bmw;
        this.modelName = modelName;
        this.modelPrice = modelPrice;
    }

    @Override
    public int getPrice() {
        return bmw.getPrice() + modelPrice;
    }

    @Override
    public void showPrice() {
        System.out.println(modelName + " 의 가격은 " + getPrice() + " 원 입니다.");
    }
}
