package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class CheckoutCompletePage extends PageObjects {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private final By thankYouMessage = By.tagName("h2");

    @Step
    public void thankYouMessageShouldBeDisplayed() {
        assertEquals(waitForElement(thankYouMessage, 5).getText(), "THANK YOU FOR YOUR ORDER");
    }
}
