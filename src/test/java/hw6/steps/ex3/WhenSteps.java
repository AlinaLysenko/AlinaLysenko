package hw6.steps.ex3;

import hw6.pages.UserTablePage;
import io.cucumber.java.en.When;

public class WhenSteps {

    UserTablePage userTablePage;

    public WhenSteps() {
        userTablePage = new UserTablePage();
    }

    @When("I select 'vip' checkbox for {string}")
    public void clickVipCheckbox(String username){
        userTablePage.clickVipCheckbox(username);
    }
}
