package com.personal.spring_prac.design_pattern.decorator;

public class X6 extends BmwDecorator{
    public X6(ICar bmw, String modelName) {
        super(bmw, modelName, 3000);
    }
}
