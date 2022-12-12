package com.personal.spring_prac.design_pattern.proxy;

public class ProxyTest {

    public static void main(String[] args) {

        MyBrowser myBrowser = new BrowserProxy("www.google.com");
        myBrowser.show();   // 처음에만 html 객체를 생성하고
        myBrowser.show();   // 그 이후로는 캐싱 된 html 을 내려준다.
        myBrowser.show();
        myBrowser.show();

    }
}
