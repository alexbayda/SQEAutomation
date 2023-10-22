package setup;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class PetController {


    public <T> T createEntity(T entity, Class<T> entityType) {
        return given()
                .contentType("application/json")
                .body(entity)
                .post("/pet")
                .prettyPeek()
                .then().statusCode(200).extract().as(entityType);
    }

    public <T> void updateEntity(T updatedEntity, Class<T> entityType) {
        given()
                .contentType("application/json")
                .body(updatedEntity)
                .put("/pet")
                .then().statusCode(200).extract().as(entityType);
    }


    public void deleteEntity(long id) {
        RestAssured.given()
                .delete("/pet/" + id)
                .then()
                .statusCode(200)
                .log();
    }
}
