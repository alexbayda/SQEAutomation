package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class CustomWaiter {

    public static SelenideElement waitForElementWithCondition(SelenideElement element, Condition expectedCondition, int timeoutInSeconds) {
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < timeoutInSeconds * 1000L) {
            if (element.is(expectedCondition)) {
                return element;
            }
            Selenide.sleep(1000);
        }
        return null;
    }

}
