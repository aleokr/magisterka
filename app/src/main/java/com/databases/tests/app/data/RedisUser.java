package com.databases.tests.app.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.UUID;

@RedisHash("users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RedisUser {
    @Id
    private UUID id;

    private Object name;

    private Object age;

    private Object birthDate;

    private Object height;

    private Object isAvailable;
}