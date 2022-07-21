package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.valueOf;
import static java.util.Comparator.reverseOrder;
import static org.junit.Assert.assertEquals;

public class ProductsPage extends PageObjects {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By sortSelectList = By.className("product_sort_container");
    private final By products = By.className("inventory_item");
    private final By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private final By addBikeLightToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private final By cartButton = By.className("shopping_cart_link");
    private final By shoppingCartItemsAmount = By.className("shopping_cart_badge");
    @Step
    public void selectSortingType(String sortingType) {
        Select selectObject = new Select(waitForElement(sortSelectList, 5));
        selectObject.selectByVisibleText(sortingType);
    }

    @Step
    public void productsShouldBeSortedDesc() {
        List<String> received = getProductsTitles();
        List<String> sorted = received.stream().sorted(reverseOrder()).collect(Collectors.toList());
        assertEquals(sorted, received);
    }

    @Step
    public void clickCartButton() {
        waitForElement(cartButton, 5).click();
    }

    @Step
    public void amountOfItemsInCartShouldBe(int amountOfItemsInCart) {
        assertEquals(waitForElement(shoppingCartItemsAmount, 5).getText(), valueOf(amountOfItemsInCart));
    }

    @Step
    public void clickAddBackpackToCartButton() {
        waitForElement(addBackpackToCartButton, 10).click();
    }

    @Step
    public void clickAddBikeLightToCartButton() {
        waitForElement(addBikeLightToCartButton, 10).click();
    }

    private List<String> getProductsTitles() {
        return waitForElements(products, 10)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
