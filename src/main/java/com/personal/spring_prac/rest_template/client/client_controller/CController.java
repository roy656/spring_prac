package com.personal.spring_prac.rest_template.client.client_controller;

import com.personal.spring_prac.rest_template.client.client_service.RestTemplateService;
import com.personal.spring_prac.rest_template.client.dto.PersonResponse;
import com.personal.spring_prac.rest_template.client.dto.Req;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class CController {

    // 생성자로 RestTemplateService DI 주입
    private final RestTemplateService restTemplateService;

    public CController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/hello")
    public PersonResponse hello() {

        return restTemplateService.hello();
    }

    @GetMapping("/hi")
    public PersonResponse hi() {
        return restTemplateService.hi();
    }

    @GetMapping("/exchange")
    public PersonResponse exchange() {
        return restTemplateService.exchange();
    }

    @GetMapping("/exchange")
    public Req<PersonResponse> genericExchange() {
        return restTemplateService.genericExchange();
    }

}
