package com.personal.spring_prac.rest_template.client.client_service;

import com.personal.spring_prac.rest_template.client.dto.PersonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    public PersonResponse hello() {

        // Client 가 요청을 보낼 서버의 주소 uri 를 만든다.
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080") // Host
                .path("/api/server/hello")  // Path
                .queryParam("name", "Roy")   // 입력할 파라미터가 있을경우 queryParam 사용
                .queryParam("age", 30)
                .encode()                   // Parameter 가 붙을 경우를 위해 안정적으로 url 인코딩
                .build()
                .toUri();
        // 이렇게 빌드할 경우 uri 는 http://localhost:8080/api/server/hello?name=Roy&age=30

        System.out.println(uri.toString());

        RestTemplate restTemplate = new RestTemplate();
        // GET Http 메서드로 Entity 를 반환값으로 받겠다고 하는 RestTemplate 의 getForEntity.
        ResponseEntity<PersonResponse> result = restTemplate.getForEntity(uri, PersonResponse.class);

        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
        return result.getBody();
    }
}
