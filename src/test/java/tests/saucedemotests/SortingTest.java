package tests.saucedemotests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import tests.BaseTest;
import pageobjects.ProductsPage;


public class SortingTest extends BaseTest {

    private final ProductsPage productsPage = new ProductsPage(driver);

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void sortingAscendingShouldBePossible() {

        //Given
        loginPage.loginAsValidUser();

        //When
        productsPage.selectSortingType("Name (Z to A)");

        //Then
        productsPage.productsShouldBeSortedDesc();
    }
}
