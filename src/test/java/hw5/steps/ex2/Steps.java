
package hw5.steps.ex2;

import hw5.emums.Colors;
import hw5.emums.Elements;
import hw5.emums.Metals;
import hw5.pages.DifferentElementsPage;
import hw5.pages.HomePage;
import hw5.steps.BaseSteps;
import io.qameta.allure.Step;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Steps extends BaseSteps {
    DifferentElementsPage diffPage;

    public Steps() {
        super();
        this.homePage = new HomePage();
        diffPage = new DifferentElementsPage();
    }

    @Step("Go to page Different Element. Title should be {0}")
    public void switchToDifferentElements(String expectedTitle) {
        homePage.switchToDifferentElements();
        assertEquals(
                driver.getTitle(),
                expectedTitle,
                "Not expected Different elements page title"
        );

    }

    @Step("Click on {0}")
    public void clickOnCheckbox(Elements element) {
        diffPage.clickOnCheckbox(element);
    }

    @Step("Choose metal: {0}")
    public void clickOnRadioButton(Metals metal) {
        diffPage.clickOnRadiobutton(metal);
    }

    @Step("Select color: {0}")
    public void clickOnSelect(Colors color) {
        diffPage.selectColor(color);
    }

    @Step("All logs are displayed correctly")
    public void verifyLogs(List<String> expectedLogs){
        assertTrue(diffPage.logSectionContains(expectedLogs));
    }
}