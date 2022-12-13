package com.personal.spring_prac.design_pattern.decorator;

public class X2 extends BmwDecorator{


    public X2(ICar bmw, String modelName) {
        super(bmw, modelName, 1000);
    }
}
