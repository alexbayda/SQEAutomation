package builders;

import models.Category;
import models.Pet;
import models.Tag;
import models.User;

import java.util.List;

public class JsonObjectBuilder {

    public static Pet buildStandardPet(Category category, String name,
                                       List<String> photoUrls, List<Tag> tags, String status) {
        return Pet.builder()
                .category(category)
                .name(name)
                .photoUrls(photoUrls)
                .tags(tags)
                .status(status)
                .build();
    }

    public static User buildStandardUser(String userName, String firstName, String lastName,
                                         String email, String password, String phone, int userStatus) {
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
