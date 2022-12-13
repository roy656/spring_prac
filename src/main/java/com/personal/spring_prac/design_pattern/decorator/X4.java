package com.personal.spring_prac.design_pattern.decorator;

public class X4 extends BmwDecorator{
    public X4(ICar bmw, String modelName) {
        super(bmw, modelName, 2000);
    }
}
