package setup;

import io.swagger.petstore.models.User;

import static io.restassured.RestAssured.given;

public class UserController {


    public void getUser(String userName, String password) {
        given().queryParam("username", userName)
                .queryParam("password", password)
                .get("user/login")
                .then().statusCode(200).extract().as(User.class);
    }

    public void getUser() {
        getUser("alex8098", "12345");
        given()
                .get("user/logout")
                .then().statusCode(200)
                .extract().as(User.class);
    }

    public <T> T createEntity(T entity, Class<T> entityType, String entityCount) {
        if(entityCount.equals("objectArray")){
            entityCount = "/user/createWithArray";
        }else {
            entityCount = "/user";
        }
        return given()
                .contentType("application/json")
                .body(entity)
                .post(entityCount)
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract().as(entityType);

    }
}
