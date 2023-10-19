package com.epam.utils;

import org.apache.commons.lang3.RandomStringUtils;

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

}