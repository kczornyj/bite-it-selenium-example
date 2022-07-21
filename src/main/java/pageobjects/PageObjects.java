package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.time.temporal.ChronoUnit.SECONDS;

public class PageObjects {
    protected WebDriver driver;

    public PageObjects(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement waitForElement(By elementLocator, int seconds) {
        return wait(seconds).until(ExpectedConditions.presenceOfElementLocated(elementLocator));
    }

    protected List<WebElement> waitForElements(By elementsLocator, int seconds) {
        wait(seconds).until(ExpectedConditions.presenceOfElementLocated(elementsLocator));
        return driver.findElements(elementsLocator);
    }

    protected void waitForTextInElement(WebElement webElement, String expectedText, int seconds) {
        wait(seconds).until(ExpectedConditions.textToBePresentInElement(webElement, expectedText));
    }

    private WebDriverWait wait(int seconds) {
        return new WebDriverWait(driver, Duration.of(seconds, SECONDS));
    }
}
