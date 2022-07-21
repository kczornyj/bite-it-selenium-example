package tests.saucedemotests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import tests.BaseTest;


public class InvalidLoginTest extends BaseTest {

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithInvalidPasswordShouldDisplayError() {

        //When
        loginPage.loginAsUser("standard_user", "secret_saucee");

        //Then
        loginPage.errorMessageShouldBe("Username and password do not match any user in this service");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithoutUsernameShouldDisplayError() {

        //When
        loginPage.loginAsUser("", "secret_sauce");

        //Then
        loginPage.errorMessageShouldBe("Username is required");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginWithoutPasswordShouldDisplayError() {

        //When
        loginPage.loginAsUser("standard_user", "");

        //Then
        loginPage.errorMessageShouldBe("Password is required");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void loginAsLockedUserShouldDisplayError() {

        //When
        loginPage.loginAsUser("locked_out_user", "secret_sauce");

        //Then
        loginPage.errorMessageShouldBe("Sorry, this user has been locked out.");
    }
}
