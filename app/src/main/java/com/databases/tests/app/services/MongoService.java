package com.databases.tests.app.services;

import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MongoService {

    private final MongoTemplate mongoTemplate;

    private final static String collectionName = "users";

    public void createDocument(Document document) {
        mongoTemplate.save(document, collectionName);
    }

    public Document findDocumentById(String id) {
        return mongoTemplate.findById(id, Document.class, collectionName);
    }

}
