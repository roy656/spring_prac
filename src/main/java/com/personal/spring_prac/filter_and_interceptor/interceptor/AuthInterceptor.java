package com.personal.spring_prac.filter_and_interceptor.interceptor;

import com.personal.spring_prac.filter_and_interceptor.interceptor.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        ContentCachingRequestWrapper cRequest = (ContentCachingRequestWrapper) request;

        String url = cRequest.getRequestURI();
        URI uri = UriComponentsBuilder.fromUriString(request.getRequestURI())
                .query(request.getQueryString())
                .build()
                .toUri();

        log.info("request url : {}", url);

        boolean hasAnnotation = checkAnnotation(handler, Auth.class);
        log.info("Has annotation : {}", hasAnnotation);

        // 서버는 전부 public 으로 동작을 하지만
        // Auth 권한을 가진 요청에 대해서
        if (hasAnnotation) {
            // 권한체크
            String query = uri.getQuery();
            if(query.equals("name=roy")) {
                return true;
            }
            throw new AuthException();
        }

        return true;
    }

    private boolean checkAnnotation(Object handler, Class clazz) {

        //
        if (handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // Annotation check
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if (null != handlerMethod.getMethodAnnotation(clazz) || null != handlerMethod.getBeanType().getAnnotation(clazz)) {

            // Auth 어노테이션이 있을경우 true
            return true;
        }
        return false;
    }
}
