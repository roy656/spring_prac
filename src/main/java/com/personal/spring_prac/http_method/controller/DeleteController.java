package com.personal.spring_prac.http_method.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DeleteController {

    // Delete 는 실행 후 항상 삭제된 상태 이기 때문에 멱등성 유지
    @DeleteMapping("/delete/{userId}")
    public void delete(@PathVariable(name = "userId") Long id, @RequestParam String account) {

        System.out.println(id);
        System.out.println(account);
    }
}
