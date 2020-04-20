package hw5.pages;

import hw5.pages.components.HeaderSectionComponent;
import hw5.pages.components.LeftSectionMenuComponent;
import hw5.WebDriverSingleton;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected HeaderSectionComponent headerSectionComponent;
    protected LeftSectionMenuComponent leftSectionMenuComponent;

    AbstractPage() {
        initElementsOnPage();
    }

    abstract void initElementsOnPage();
}
