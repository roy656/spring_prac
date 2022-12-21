package com.personal.spring_prac.aop.aop_class;

import com.personal.spring_prac.aop.dto.UserDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class DecodeAop {

    @Pointcut("execution(* com.personal.spring_prac.aop.aop_controller..*.*(..))")
    public void cut() {
    }

    @Pointcut("@annotation( com.personal.spring_prac.aop.annotation.Decode)")
    public void decode() {
    }

    @Before("cut() && decode()")
    public void before(JoinPoint joinPoint) throws UnsupportedEncodingException {
        Object[] args = joinPoint.getArgs(); // args 즉, 메서드의 파라미터들 중에

        for (Object arg : args) {
            if (arg instanceof UserDto) {   // 내가 원하는 userDto 라는 클래스가 있으면
                UserDto userDto = (UserDto) arg;  // userDto 로 형변환
                String base64Email = userDto.getEmail();    // 인코딩 되어있는 이메일을 가져온다
                String email = new String(Base64.getDecoder().decode(base64Email), "UTF-8");   // 디코딩을 한다
                userDto.setEmail(email);    // 이메일을 다시 set 해 준다
            }
        }
    }   // AOP 를 이용해서 메서드 실행 전 미리 디코딩을 해주면 실제 컨트롤러에서 디코딩을 할 필요가 없어진다.

    @AfterReturning(value = "cut() && decode()", returning = "returnObj")
    public void afterReturn(JoinPoint joinPoint, Object returnObj) {

        // userDto 를 찾아서 반대로 평문 email 을 인코딩 후 set 해준다.
        if( returnObj instanceof UserDto) {
            UserDto userDto = (UserDto) returnObj;
            String email = userDto.getEmail();
            String base64Email = Base64.getEncoder().encodeToString(email.getBytes());
            userDto.setEmail(base64Email);
        }
    }
}
