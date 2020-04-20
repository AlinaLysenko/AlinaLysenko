package hw6.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftSectionMenuComponent extends AbstractComponent {

    public LeftSectionMenuComponent() {
        super();
    }

    @FindBy(css = ".sidebar-menu>li")
    private List<WebElement> leftSectionMenuList;

    @FindBy(linkText = "Service")
    private WebElement service;

    @FindBy(linkText = "Different elements")
    private WebElement diffElements;

    @FindBy(linkText = "Users table")
    private WebElement usersTable;

    public int getLeftSectionMenuListSize() {
        return this.leftSectionMenuList.size();
    }

    public List<String> getLeftSectionMenuListContent() {
        return getWebElementsText(leftSectionMenuList);
    }

    public boolean allLeftSectionMenuAreDisplayed() {
        return allElementsAreDisplayed(leftSectionMenuList);
    }

    public void switchToDifferentElements() {
        service.click();
        diffElements.click();
    }
}
