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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected UserController userController;
    protected PetController petController;
    protected RequestSpecification requestSpec;
    protected String environment = System.getProperty("env", "dev");
    private static String BASE_URL;

    protected String epamMainPageBaseUrl = "https://www.epam.com/";
    protected String epamContactUsPageBaseUrl = "https://www.epam.com/about/who-we-are/contact";
    protected String epamAboutPageBaseUrl = "https://www.epam.com/about";
    protected String tricentisMainPageBaseUrl = "https://demowebshop.tricentis.com/";

    public void setUpUI(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
    }

    public void setupAPI(){
        RestAssured.baseURI = BASE_URL;
        requestSpec = new RequestSpecBuilder()
                .setBasePath("/automationGuy")
                .setContentType(ContentType.JSON)
                .build();
        userController = new UserController();
        petController = new PetController();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter(),new AllureRestAssured());
    }

    public void setupEnv(){
        if("qa".equals(environment)){
            BASE_URL =  null;
        }
        else {
            BASE_URL =  "https://petstore.swagger.io/v2/";
        }
    }
    @BeforeClass
    public void init(){
        setupEnv();
        setUpUI();
        setupAPI();
    }

    @AfterClass
    public void tearDown(){
        Selenide.closeWebDriver();
    }
}
