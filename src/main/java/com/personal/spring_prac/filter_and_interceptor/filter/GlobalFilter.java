package com.personal.spring_prac.filter_and_interceptor.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
// @WebFilter(urlPatterns = "/api/temp/*")  // 특정 클래스나 컨트롤러에만 적용시키고 싶을때 @WebFilter 로 사용
public class GlobalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        // 전처리 구간
        // 여러번 읽을수 있게 캐싱해둔것을 반환하는 ContentCachingRequestWrapper 으로 생성하여 사용
        ContentCachingRequestWrapper httpServletRequest = new ContentCachingRequestWrapper((HttpServletRequest) request);
        ContentCachingResponseWrapper httpServletResponse = new ContentCachingResponseWrapper((HttpServletResponse) response);

        String url = httpServletRequest.getRequestURI();


        // doFilter 를 통해서 실제 내부 스프링으로 들어가 해당 메서드가 실행되고 request 의 내용이 getContentAsByteArray 안에 담기게되어 읽을수있다.
        chain.doFilter(httpServletRequest, httpServletResponse); // diFilter 기준으로 전,후 처리

        // 후처리 구간
        String reqContent = new String(httpServletRequest.getContentAsByteArray());
        log.info("request url : {}, request body : {}", url, reqContent);

        String resContent = new String(httpServletResponse.getContentAsByteArray());
        int httpStatus = httpServletResponse.getStatus();

        httpServletResponse.copyBodyToResponse();       // resContent 가 다 읽혀서 읽을 내용이 없어지기 때문에
                                                        // copy 를 해줘야 클라이언트가 제대로 된 응답을 받을수 있다.

        log.info("response status : {}, response body : {}", httpStatus, resContent);
    }

}
