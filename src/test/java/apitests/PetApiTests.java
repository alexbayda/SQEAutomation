package apitests;

import com.epam.api.data.PetTestData;
import com.epam.models.Category;
import com.epam.models.Pet;
import com.epam.models.Tag;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.util.List;

import static com.epam.api.data.PetBuilder.buildPet;

@Slf4j
public class PetApiTests extends BaseTest {

    @Test(dataProvider = "petData", dataProviderClass = PetTestData.class)
    public void addNewPet(Category category, String name,
                          List<String> photoUrls, List<Tag> tags, String status) {
        Pet pet = buildPet(category, name, photoUrls, tags, status);
        Pet createdPet = petController.createEntity(pet, Pet.class);
        assertPetProperties(pet, createdPet);
    }

    private void assertPetProperties(Pet expected, Pet actual) {
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPhotoUrls(), actual.getPhotoUrls());
        Assert.assertEquals(expected.getTags(), actual.getTags());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test(dataProvider = "petData", dataProviderClass = PetTestData.class)
    public void updatePetImage(Category category, String name,
                               List<String> photoUrls, List<Tag> tags, String status) {
        Pet pet = buildPet(category, name, photoUrls, tags, status);
        Pet createdPet = petController.createEntity(pet, Pet.class);
        long petId = createdPet.getId();
        PetTestData petTestData = new PetTestData();
        List<String> newPhotoUrls = petTestData.generateRandomPhotoUrls();
        Pet updatedPet = Pet.builder()
                .id(petId)
                .category(category)
                .name(name)
                .photoUrls(newPhotoUrls)
                .tags(tags)
                .status(status).build();

        petController.updateEntity(createdPet, Pet.class);
        assertPetPropertiesExceptPhotosUrl(createdPet, updatedPet);
    }

    private void assertPetPropertiesExceptPhotosUrl(Pet expected, Pet actual) {
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertNotEquals(expected.getPhotoUrls(), actual.getPhotoUrls());
        Assert.assertEquals(expected.getTags(), actual.getTags());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }

    @Test(dataProvider = "petData", dataProviderClass = PetTestData.class)
    public void updatePetNameAndStatus(Category category, String name,
                               List<String> photoUrls, List<Tag> tags, String status) {
        Pet pet = buildPet(category, name, photoUrls, tags, status);
        Pet createdPet = petController.createEntity(pet, Pet.class);
        long petId = createdPet.getId();
        PetTestData petTestData = new PetTestData();
        String updatedName = petTestData.generateRandomString();
        String updatedStatus = petTestData.generateRandomString();
        Pet updatedPet = Pet.builder()
                .id(petId)
                .category(category)
                .name(updatedName)
                .photoUrls(photoUrls)
                .tags(tags)
                .status(updatedStatus)
                .build();

        petController.updateEntity(createdPet, Pet.class);
        assertPetPropertiesExceptNameAndStatus(createdPet, updatedPet);
    }
    private void assertPetPropertiesExceptNameAndStatus(Pet expected, Pet actual) {
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
        Assert.assertNotEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPhotoUrls(), actual.getPhotoUrls());
        Assert.assertEquals(expected.getTags(), actual.getTags());
        Assert.assertNotEquals(expected.getStatus(), actual.getStatus());
    }

    @Test(dataProvider = "petData", dataProviderClass = PetTestData.class)
    public void deletePet(Category category, String name,
                                       List<String> photoUrls, List<Tag> tags, String status) {
        Pet pet = buildPet(category, name, photoUrls, tags, status);
        Pet createdPet = petController.createEntity(pet, Pet.class);
        long petId = createdPet.getId();
        petController.deleteEntity(petId);
    }
}
