package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pageobjects.LoginPage;


public class BaseTest {

    protected final LoginPage loginPage = new LoginPage(driver);
    private static final String BASE_URL = "https://www.saucedemo.com/";
    public static WebDriver driver;


    @AfterClass
    public static void tearDownDriver() {
        driver.quit();
    }


    @BeforeClass
    public static void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Before
    public void openSauceDemoPage() {
        driver.get(BASE_URL);
    }

    @After
    public void clearBrowser() {
        driver.manage().deleteAllCookies();
        LocalStorage local = ((WebStorage) driver).getLocalStorage();
        local.clear();
    }
}