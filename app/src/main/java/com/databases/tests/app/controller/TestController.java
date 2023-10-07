package com.databases.tests.app.controller;

import com.databases.tests.app.services.MongoService;
import com.databases.tests.app.services.RedisService;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class TestController {

    private final RedisService userRedisService;
    private final MongoService mongoService;

    @GetMapping("/redis")
    public void getUser() {
        userRedisService.setKeyValue("testRedis", "qaw");
        System.out.println(userRedisService.getValueByKey("testRedis"));
    }

    @GetMapping("/mongo")
    public void getMongoUser() {
        Document document = new Document();
        document.put("name", "ola");
        document.put("age", 1);
        document.put("height", 1.9);
        document.put("birthDate", new Date());
        document.put("isAvailable", true);
        mongoService.createDocument(document);
        System.out.println(mongoService.findDocumentById(document.get("_id").toString()));
    }
}
