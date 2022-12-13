package com.personal.spring_prac.design_pattern.Observer;

public class Button {

    private String name;

    private IButtonListener iButtonListener;

    public Button(String name) {
        this.name = name;
    }

    public void click(String message) {
        iButtonListener.clickEvent(message);    // 메서드가 실행되면 버튼 리스너의 클릭이벤트 로 메세지를 넘겨준
    }

    public void addListener(IButtonListener iButtonListener) {
        this.iButtonListener = iButtonListener;
    }
}
