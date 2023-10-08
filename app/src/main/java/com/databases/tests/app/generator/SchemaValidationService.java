package com.databases.tests.app.generator;

import com.databases.tests.app.data.CassandraUser;
import com.databases.tests.app.data.MongoUser;
import com.databases.tests.app.data.RedisUser;
import com.databases.tests.app.services.CassandraService;
import com.databases.tests.app.services.MongoService;
import com.databases.tests.app.services.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SchemaValidationService {

    private final CassandraService cassandraService;

    private final MongoService mongoService;

    private final RedisService redisService;

    private final ValidDataGenerator validDataGenerator;

    private final InvalidDataGenerator invalidDataGenerator;

    private final WrongTypeDataGenerator wrongTypeDataGenerator;

    public void allValidData() {
        List<CassandraUser> cassandraUsers = new ArrayList<>();
        List<MongoUser> mongoUsers = new ArrayList<>();
        List<RedisUser> redisUsers = new ArrayList<>();

        createValidUsers(cassandraUsers, mongoUsers, redisUsers, 100);

        addCassandraUsers(cassandraUsers);
        addMongoUsers(mongoUsers);
        addRedisUsers(redisUsers);
    }

    public void halfWrongData() {
        List<CassandraUser> cassandraUsers = new ArrayList<>();
        List<MongoUser> mongoUsers = new ArrayList<>();
        List<RedisUser> redisUsers = new ArrayList<>();

        createValidUsers(cassandraUsers, mongoUsers, redisUsers, 50);
        createUsersWithWrongData(cassandraUsers, mongoUsers, redisUsers, 50);

        addCassandraUsers(cassandraUsers);
        addMongoUsers(mongoUsers);
        addRedisUsers(redisUsers);
    }

    public void allWrongData() {
        List<CassandraUser> cassandraUsers = new ArrayList<>();
        List<MongoUser> mongoUsers = new ArrayList<>();
        List<RedisUser> redisUsers = new ArrayList<>();

        createUsersWithWrongData(cassandraUsers, mongoUsers, redisUsers, 100);

        addCassandraUsers(cassandraUsers);
        addMongoUsers(mongoUsers);
        addRedisUsers(redisUsers);
    }

    public void halfInvalidData() {
        List<CassandraUser> cassandraUsers = new ArrayList<>();
        List<MongoUser> mongoUsers = new ArrayList<>();
        List<RedisUser> redisUsers = new ArrayList<>();

        createValidUsers(cassandraUsers, mongoUsers, redisUsers, 50);
        createInvalidUsers(cassandraUsers, mongoUsers, redisUsers, 50);

        addCassandraUsers(cassandraUsers);
        addMongoUsers(mongoUsers);
        addRedisUsers(redisUsers);
    }

    public void allInvalidData() {
        List<CassandraUser> cassandraUsers = new ArrayList<>();
        List<MongoUser> mongoUsers = new ArrayList<>();
        List<RedisUser> redisUsers = new ArrayList<>();

        createInvalidUsers(cassandraUsers, mongoUsers, redisUsers, 100);

        addCassandraUsers(cassandraUsers);
        addMongoUsers(mongoUsers);
        addRedisUsers(redisUsers);
    }

    private void createValidUsers(List<CassandraUser> cassandraUsers, List<MongoUser> mongoUsers, List<RedisUser> redisUsers, int iteration){
        for (int i = 0; i < iteration; i++) {
            UUID id = validDataGenerator.generateId();
            String name = validDataGenerator.generateName();
            Integer age = validDataGenerator.generateAge();
            LocalDate birthDate = validDataGenerator.generateRandomBirthDate();
            Double height = validDataGenerator.generateHeight();
            Boolean isAvailable = validDataGenerator.generateIsAvailable();

            cassandraUsers.add(new CassandraUser(id, name, age, birthDate, height, isAvailable));
            mongoUsers.add(new MongoUser(id, name, age, birthDate, height, isAvailable));
            redisUsers.add(new RedisUser(id, name, age, birthDate, height, isAvailable));
        }
    }

    private void createUsersWithWrongData(List<CassandraUser> cassandraUsers, List<MongoUser> mongoUsers, List<RedisUser> redisUsers, int iteration){
        for (int i = 0; i < iteration; i++) {
            UUID id = validDataGenerator.generateId();
            Double name = wrongTypeDataGenerator.generateName();
            String age = wrongTypeDataGenerator.generateAge();
            Boolean birthDate = wrongTypeDataGenerator.generateBirthDate();
            String height = wrongTypeDataGenerator.generateHeight();
            Double isAvailable = wrongTypeDataGenerator.generateIsAvailable();

            cassandraUsers.add(new CassandraUser(id, name, age, birthDate, height, isAvailable));
            mongoUsers.add(new MongoUser(id, name, age, birthDate, height, isAvailable));
            redisUsers.add(new RedisUser(id, name, age, birthDate, height, isAvailable));
        }
    }

    private void createInvalidUsers(List<CassandraUser> cassandraUsers, List<MongoUser> mongoUsers, List<RedisUser> redisUsers, int iteration){
        for (int i = 0; i < iteration; i++) {
            UUID id = validDataGenerator.generateId();
            String name = invalidDataGenerator.generateName();
            Integer age = invalidDataGenerator.generateAge();
            LocalDate birthDate = validDataGenerator.generateRandomBirthDate();
            Double height = invalidDataGenerator.generateHeight();
            Boolean isAvailable = validDataGenerator.generateIsAvailable();

            cassandraUsers.add(new CassandraUser(id, name, age, birthDate, height, isAvailable));
            mongoUsers.add(new MongoUser(id, name, age, birthDate, height, isAvailable));
            redisUsers.add(new RedisUser(id, name, age, birthDate, height, isAvailable));
        }
    }

    private void addCassandraUsers(List<CassandraUser> cassandraUsers){
        for (CassandraUser cassandraUser : cassandraUsers) {
            try {
                cassandraService.saveUser(cassandraUser);
                // increase valid prometheus metric
            } catch (Exception e){
                //increase invalid prometheus metric
            }
        }
    }

    private void addMongoUsers(List<MongoUser> mongoUsers){
        for (MongoUser mongoUser : mongoUsers) {
            try {
                mongoService.saveUser(mongoUser);
                // increase valid prometheus metric
            } catch (Exception e){
                //increase invalid prometheus metric
            }
        }
    }

    private void addRedisUsers(List<RedisUser> redisUsers){
        for (RedisUser redisUser : redisUsers) {
            try {
                redisService.saveUser(redisUser);
                // increase valid prometheus metric
            } catch (Exception e){
                //increase invalid prometheus metric
            }
        }
    }

}
