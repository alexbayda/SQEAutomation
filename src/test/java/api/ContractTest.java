package api;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import setup.BaseTest;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ContractTest extends BaseTest {

    @Test
    public void restGet() {
        Response response = productController.getSchema(1);

        response.then()
                .log().body()
                .assertThat().
                body(matchesJsonSchemaInClasspath("product.json"));
    }
}
