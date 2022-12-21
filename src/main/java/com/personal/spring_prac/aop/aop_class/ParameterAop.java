package com.personal.spring_prac.aop.aop_class;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class ParameterAop {

    // 보통 특정 컨트롤러, 서비스, 패키지 하위 등으로 설정 한다
    @Pointcut("execution(* com.personal.spring_prac.aop.aop_controller..*.*(..))")
    public void cut() {
    }

    // () 안의 cut() 메서드에 설정한 위치의 메서드들이 실행되기 전에 실행
    @Before("cut()")
    public void before(JoinPoint joinPoint) {

        // 어떤 메서드가 실행 되었는지 메서드 이름을 가져온다
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println(method.getName());

        // 메서드 실행시 주입된 파라미터 들을 가져와 하나씩 찍어준다
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("type : " + obj.getClass().getSimpleName());
            System.out.println("value : " + obj);
        }
    }

    // () 안의 cut() 메서드에 설정한 위치의 메서드들이 실행 된 후의 반환값을 얻는다
    @AfterReturning(value = "cut()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {

        System.out.println("return object");
        System.out.println(returnObj);
    }

}
