package hw6.steps.ex2;

import hw6.ProfileText;
import hw6.WebDriverSingleton;
import hw6.pages.UserTablePage;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;

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

    @DataTableType
    public ProfileText ProfileTextEntry(Map<String, String> entry) {
        return new ProfileText(
                entry.get("Number"),
                entry.get("User"),
                entry.get("Description"));
    }

    @Then("User table should contain following values:")
    public void checkUserTableContent(List<ProfileText> dataTable){
        dataTable.stream().forEach(e -> System.out.println(e.toString()));
        usersTablePage.getProfileTextList().stream().forEach(e -> System.out.println(e.toString()));
        assertThat(usersTablePage.getProfileTextList()).isEqualTo(dataTable);
    }


    @Then("droplist should contain values in column Type for user {word}")
    public void checkUserTableDroplistContent(String username, List<String> dataTable){
        assertThat(usersTablePage.getTypeList(username))
                .isEqualTo(dataTable.subList(1,4));
    }
}
