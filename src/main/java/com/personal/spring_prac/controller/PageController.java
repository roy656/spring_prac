package com.personal.spring_prac.controller;

import com.personal.spring_prac.dto.ResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 페이지를 내려주는 API
@Controller
public class PageController {

    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }

    // ResponseEntity<> 사용

    @ResponseBody
    @GetMapping("/response")
    public ResponseDto responseDto() {

        var response = new ResponseDto();

        response.setName("Olivia");
        response.setAge(25);
        response.setAddress("qwer");

        return response;
    }


}
