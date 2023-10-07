package com.databases.tests.app.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public void setKeyValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public Object getValueByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

}