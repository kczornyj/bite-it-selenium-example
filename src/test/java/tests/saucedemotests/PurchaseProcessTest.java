package tests.saucedemotests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import pageobjects.CartPage;
import pageobjects.CheckoutCompletePage;
import pageobjects.CheckoutPage;
import pageobjects.CheckoutStepTwoPage;
import pageobjects.ProductsPage;
import tests.BaseTest;

public class PurchaseProcessTest extends BaseTest {

    private final ProductsPage productsPage = new ProductsPage(driver);
    private final CartPage cartPage = new CartPage(driver);
    private final CheckoutPage checkoutPage = new CheckoutPage(driver);
    private final CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
    private final CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithInvalidPasswordShouldDisplayError() {

        //Given
        loginPage.loginAsUser("standard_user", "secret_sauce");

        //When
        productsPage.clickAddBikeLightToCartButton();
        productsPage.clickAddBackpackToCartButton();
        productsPage.clickCartButton();

        //And

        cartPage.clickCheckoutButton();

        //And
        checkoutPage.enterFirstName("TestName");
        checkoutPage.enterLastName("TestSurname");
        checkoutPage.enterZipCode("PL2 EN1");
        checkoutPage.clickContinueButton();

        //And
        checkoutStepTwoPage.itemTotalPriceShouldBe("$39.98");
        checkoutStepTwoPage.taxTotalPriceShouldBe("$3.20");
        checkoutStepTwoPage.totalPriceShouldBe("$43.17");
        checkoutStepTwoPage.clickFinishButton();

        //Then
        checkoutCompletePage.thankYouMessageShouldBeDisplayed();
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void amountOfItemsInCartShouldBeDisplayedProperly() {

        //Given
        loginPage.loginAsUser("standard_user", "secret_sauce");

        //When
        productsPage.clickAddBikeLightToCartButton();
        productsPage.clickAddBackpackToCartButton();

        //Then
        productsPage.amountOfItemsInCartShouldBe(1);
    }
}
