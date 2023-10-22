package apitests;

import com.epam.api.data.UserTestData;
import com.epam.models.User;
import org.testng.annotations.Test;
import setup.BaseTest;

import java.util.ArrayList;
import java.util.List;

import static com.epam.api.data.UserBuilder.buildUser;
import static com.epam.utils.RandomUserGenerator.generateRandomUser;

@lombok.extern.slf4j.Slf4j
public class UserApiTests extends BaseTest {

    @Test(dataProvider = "userData", dataProviderClass = UserTestData.class)
    public void createUserTest(String userName, String firstName, String lastName,
                               String email, String password, String phone, int userStatus) {
        User user = buildUser(userName, firstName, lastName, email, password, phone, userStatus);
        userController.createEntity(user, User.class, "singleObject");
    }

    @Test
    public void loginUserTest() {
        userController.getUser("Alex8098", "12345");
    }

    @Test
    public void logoutUserTest() {
        userController.getUser();
    }

    @Test
    public void createListOfUsersTest() {
        userController.createEntity(generateRandomUsers(3), Object.class, "objectArray");
    }

    private List<User> generateRandomUsers(int count) {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            users.add(generateRandomUser());
        }
        return users;
    }
}
