package hw6.pages;

import hw6.pages.components.HeaderSectionComponent;
import hw6.pages.components.LeftSectionMenuComponent;

public abstract class AbstractPage {
    protected HeaderSectionComponent headerSectionComponent;
    protected LeftSectionMenuComponent leftSectionMenuComponent;

    AbstractPage() {
        initElementsOnPage();
    }

    abstract void initElementsOnPage();
}
