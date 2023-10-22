package com.epam.api.data;

import com.epam.models.Category;
import com.epam.models.Pet;
import com.epam.models.Tag;

import java.util.List;

public class PetBuilder {

    public static Pet buildPet(Category category, String name,
                               List<String> photoUrls, List<Tag> tags, String status) {
        return Pet.builder()
                .category(category)
                .name(name)
                .photoUrls(photoUrls)
                .tags(tags)
                .status(status)
                .build();
    }
}
