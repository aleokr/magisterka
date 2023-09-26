package com.databases.tests.app.controller;

import com.databases.tests.app.data.User;
import com.databases.tests.app.services.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class TestController {

    private final RedisService userRedisService;

    @GetMapping
    public User getUser() {
        User user = new User("1", "John Smith");
        userRedisService.savePerson("1", user);
        return userRedisService.getPerson("1");
    }
}
