package hw4.pages;

import hw4.pages.components.HeaderSectionComponent;
import hw4.pages.components.LeftSectionMenuComponent;

public class HomePage extends AbstractPage {

    public HomePage() {
        super();
    }

    @Override
    void initElementsOnPage() {
        this.headerSectionComponent = new HeaderSectionComponent();
        this.leftSectionMenuComponent = new LeftSectionMenuComponent();
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

    public void switchToTableWithPage() {
        leftSectionMenuComponent.switchToTableWithPages();
    }

    public void switchToMetalsAndColors() {
        leftSectionMenuComponent.switchToMetalsAndColors();
    }

}
