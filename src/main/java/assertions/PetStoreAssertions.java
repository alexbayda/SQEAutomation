package assertions;

import models.Pet;
import org.testng.Assert;

public class PetStoreAssertions {

    public static void assertPetPropertiesEqual(Pet expected, Pet actual) {
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPhotoUrls(), actual.getPhotoUrls());
        Assert.assertEquals(expected.getTags(), actual.getTags());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }

    public static void assertPetPropertiesNotEqualPhotosUrl(Pet expected, Pet actual) {
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertNotEquals(expected.getPhotoUrls(), actual.getPhotoUrls());
        Assert.assertEquals(expected.getTags(), actual.getTags());
        Assert.assertEquals(expected.getStatus(), actual.getStatus());
    }

    public static void assertPetPropertiesNotEqualNameAndStatus(Pet expected, Pet actual) {
        Assert.assertEquals(expected.getCategory(), actual.getCategory());
        Assert.assertNotEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getPhotoUrls(), actual.getPhotoUrls());
        Assert.assertEquals(expected.getTags(), actual.getTags());
        Assert.assertNotEquals(expected.getStatus(), actual.getStatus());
    }
}
