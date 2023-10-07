package com.databases.tests.app.repository;

import com.databases.tests.app.data.RedisUser;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RedisUserRepository extends CrudRepository<RedisUser, UUID> {
}
