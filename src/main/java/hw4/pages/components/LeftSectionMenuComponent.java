package hw4.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LeftSectionMenuComponent extends AbstractComponent {

    @FindBy(css = ".sidebar-menu>li")
    private List<WebElement> leftSectionMenuList;

    @FindBy(linkText = "Service")
    private WebElement service;

    @FindBy(linkText = "Table with pages")
    private WebElement tableWithPages;

    @FindBy(linkText = "Metals \u0026 Colors")
    private WebElement metalsAndColors;

    public LeftSectionMenuComponent() {
        super();
    }

    public void switchToTableWithPages() {
        service.click();
        tableWithPages.click();
    }

    public void switchToMetalsAndColors() {
        metalsAndColors.click();
    }

}
