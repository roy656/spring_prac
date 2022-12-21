package com.personal.spring_prac.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class TimerAop {

    @Pointcut("execution(* com.personal.spring_prac.aop.aop_controller..*.*(..))")
    public void cut() {
    }

    // 해당 패키지 하위에 있는 Timer 라는 어노테이션이 붙은 메서드에만 적용 시킨
    @Pointcut("@annotation(com.personal.spring_prac.aop.annotation.Timer)")
    public void enableTimer() {
    }

    @Around("cut() && enableTimer()") // 이 두가지 조건을 같이 쓰겠다는 설정
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();  // 메서드 실행 전 스탑워치 시작
        stopWatch.start();

        Object result = joinPoint.proceed();    // 메서드가 실행되는 때

        stopWatch.stop();                       // 메서드 끝난 후 스탑워치 종료

        System.out.println("elapsed time : " + stopWatch.getTotalTimeSeconds());    // 경과 시간 출력
    }

}
