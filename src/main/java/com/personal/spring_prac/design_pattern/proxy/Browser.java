package com.personal.spring_prac.design_pattern.proxy;

public class Browser implements MyBrowser{

    private String url;

    public Browser(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        System.out.println("Browser loading html from : " + url);
        return new Html(url);
    }
}
