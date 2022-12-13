package com.personal.spring_prac.design_pattern.proxy;

import java.util.concurrent.atomic.AtomicLong;

public class ProxyTest {

    public static void main(String[] args) {
/*
        // 기본 프록시 사용
        MyBrowser myBrowser = new BrowserProxy("www.google.com");
        myBrowser.show();   // 처음에만 html 객체를 생성하고
        myBrowser.show();   // 그 이후로는 캐싱 된 html 을 내려준다.
        myBrowser.show();
        myBrowser.show();
*/

        // 프록시 패턴으로 Aop 기능
        // 메소드 시간 체크시 동시성 문제 때문에
        AtomicLong start = new AtomicLong();
        AtomicLong finish = new AtomicLong();

        MyBrowser aopBrowser = new AopBrowser("www.google.com",
                () -> {
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
            long now = System.currentTimeMillis();      // 현재시간
            finish.set(now - start.get());      // 현재시간 - set 해놓은 이전시간
                });

        aopBrowser.show();
        System.out.println(" loading time : " + finish.get());      // 로딩 시 1.5 초 경과
        aopBrowser.show();
        System.out.println(" loading time : " + finish.get());      // cache 로 인해 바로 실행
    }
}
