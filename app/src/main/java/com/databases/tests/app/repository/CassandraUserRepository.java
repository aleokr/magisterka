package com.databases.tests.app.repository;

import com.databases.tests.app.data.CassandraUser;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CassandraUserRepository extends CassandraRepository<CassandraUser, UUID> {
}

