package com.personal.spring_prac.exception.controller;


import com.personal.spring_prac.exception.dto.Player;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class EController {

    @GetMapping("/player")
    public Player get(@RequestParam(required = false) String name, @RequestParam(required = false) Integer age) {
        Player player = new Player();
        player.setName(name);
        player.setAge(age);

        int a = 10 + age;
        return player;
    }

    @PostMapping("/player")
    public Player post(@Valid @RequestBody Player player) {

        System.out.println(player);
        return player;
    }
}
