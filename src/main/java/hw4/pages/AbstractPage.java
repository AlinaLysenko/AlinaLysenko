package hw4.pages;

import hw4.WebDriverSingleton;
import hw4.pages.components.HeaderSectionComponent;
import hw4.pages.components.LeftSectionMenuComponent;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected HeaderSectionComponent headerSectionComponent;
    protected LeftSectionMenuComponent leftSectionMenuComponent;

    protected WebDriver driver;

    AbstractPage() {
        this.driver = WebDriverSingleton.INSTANCE.getDriver();
        initElementsOnPage();
    }

    public void logOut() {
        headerSectionComponent.logOut();
    }

    abstract void initElementsOnPage();
}
