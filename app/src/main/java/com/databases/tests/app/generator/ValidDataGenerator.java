package com.databases.tests.app.generator;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ValidDataGenerator {

    public UUID generateId() {
        return UUID.randomUUID();
    }

    public String generateName() {
        int length = ThreadLocalRandom.current().nextInt(2, 21); // Generate length between 2 and 20
        StringBuilder name = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            // Generate random ASCII value for letters (a-z, A-Z)
            int ascii = ThreadLocalRandom.current().nextInt(52);
            char ch = (char) ((ascii < 26) ? ascii + 'A' : ascii - 26 + 'a');
            name.append(ch);
        }

        return name.toString();
    }

    public Integer generateAge() {
        return ThreadLocalRandom.current().nextInt(0, 120); // Assumes age range 18-99
    }

    public LocalDate generateRandomBirthDate() {
        int currentYear = LocalDate.now().getYear();
        int startYear = currentYear - 120;

        int randomYear = ThreadLocalRandom.current().nextInt(startYear, currentYear + 1);
        int randomMonth = ThreadLocalRandom.current().nextInt(1, 13);
        int randomDayOfMonth = ThreadLocalRandom.current().nextInt(1, 29); // Simplification
        return LocalDate.of(randomYear, randomMonth, randomDayOfMonth);
    }

    public Double generateHeight() {
        return ThreadLocalRandom.current().nextDouble(0, 3.0); // Assumes height range 0m-3m
    }

    public Boolean generateIsAvailable() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
