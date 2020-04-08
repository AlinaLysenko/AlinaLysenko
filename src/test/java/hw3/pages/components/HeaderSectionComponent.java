package hw3.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HeaderSectionComponent extends AbstractComponent {

    @FindBy(id = "user-icon")
    WebElement userIcon;

    @FindBy(className = "uui-profile-menu")
    WebElement profileMenu;

    @FindBy(id = "name")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "login-button")
    WebElement logInButton;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerElementList;


    public HeaderSectionComponent(WebDriver driver) {
        super(driver);
    }

    public void logIn(String username, String password) { //should be not void
        userIcon.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        logInButton.click();
    }

    public boolean usernameIsDisplayed() {
        return this.username.isDisplayed();
    }

    public String getUsername() {
        return this.username.getText();
    }

    public int getHeaderElementListSize() {
        return this.headerElementList.size();
    }

    public List<String> getHeaderElementListContent() {
        return getWebElementsText(headerElementList);
    }

    public boolean allHeaderElementsAreDisplayed() {
        return allElementsAreDisplayed(headerElementList);
    }


}
