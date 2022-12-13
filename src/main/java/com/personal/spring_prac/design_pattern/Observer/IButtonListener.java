package com.personal.spring_prac.design_pattern.Observer;

public interface IButtonListener {

    void clickEvent(String event);      // 버튼에 대한 클릭이 일어나면 이벤트를 받을수 있게 하는 메서드
}
