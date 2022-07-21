package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObjects {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath(".//h3[@data-test='error']");

    @Step
    public void errorMessageShouldBe(String expectedText) {
        waitForTextInElement(waitForElement(errorMessage, 5), "Epic sadface: " + expectedText, 10);
    }

    @Step
    public void loginAsUser(String username, String password) {
        enterLogin(username);
        enterPassword(password);
        clickLoginButton();
    }

    @Step
    public void loginAsValidUser() {
        loginAsUser("standard_user", "secret_sauce");
    }

    private void enterLogin(String login) {
        waitForElement(usernameInput, 5).sendKeys(login);
    }

    private void enterPassword(String password) {
        waitForElement(passwordInput, 5).sendKeys(password);
    }

    private void clickLoginButton() {
        waitForElement(loginButton, 5).click();
    }
}
