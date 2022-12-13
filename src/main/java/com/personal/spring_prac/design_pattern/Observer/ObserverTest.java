package com.personal.spring_prac.design_pattern.Observer;

// Observer pattern 은 변화가 일어났을때 미리 등록된 다른 클래스에 통보해주는 패턴을 구현한다.
// 주로 Event Listener 에서 해당 패턴을 사용 하고 있다.

public class ObserverTest {

    public static void main(String[] args) {

        Button button = new Button("Button!");

        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {      // 2. 리스너의 clickEvent 가 메세지를 전달 받고 출력함.
                System.out.println(event);
            }
        });

        button.click("Message : Hello World 1");        // 1. 버튼의 클릭이 실행 되면 해당 메세지가 리스너에게 전달됨
        button.click("Message : Hello World 2");
        button.click("Message : Hello World 3");
        button.click("Message : Hello World 4");


    }
}
