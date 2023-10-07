package com.databases.tests.app.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MongoUser {
    @Id
    private UUID id;

    private Object name;

    private Object age;

    private Object birthDate;

    private Object height;

    private Object isAvailable;
}
