package com.databases.tests.app.generator;

import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class InvalidDataGenerator {
    public String generateName() {
        // Determine if the name should be short (0-2) or long (21-30)
        boolean isShortName = ThreadLocalRandom.current().nextBoolean();
        int length;

        if (isShortName) {
            length = ThreadLocalRandom.current().nextInt(0, 3); // Generate length between 0 and 2
        } else {
            length = ThreadLocalRandom.current().nextInt(21, 31); // Generate length between 21 and 30
        }

        StringBuilder name = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int ascii = ThreadLocalRandom.current().nextInt(52);
            char ch = (char) ((ascii < 26) ? ascii + 'A' : ascii - 26 + 'a');
            name.append(ch);
        }

        return name.toString();
    }

    public Integer generateAge() {
        // Determine if the age should be negative (<0) or large (>120)
        boolean isNegativeAge = ThreadLocalRandom.current().nextBoolean();
        int age;

        if (isNegativeAge) {
            age = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, 0); // Generate negative age
        } else {
            age = ThreadLocalRandom.current().nextInt(121, Integer.MAX_VALUE); // Generate large age
        }

        return age;
    }

    public Double generateHeight() {
        boolean isNegative = ThreadLocalRandom.current().nextBoolean();
        double result;

        if (isNegative) {
            // Generate negative double (less than 0)
            result = -ThreadLocalRandom.current().nextDouble(1, 100); // Adjust range as needed
        } else {
            // Generate large double (greater than 3)
            result = ThreadLocalRandom.current().nextDouble(4, 100); // Adjust range as needed
        }

        return result;
    }
}
