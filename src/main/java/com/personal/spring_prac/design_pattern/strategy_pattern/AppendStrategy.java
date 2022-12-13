package com.personal.spring_prac.design_pattern.strategy_pattern;

public class AppendStrategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return "ABCD " + text;
    }
}
