package com.databases.tests.app.services;

import com.databases.tests.app.data.MongoUser;
import com.databases.tests.app.repository.MongoUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MongoService {

    private final MongoUserRepository mongoRepository;

    public void saveUser(MongoUser mongoUser) {
        mongoRepository.save(mongoUser);
    }

    public MongoUser findUser(UUID id) {
        return mongoRepository.findById(id).orElse(null);
    }

}
