package com.personal.spring_prac.design_pattern.proxy;

public class AopBrowser implements MyBrowser{

    private String url;

    private Html html;

    private Runnable before;

    private Runnable after;


    public AopBrowser() {
    }

    @Override
    public Html show() {

        if(html == null) {
            html = new Html(url);
            System.out.println("AopBrowser loading html from : " + url);
        }

        System.out.println("AopBrowser use cache");
        return html;
    }
}
