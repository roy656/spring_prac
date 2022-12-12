package com.personal.spring_prac.design_pattern.proxy;

public class BrowserProxy implements MyBrowser{

    private String url;
    private Html html;

    public BrowserProxy(String url) {
        this.url = url;
    }
    @Override
    public Html show() {

        // 캐싱 되어있는 html 이 없다면 새로 생성하여 리턴.
        if(html == null) {
            this.html = new Html(url);
            System.out.println("BrowserProxy loading html from : " + url);
        }

        // 캐싱 되어있는 프록시 객체가 있다면 그대로 사용.
        System.out.println("BrowserProxy use cache html : " + url);
        return html;
    }
}
