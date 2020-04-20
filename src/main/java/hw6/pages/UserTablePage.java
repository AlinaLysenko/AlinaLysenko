package hw6.pages;

import hw6.pages.components.HeaderSectionComponent;
import hw6.pages.components.LeftSectionMenuComponent;
import hw6.pages.components.UsersTableComponent;
import hw6.pages.components.UsersTableLogsComponent;

import java.util.List;

public class UserTablePage extends AbstractPage {

    UsersTableComponent usersTableComponent;
    UsersTableLogsComponent usersTableLogsComponent;

    @Override
    void initElementsOnPage() {
        this.headerSectionComponent = new HeaderSectionComponent();
        this.leftSectionMenuComponent = new LeftSectionMenuComponent();
        this.usersTableComponent = new UsersTableComponent();
        this.usersTableLogsComponent = new UsersTableLogsComponent();
    }

    public int countNumbersIsDisplayed() {
        return usersTableComponent.countNumbersIsDisplayed();
    }

    public int countUsernamesIsDisplayed() {
        return usersTableComponent.countUsernamesIsDisplayed();
    }

    public int countDesciptionTextIsDisplayed() {
        return usersTableComponent.countDesciptionTextIsDisplayed();
    }

    public int countCheckboxesIsDisplayed() {
        return usersTableComponent.countCheckboxesIsDisplayed();
    }

    public void clickVipCheckbox(String username) {
        usersTableComponent.clickVipCheckbox(username);
    }

    public List<List<String>> getIdUsernameDeskList() {
        return usersTableComponent.getIdUsernameDeskList();
    }

    public List<String> getTypeList(String username) {
        return usersTableComponent.getTypeList(username);
    }

    public boolean logSectionContains(String expectedLog) {
        return usersTableLogsComponent.logSectionContains(expectedLog);
    }

    public int getLogListSize(){
        return usersTableLogsComponent.getLogListSize();
    }
}
