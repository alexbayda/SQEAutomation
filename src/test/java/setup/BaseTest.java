package setup;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import static utils.ApplicationUrls.PETSTORE_BASE_URL;


public class BaseTest {

    protected UserController userController;
    protected PetController petController;
    protected RequestSpecification requestSpec;

    public void setUpUI(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            Configuration.browser = "chrome";
        } else if (browser.equalsIgnoreCase("firefox")) {
            Configuration.browser = "firefox";
        }
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
    @Parameters("browser")
    public void init(@Optional("chrome") String browser) {
        setUpUI(browser);
        setupAPI();
    }

    @AfterMethod
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
