package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends PageObjects {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipCodeInput = By.id("postal-code");
    private final By continueButton = By.id("continue");

    @Step
    public void enterFirstName(String firstName){
        waitForElement(firstNameInput, 5).sendKeys(firstName);
    }

    @Step
    public void enterLastName(String lastName){
        waitForElement(lastNameInput, 5).sendKeys(lastName);
    }

    @Step
    public void enterZipCode(String zipCode){
        waitForElement(zipCodeInput, 5).sendKeys(zipCode);
    }

    @Step
    public void clickContinueButton() {
        waitForElement(continueButton, 5).click();
    }
}
