//package com.databases.tests.app.services;
//
//import com.databases.tests.app.data.GenericEntity;
//import com.databases.tests.app.repository.CassandraUserRepository;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class CassandraService {
//
//    private final CassandraUserRepository repository;
//    private final ObjectMapper objectMapper = new ObjectMapper();
//
//    public GenericEntity save(String id, Object object) {
//        try {
//            String jsonData = objectMapper.writeValueAsString(object);
//            GenericEntity entity = new GenericEntity(id, jsonData);
//            return repository.save(entity);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException("Failed to convert object to JSON", e);
//        }
//    }
//
//    public <T> T find(String id, Class<T> clazz) {
//        GenericEntity entity = repository.findById(id).orElse(null);
//        if (entity == null) {
//            return null;
//        }
//        try {
//            return objectMapper.readValue(entity.getJsonData(), clazz);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException("Failed to convert JSON to object", e);
//        }
//    }
//}
