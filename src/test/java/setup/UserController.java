package setup;

import models.User;

import static io.restassured.RestAssured.given;

public class UserController {


    public void getUser(String userName, String password) {
        given().queryParam("username", userName)
                .queryParam("password", password)
                .get("user/login")
                .then().statusCode(200).extract().as(User.class);
    }

    public void logoutUser(String userName, String password) {
        getUser(userName,password);
        given()
                .get("user/logout")
                .then().statusCode(200)
                .extract().as(User.class);
    }

    public <T> void createEntity(T entity, Class<T> entityType, String entityCount) {
        if(entityCount.equals("objectArray")){
            entityCount = "/user/createWithArray";
        }else {
            entityCount = "/user";
        }
        given()
                .contentType("application/json")
                .body(entity)
                .post(entityCount)
                .prettyPeek()
                .then()
                .statusCode(200)
                .extract().as(entityType);

    }
}
