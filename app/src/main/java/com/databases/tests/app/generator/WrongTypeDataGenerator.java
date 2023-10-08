package com.databases.tests.app.generator;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class WrongTypeDataGenerator {
    public Double generateName() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public String generateAge() {
        return "InvalidAge";
    }

    public Boolean generateBirthDate() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public String generateHeight() {
        return "InvalidHeight";
    }

    public Double generateIsAvailable() {
        return ThreadLocalRandom.current().nextDouble();
    }
}
