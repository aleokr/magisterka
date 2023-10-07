package com.databases.tests.app.services;

import com.databases.tests.app.data.RedisUser;
import com.databases.tests.app.repository.RedisUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final RedisUserRepository redisUserRepository;

    public void saveUser(RedisUser redisUser) {
        redisUserRepository.save(redisUser);
    }

    public RedisUser findUser(UUID id) {
        return redisUserRepository.findById(id).orElse(null);
    }

}