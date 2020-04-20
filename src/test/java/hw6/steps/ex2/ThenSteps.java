package hw6.steps.ex2;

import hw6.WebDriverSingleton;
import hw6.pages.UserTablePage;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ThenSteps {

    public ThenSteps() {
       usersTablePage = new UserTablePage();
    }

    UserTablePage usersTablePage;

    @Then("{string} page should be opened")
    public void checkTitle(String title) {
        assertThat(WebDriverSingleton.INSTANCE.getDriver().getTitle()).isEqualTo(title);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkUserTableDropdownsAmount(int amount) {
       assertThat(usersTablePage.countNumbersIsDisplayed()).isEqualTo(amount);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void checkUserTableUsernamesAmount(int amount) {
        assertThat(usersTablePage.countUsernamesIsDisplayed()).isEqualTo(amount);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void checkUserTableDescriptionTextAmount(int amount) {
        assertThat(usersTablePage.countDesciptionTextIsDisplayed()).isEqualTo(amount);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkUserTableVipCkeckboxesAmount(int amount) {
        assertThat(usersTablePage.countCheckboxesIsDisplayed()).isEqualTo(amount);
    }

    @Then("User table should contain following values:")
    public void checkUserTableContent(List<List<String>> dataTable){
        assertThat(usersTablePage.getIdUsernameDeskList()).isEqualTo(dataTable.subList(1,7));
    }

    @Then("droplist should contain values in column Type for user {word}")
    public void checkUserTableDroplistContent(String username, List<List<String>> dataTable){
        assertThat(usersTablePage.getTypeList(username))
                .isEqualTo(dataTable.subList(1,4).stream().map(e -> e.get(0)).collect(Collectors.toList()));
    }
}
