package hw6.pages;

import hw6.pages.components.HeaderSectionComponent;
import hw6.pages.components.LeftSectionMenuComponent;

public abstract class AbstractPage {
    protected HeaderSectionComponent headerSectionComponent;
    protected LeftSectionMenuComponent leftSectionMenuComponent;

    AbstractPage() {
        this.headerSectionComponent = new HeaderSectionComponent();
        this.leftSectionMenuComponent = new LeftSectionMenuComponent();
        initElementsOnPage();
    }

    abstract void initElementsOnPage();
}
