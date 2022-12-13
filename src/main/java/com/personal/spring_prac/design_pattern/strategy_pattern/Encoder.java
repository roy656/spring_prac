package com.personal.spring_prac.design_pattern.strategy_pattern;

public class Encoder {

    private EncodingStrategy encodingStrategy;

    // 각각의 전략에 따라서 결과가 달라지는 메서드
    public String getMessage(String message) {
        return this.encodingStrategy.encode(message);
    }

    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }
}
