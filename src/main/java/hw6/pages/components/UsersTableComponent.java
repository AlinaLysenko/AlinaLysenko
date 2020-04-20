package hw6.pages.components;

import hw6.Profile;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class UsersTableComponent extends AbstractComponent {

    @FindBy(css = "#user-table > tbody > tr")
    List<WebElement> userRow;

    List<Profile> users;

    public UsersTableComponent() {
        super();
        users = userRow.subList(1, 7).stream().map(e -> new Profile(e)).collect(Collectors.toList());
    }

    public int countNumbersIsDisplayed() {
        return (int) users.stream().filter(e -> e.getId().isDisplayed()).count();
    }

    public int countUsernamesIsDisplayed() {
        return (int) users.stream().filter(e -> e.getUsername().isDisplayed()).count();
    }

    public int countDesciptionTextIsDisplayed() {
        return (int) users.stream().filter(e -> e.getDeskName().isDisplayed()).count();
    }

    public int countCheckboxesIsDisplayed() {
        return (int) users.stream().filter(e -> e.getVipCheckbox().isDisplayed()).count();
    }

    public void clickVipCheckbox(String username) {
        users.stream()
                .filter(e -> e.getUsername().getText().equals(username))
                .forEach(e -> e.getVipCheckbox().click());
    }

    public List<List<String>> getIdUsernameDeskList() {
        return users.stream().map(Profile::getIdUsernameDeskList).collect(Collectors.toList());
    }

    public List<String> getTypeList(String username) {
        return users.stream()
                .filter(e -> e.getUsername().getText().equals(username))
                .collect(Collectors.toList())
                .get(0).getTypeValyes();
    }

}
