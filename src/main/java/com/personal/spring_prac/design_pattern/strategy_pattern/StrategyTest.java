//package com.personal.spring_prac.design_pattern.strategy_pattern;
//
//
//// 사용 주체인 객체는 변화시키지 않고 원하는 전략의 주입을 통해서 결과값이 달라지도록 설정 하는 패턴.
//public class StrategyTest {
//
//    public static void main(String[] args) {
//
//        // 사용하기 위한 기본 객체
//        Encoder encoder = new Encoder();
//
//        // base64 전략 생성
//        EncodingStrategy base64 = new Base64Strategy();
//
//        // normal 전략 생성
//        EncodingStrategy normal = new NormalStrategy();
//
//        // append 전략 생성
//        EncodingStrategy append = new AppendStrategy();
//
//        String message = "Hello World";
//
//        // 기본 객체를 건드리지 않고 사용할때마다 전략을 세팅한다.
//        encoder.setEncodingStrategy(base64);
//        String base64Result = encoder.getMessage(message);
//        System.out.println(base64Result);
//
//        encoder.setEncodingStrategy(normal);
//        String normalResult = encoder.getMessage(message);
//        System.out.println(normalResult);
//
//        encoder.setEncodingStrategy(append);
//        String appendResult = encoder.getMessage(message);
//        System.out.println(appendResult);
//
//    }
//}
