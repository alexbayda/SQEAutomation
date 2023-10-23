package apitests;

import dataproviders.PetTestData;
import models.Category;
import models.Pet;
import models.Tag;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.util.List;

import static assertions.PetStoreAssertions.*;
import static builders.JsonObjectBuilder.buildStandardPet;
import static utils.RandomGenerator.generateRandomPhotoUrls;
import static utils.RandomGenerator.generateRandomString;

@Slf4j
public class PetApiTests extends BaseTest {

    @Test(dataProvider = "petData", dataProviderClass = PetTestData.class)
    public void addNewPet(Category category, String name,
                          List<String> photoUrls, List<Tag> tags, String status) {
        Pet pet = buildStandardPet(category, name, photoUrls, tags, status);
        Pet createdPet = petController.createEntity(pet, Pet.class);
        assertPetPropertiesEqual(pet, createdPet);
    }

    @Test(dataProvider = "petData", dataProviderClass = PetTestData.class)
    public void updatePetImage(Category category, String name,
                               List<String> photoUrls, List<Tag> tags, String status) {
        Pet pet = buildStandardPet(category, name, photoUrls, tags, status);
        Pet createdPet = petController.createEntity(pet, Pet.class);
        long petId = createdPet.getId();
        List<String> newPhotoUrls = generateRandomPhotoUrls();
        Pet updatedPet = Pet.builder()
                .id(petId)
                .category(category)
                .name(name)
                .photoUrls(newPhotoUrls)
                .tags(tags)
                .status(status)
                .build();

        petController.updateEntity(createdPet, Pet.class);
        assertPetPropertiesNotEqualPhotosUrl(createdPet, updatedPet);
    }

    @Test(dataProvider = "petData", dataProviderClass = PetTestData.class)
    public void updatePetNameAndStatus(Category category, String name,
                               List<String> photoUrls, List<Tag> tags, String status) {
        Pet pet = buildStandardPet(category, name, photoUrls, tags, status);
        Pet createdPet = petController.createEntity(pet, Pet.class);
        long petId = createdPet.getId();
        String updatedName = generateRandomString();
        String updatedStatus = generateRandomString();
        Pet updatedPet = Pet.builder()
                .id(petId)
                .category(category)
                .name(updatedName)
                .photoUrls(photoUrls)
                .tags(tags)
                .status(updatedStatus)
                .build();

        petController.updateEntity(createdPet, Pet.class);
        assertPetPropertiesNotEqualNameAndStatus(createdPet, updatedPet);
    }

    @Test(dataProvider = "petData", dataProviderClass = PetTestData.class)
    public void deletePet(Category category, String name,
                                       List<String> photoUrls, List<Tag> tags, String status) {
        Pet pet = buildStandardPet(category, name, photoUrls, tags, status);
        Pet createdPet = petController.createEntity(pet, Pet.class);
        long petId = createdPet.getId();
        petController.deleteEntity(petId);
    }
}
