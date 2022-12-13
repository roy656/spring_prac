package com.personal.spring_prac.design_pattern.Facade;

public class Reader {

    private String fileName;

    public Reader(String fileName) {
        this.fileName = fileName;
    }

    public void fileConnect() {
        String msg = String.format("Reader %s 로 연결 합니다.", fileName);    // String.format 은 문자열 형식을 지정하는 메서드
        System.out.println(msg);                                          // fileName 이 %s 자리로 들어감.

    }

    public void fileRead() {
        String msg = String.format("Reader %s 의 내용을 읽어 옵니다", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("Reader %s 로 연결 종료 합니다.", fileName);
        System.out.println(msg);
    }
}
