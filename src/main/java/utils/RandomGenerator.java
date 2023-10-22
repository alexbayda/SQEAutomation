package utils;

import models.Category;
import models.Tag;
import models.User;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
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

    public static List<User> generateRandomListOfUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(generateRandomUser());
        }
        return users;
    }

    private static List<Tag> generateRandomTags() {
        Random random = new Random();
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(random.nextInt(1000), "Tag1"));
        tags.add(new Tag(random.nextInt(1000), "Tag2"));
        return tags;
    }

    public static List<String> generateRandomPhotoUrls() {
        List<String> randomUrls = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            String randomWord1 = RandomStringUtils.randomAlphabetic(random.nextInt(6) + 5).toLowerCase();
            String randomWord2 = RandomStringUtils.randomAlphabetic(random.nextInt(6) + 5).toLowerCase();
            String url = "https://" + randomWord1 + ".com/" + randomWord2 + "_photo";
            randomUrls.add(url);
        }
        return randomUrls;
    }

    public static String generateRandomString() {
        int length = 5;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder randomName = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomName.append(randomChar);
        }

        return randomName.toString();
    }

    public static Category generateRandomCategory() {
        Random random = new Random();
        int categoryId = random.nextInt(1000);
        String categoryName = "Category" + categoryId;
        return new Category(categoryId, categoryName);
    }

    public static Object[] generateRandomPetData() {
        Category category = generateRandomCategory();
        String name = generateRandomString();
        List<String> photoUrls = generateRandomPhotoUrls();
        List<Tag> tags = generateRandomTags();
        String status = generateRandomString();

        return new Object[]{category, name, photoUrls, tags, status};
    }
}