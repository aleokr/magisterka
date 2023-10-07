package com.databases.tests.app.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CassandraUser {

    @PrimaryKey
    private UUID id;

    private Object name;

    private Object age;

    private Object birthDate;

    private Object height;

    private Object isAvailable;
}
