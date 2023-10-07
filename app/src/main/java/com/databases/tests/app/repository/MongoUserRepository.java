package com.databases.tests.app.repository;

import com.databases.tests.app.data.MongoUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface MongoUserRepository extends MongoRepository<MongoUser, UUID> {
}
