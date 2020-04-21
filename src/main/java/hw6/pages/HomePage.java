package hw6.pages;

import hw6.pages.AbstractPage;
import hw6.pages.components.HeaderSectionComponent;
import hw6.pages.components.LeftSectionMenuComponent;

import java.util.List;

public class HomePage extends AbstractPage {

    public HomePage() {
        super();
    }

    @Override
    void initElementsOnPage() {
    }

    public void logIn(String username, String password) { //not void
        headerSectionComponent.logIn(username, password);
    }

    public boolean usernameIsDisplayed() { //should be not void
        return headerSectionComponent.usernameIsDisplayed(); //nope
    }

    public String getUsername() { //should be not void
        return headerSectionComponent.getUsername(); //nope
    }

    public void switchToDifferentElements() {
        leftSectionMenuComponent.switchToDifferentElements();
    }

    public void clickOnServices() {
        headerSectionComponent.clickOnServices();
    }

    public void clickOnPageButton(String page){
        headerSectionComponent.clickOnPageButton(page);
    }


}
