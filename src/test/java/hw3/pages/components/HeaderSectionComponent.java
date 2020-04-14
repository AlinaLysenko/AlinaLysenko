package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderSectionComponent extends AbstractComponent {

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement logInButton;

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
