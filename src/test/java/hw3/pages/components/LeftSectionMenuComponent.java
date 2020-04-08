package hw3.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftSectionMenuComponent extends AbstractComponent {

    public LeftSectionMenuComponent(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sidebar-menu>li")
    List<WebElement> leftSectionMenuList;

    @FindBy(linkText = "Service")
    WebElement service;

    @FindBy(linkText = "Different elements")
    WebElement diffElemets;



    public int getLeftSectionMenuListSize() {
        return this.leftSectionMenuList.size();
    }

    public List<String> getLeftSectionMenuListContent() {
        return getWebElementsText(leftSectionMenuList);
    }

    public boolean allLeftSectionMenuAreDisplayed() {
        return allElementsAreDisplayed(leftSectionMenuList);
    }

    public WebDriver switchToDifferentElements(){
        service.click();
        diffElemets.click();
        return driver;
    }


}
