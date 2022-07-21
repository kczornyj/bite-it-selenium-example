package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageObjects {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private final By checkoutButton = By.id("checkout");

    @Step
    public void clickCheckoutButton() {
        waitForElement(checkoutButton, 5).click();
    }
}
