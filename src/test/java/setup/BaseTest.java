package setup;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;

import static utils.ApplicationUrls.PETSTORE_BASE_URL;


public class BaseTest {

    protected UserController userController;
    protected PetController petController;
    protected RequestSpecification requestSpec;

    public void setUpUI() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    public void setupAPI() {
        RestAssured.baseURI = PETSTORE_BASE_URL.getUrl();
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
        userController = new UserController();
        petController = new PetController();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured());
    }

    @BeforeMethod
    public void init() {
        setUpUI();
        setupAPI();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
