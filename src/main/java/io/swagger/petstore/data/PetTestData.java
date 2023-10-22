package io.swagger.petstore.data;

import org.testng.annotations.DataProvider;

import static utils.RandomGenerator.generateRandomPetData;

public class PetTestData {

    @DataProvider(name = "petData")
    public Object[][] petDataProvider() {
        return new Object[][]{generateRandomPetData()};
    }
}
