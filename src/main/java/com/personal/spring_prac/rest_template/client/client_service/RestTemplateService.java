package com.personal.spring_prac.rest_template.client.client_service;

import com.personal.spring_prac.rest_template.client.dto.PersonRequest;
import com.personal.spring_prac.rest_template.client.dto.PersonResponse;
import com.personal.spring_prac.rest_template.server.dto.Person;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateService {

    // GET 메서드 예제
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

    // POST 메서드 예제
    public PersonResponse hi() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080")
                .path("/api/server/person/{personId}/name/{personName}")
                .encode()
                .build()
                .expand(200, "Roy")     // expand 로 RequestBody 를 추가
                .toUri();
        // 해당 빌드의 경우 uri 주소는 http://localhost:8080/api/server/person/{personId}/name/{personName}
        System.out.println(uri);


        PersonRequest request = new PersonRequest();
        request.setName("Roy");
        request.setAge(30);

        RestTemplate restTemplate = new RestTemplate();
        // postForEntity 를 사용해 uri 주소에 request 를 바디에 담아보내고 응답은 PersonResponse 로 받을것이다
        ResponseEntity<PersonResponse> response = restTemplate.postForEntity(uri, request, PersonResponse.class);

        System.out.println(response.getStatusCode());
        System.out.println(response.getHeaders());
        System.out.println(response.getBody());

        return response.getBody();

        // http body -> object -> objectMapper -> json -> restTemplate -> http body json
    }

    public PersonResponse exchange() {

        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:8080")
                .path("/api/server/person/{personId}/name/{personName}")
                .encode()
                .build()
                .expand(200, "Roy")     // expand 로 RequestBody 를 추가
                .toUri();

        System.out.println(uri);


        // 보낼때는 RequestEntity 사용
        PersonRequest request = new PersonRequest();
        request.setName("Roy");
        request.setAge(30);

        RequestEntity<PersonRequest> reqEntity = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)        // contentType 은 JSON
                .header("x-Authorization","abcd")   // header 로 header 값 주입
                .header("custom-header","1234")
                .body(request);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<PersonResponse> response = restTemplate.exchange(reqEntity, PersonResponse.class);

        return response.getBody();
    }
}
