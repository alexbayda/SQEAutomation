package com.epam.api.data;

import com.epam.models.User;

public class UserBuilder {

    public static User buildUser(String userName, String firstName, String lastName,
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
