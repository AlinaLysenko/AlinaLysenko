package hw6.steps;

import hw6.pages.HomePage;
import io.cucumber.java.en.When;

public class NavigationBetweenPagesSteps {

    HomePage homePage;

    public NavigationBetweenPagesSteps() {
        this.homePage = new HomePage();
    }

    @When("I click on \"Service\" button in Header")
    public void clickService() {
        homePage.clickOnServices();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickDifferentElement(String page) {
        homePage.clickOnPageButton(page);
    }
}
