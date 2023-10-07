package com.databases.tests.app.controller;

import com.databases.tests.app.data.CassandraUser;
import com.databases.tests.app.data.MongoUser;
import com.databases.tests.app.data.RedisUser;
import com.databases.tests.app.services.CassandraService;
import com.databases.tests.app.services.MongoService;
import com.databases.tests.app.services.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class TestController {

    private final RedisService userRedisService;
    private final MongoService mongoService;
    private final CassandraService cassandraService;

    @GetMapping("/redis")
    public void getUser() {
        UUID id = UUID.randomUUID();
        RedisUser redisUser = new RedisUser(id, "Sebuszek", 26, new Date(), 1.8, true);
        userRedisService.saveUser(redisUser);
        System.out.println(userRedisService.findUser(id));
    }

    @GetMapping("/mongo")
    public void getMongoUser() {
        UUID id = UUID.randomUUID();
        MongoUser mongoUser = new MongoUser(id, "Sebuszek", 26, new Date(), 1.8, true);
        mongoService.saveUser(mongoUser);
        System.out.println(mongoService.findUser(id));
    }

    @GetMapping("/cassandra")
    public void getCassandraUser() {
        UUID id = UUID.randomUUID();
        CassandraUser cassandraUser = new CassandraUser(id, "Sebuszek", 26, null, 1.8, true);
        cassandraService.saveUser(cassandraUser);
        System.out.println(cassandraService.findUser(id));
    }
}
