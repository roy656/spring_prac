//package com.personal.spring_prac.design_pattern.adapter;
//
//public class AdapterPatternTest {
//
//    public static void main(String[] args) {
//
//        Microwave microwave = new Microwave();
//        connect(microwave);
//
//        WashingMachine washingMachine = new WashingMachine();
//        Electronic110V adapter = new SocketAdapter(washingMachine);     // 110V 인 adapter 에 220V 인 세탁기를 넣어 생성.
//        connect(adapter);       // 220V 제품인 washingMachine 대신 adapter 를 이용하여 connect 한다.
//
//        AirCirculator airCirculator = new AirCirculator();
//        Electronic110V airAdapter = new SocketAdapter(airCirculator);
//        connect(airAdapter);
//    }
//
//    // 콘센트
//    public static void connect (Electronic110V electronic110V){
//        electronic110V.powerOn();
//    }
//}