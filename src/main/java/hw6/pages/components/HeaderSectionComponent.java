package hw6.pages.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy (css = ".logout > button")
    private WebElement logOutButton;

    @FindBy(css = ".m-l8 > li")
    private List<WebElement> headerElementList;

    public HeaderSectionComponent() {
        super();
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

    public void clickOnServices() {
        headerElementList.get(2).click();
    }

    public void clickOnPageButton(String page){
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText(page.toUpperCase())))
                .click();
    }
}
