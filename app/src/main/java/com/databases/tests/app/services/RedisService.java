package com.databases.tests.app.services;


import com.databases.tests.app.data.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisTemplate<String, User> userRedisTemplate;

    public void savePerson(String id, User person) {
        userRedisTemplate.opsForValue().set(id, person);
    }

    public User getPerson(String id) {
        return userRedisTemplate.opsForValue().get(id);
    }

    public void updatePerson(String id, User person) {
        userRedisTemplate.opsForValue().set(id, person);
    }

    public void deletePerson(String id) {
        userRedisTemplate.delete(id);
    }
}
