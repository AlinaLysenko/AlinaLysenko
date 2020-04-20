package hw6.steps;

import hw6.pages.HomePage;
import io.cucumber.java.en.When;

public class NavigationBetweenPagesSteps {

    @When("I click on \"Service\" button in Header")
    public void clickService() {
        new HomePage().clickOnServices();
    } //todo:

    @When("I click on \"User Table\" button in Service dropdown")
    public void clickUserTable() {
        new HomePage().clickOnUsersTable();
    }//todo:

    @When("I click on \"Different Elements Page\" button in Service dropdown")
    public void clickDifferentElement() {
        new HomePage().clickOnDifferentElements();
    }//todo:

}
