package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsInputFieldsComponent extends AbstractComponent {

    @FindBy(xpath = "//label[normalize-space()='Water']")
    private WebElement water;

    @FindBy(xpath = "//label[normalize-space()='Wind']")
    private WebElement wind;

    @FindBy(xpath = "//label[normalize-space()='Selen']")
    private WebElement selen;

    @FindBy(css = ".colors > .uui-form-element")
    private WebElement colors;

    public DifferentElementsInputFieldsComponent(WebDriver driver) {
        super(driver);
    }

    public void clickOnField(String fieldName) {
        switch (fieldName) {
            case "Water":
                water.click();
                break;
            case "Wind":
                wind.click();
                break;
            case "Selen":
                selen.click();
                break;
            default:
                throw new IllegalArgumentException(fieldName);
        }
    }

    public void selectColor(String color) {
        new Select(colors).selectByVisibleText(color);
    }
}
