package apitests;

import io.swagger.petstore.data.UserTestData;
import io.swagger.petstore.models.User;
import org.testng.annotations.Test;
import setup.BaseTest;

import static io.swagger.petstore.builders.JsonObjectBuilder.buildStandardUser;
import static utils.RandomGenerator.generateRandomListOfUsers;

public class UserApiTests extends BaseTest {

    @Test(dataProvider = "userData", dataProviderClass = UserTestData.class)
    public void createUserTest(String userName, String firstName, String lastName,
                               String email, String password, String phone, int userStatus) {
        User user = buildStandardUser(userName, firstName, lastName, email, password, phone, userStatus);
        userController.createEntity(user, User.class, "singleObject");
    }

    @Test
    public void loginUserTest() {
        userController.getUser("Alex8098", "12345");
    }

    @Test
    public void logoutUserTest() {
        userController.logoutUser("Alex8098", "12345");
    }

    @Test
    public void createListOfUsersTest() {
        userController.createEntity(generateRandomListOfUsers(3), Object.class, "objectArray");
    }
}
