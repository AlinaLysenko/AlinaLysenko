package hw5.steps;

import hw5.WebDriverSingleton;
import hw5.pages.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public abstract class BaseSteps {
    protected WebDriver driver;
    protected HomePage homePage;

    public BaseSteps() {
        this.driver = WebDriverSingleton.INSTANCE.getDriver();
    }

    @Step("I open '{0}' URL")
    public void openSite(String url) {
        driver.get(url);

    }

    @Step("I login as '{0}")
    public void loginAs(String username, String password) {
        homePage.logIn(username, password);
    }

    @Step("Title should be {0}")
    public void checkTitle(String expectedTitle) {
        assertEquals(driver.getTitle(), expectedTitle, "Not expected Index page title");
    }

    @Step("Username should be visible and have value {0}")
    public void checkUsername(String expectedUsername) {
        assertTrue(homePage.usernameIsDisplayed());
        assertEquals(homePage.getUsername(), expectedUsername,
                "Not expected logged user");
    }
}