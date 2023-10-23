package dataproviders;

import org.testng.annotations.DataProvider;

import static utils.RandomGenerator.generateRandomPetData;

public class PetTestData {

    @DataProvider(name = "petData")
    public Object[][] petDataProvider() {
        return new Object[][]{generateRandomPetData()};
    }
}
