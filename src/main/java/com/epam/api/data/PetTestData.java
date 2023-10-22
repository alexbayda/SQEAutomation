package com.epam.api.data;

import com.epam.models.Category;
import com.epam.models.Tag;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PetTestData {

    @DataProvider(name = "petData")
    public Object[][] petDataProvider() {
        return new Object[][]{generateRandomPetData()};
    }

    //move all these generations into UTILS

    private Object[] generateRandomPetData() {
        Category category = generateRandomCategory();
        String name = generateRandomString();
        List<String> photoUrls = generateRandomPhotoUrls();
        List<Tag> tags = generateRandomTags();
        String status = generateRandomString();

        return new Object[]{category, name, photoUrls, tags, status};
    }

    private Category generateRandomCategory() {
        Random random = new Random();
        int categoryId = random.nextInt(1000);
        String categoryName = "Category" + categoryId;
        return new Category(categoryId, categoryName);
    }

    public String generateRandomString() {
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

    public List<String> generateRandomPhotoUrls() {
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


    private List<Tag> generateRandomTags() {
        Random random = new Random();
        List<Tag> tags = new ArrayList<>();
        tags.add(new Tag(random.nextInt(1000), "Tag1"));
        tags.add(new Tag(random.nextInt(1000), "Tag2"));
        return tags;
    }
}
