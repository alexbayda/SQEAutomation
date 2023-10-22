package com.epam.utils;

import com.epam.models.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomUserGenerator {
    public static String getRandomGeneratedEmail() {
        return RandomStringUtils.randomAlphabetic(5) +
                "@" +
                RandomStringUtils.randomAlphabetic(3) +
                ".com";
    }
    public static String getRandomGenerateUser() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public static User generateRandomUser() {
        Random random = new Random();
        String userName = "user" + random.nextInt(1000);
        String firstName = "FirstName" + random.nextInt(1000);
        String lastName = "LastName" + random.nextInt(1000);
        String email = "user" + random.nextInt(1000) + "@example.com";
        String password = "password" + random.nextInt(1000);
        String phone = "123456789" + random.nextInt(10);
        int userStatus = random.nextInt(2);

        return User.builder()
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .phone(phone)
                .userStatus(userStatus)
                .build();
    }

}