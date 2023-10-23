package pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;

import java.io.File;
import java.io.FileNotFoundException;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class EpamAboutPage {


    private final SelenideElement companyLogo = $x("(//img[@class='header__logo header__logo-light'])[1]");
    private final SelenideElement corporateOverviewDownloadButton = $x("//*[@id=\"main\"]/div[1]/div[5]/section/div[2]/div/div/div[1]/div/div[3]/div/a");
    private final SelenideElement cookieAccept = $x("//button[@id='onetrust-accept-btn-handler']");

    public EpamAboutPage(String url) {
        open(url);
    }

    public void checkCompanyLogoLeadsToMainPage(String expectedUrl) {
        companyLogo.shouldBe(Condition.visible, Condition.enabled).click();
        String currentUrl = Selenide.webdriver().driver().getCurrentFrameUrl();
        Assertions.assertThat(currentUrl).isEqualTo(expectedUrl);
    }

    public void checkThatAllowsToDownloadReport() {
        try {
            cookieAccept.click();
            corporateOverviewDownloadButton.shouldBe(Condition.visible, Condition.enabled).click();
            corporateOverviewDownloadButton.download().getAbsoluteFile();
            Selenide.sleep(10000);
            String expectedFileName = "EPAM_Corporate_Overview_2023.pdf";
            String downloadedFilePath = corporateOverviewDownloadButton.download().getAbsolutePath();

            File downloadedFile = new File(downloadedFilePath);
            Assertions.assertThat(downloadedFile)
                    .exists()
                    .hasName(expectedFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

