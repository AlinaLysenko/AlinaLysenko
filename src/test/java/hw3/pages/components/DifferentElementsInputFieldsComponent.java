package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DifferentElementsInputFieldsComponent extends AbstractComponent {
    @FindBy(xpath = "//label[normalize-space()='Water']")
    WebElement water;

    @FindBy(xpath = "//label[normalize-space()='Wind']")
    WebElement wind;

    @FindBy(xpath = "//label[normalize-space()='Selen']")
    WebElement selen;

    @FindBy(css = ".colors")
    WebElement colors;

    @FindBy(xpath = "//*[text()='Yellow']")
    WebElement yellow;

    public DifferentElementsInputFieldsComponent(WebDriver driver) {
        super(driver);
    }

    public void clickWater(){
        water.click();
    }
     public void clickWind(){
        wind.click();
    }
     public void selectSelen(){
        selen.click();
    }
     public void selectYellow(){
        colors.click();
        yellow.click();
    }

}
