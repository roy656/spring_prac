package com.personal.spring_prac.ioc.di;

import java.util.Base64;

public class Encoder {

    private IEncoder iEncoder;

    public Encoder() {
        this.iEncoder = new Base64Encoder();
    }

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}
