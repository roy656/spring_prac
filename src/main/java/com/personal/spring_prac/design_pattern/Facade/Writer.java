package com.personal.spring_prac.design_pattern.Facade;

public class Writer {

    private String fileName;

    public Writer(String fileName) {
        this.fileName = fileName;
    }



    public void fileConnect() {
        String msg = String.format("Writer %s 로 연결 합니다.", fileName);
        System.out.println(msg);
    }

    public void fileWrite() {
        String msg = String.format("Writer %s 로 파일을 작성 합니다.", fileName);
        System.out.println(msg);
    }

    public void fileDisconnect() {
        String msg = String.format("Writer %s 로 연결 종료 합니다.", fileName);
        System.out.println(msg);
    }
}
