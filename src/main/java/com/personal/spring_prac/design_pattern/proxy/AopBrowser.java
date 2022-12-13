package com.personal.spring_prac.design_pattern.proxy;

public class AopBrowser implements MyBrowser{

    private String url;

    private Html html;

    private Runnable before;

    private Runnable after;


    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {

        before.run();
        if(html == null) {
            html = new Html(url);
            System.out.println("AopBrowser loading html from : " + url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        after.run();
        System.out.println("AopBrowser use cache");
        return html;
    }
}
