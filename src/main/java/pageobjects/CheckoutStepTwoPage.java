package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckoutStepTwoPage extends PageObjects {

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private final By itemTotalLabel = By.className("summary_subtotal_label");
    private final By taxTotalLabel = By.className("summary_tax_label");
    private final By totalLabel = By.className("summary_total_label");
    private final By finishButton = By.id("finish");

    @Step
    public void clickFinishButton() {
        waitForElement(finishButton, 5).click();
    }

    @Step
    public void itemTotalPriceShouldBe(String expectedPrice){
        assertThat(waitForElement(itemTotalLabel, 5).getText(), containsString(expectedPrice));
    }

    @Step
    public void taxTotalPriceShouldBe(String expectedPrice){
        assertThat(waitForElement(taxTotalLabel, 5).getText(), containsString(expectedPrice));
    }

    @Step
    public void totalPriceShouldBe(String expectedPrice){
        assertThat(waitForElement(totalLabel, 5).getText(), containsString(expectedPrice));
    }
}
