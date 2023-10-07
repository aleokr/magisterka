package com.databases.tests.app.services;

import com.databases.tests.app.data.CassandraUser;
import com.databases.tests.app.repository.CassandraUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CassandraService {

    private final CassandraUserRepository cassandraUserRepository;

    public void saveUser(CassandraUser cassandraUser) {
        cassandraUserRepository.save(cassandraUser);
    }

    public CassandraUser findUser(UUID id) {
        return cassandraUserRepository.findById(id).orElse(null);
    }

}
