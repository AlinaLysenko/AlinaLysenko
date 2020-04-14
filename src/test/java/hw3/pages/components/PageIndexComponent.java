package hw3.pages.components;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageIndexComponent extends AbstractComponent {

    @FindBy(className = "benefit-icon")
    private List<WebElement> imageWebElementList;

    @FindBy(className = "benefit-txt")
    private List<WebElement> textWebElementList;

    public PageIndexComponent(WebDriver driver) {
        super(driver);
    }

    public int getImageWebElementListSize() {
        return this.imageWebElementList.size();
    }

    public boolean allImageElementsAreDisplayed() {
        return allElementsAreDisplayed(imageWebElementList);
    }

    public int getTextWebElementListSize() {
        return this.textWebElementList.size();
    }

    public boolean allTextElementsAreDisplayed() {
        return allElementsAreDisplayed(textWebElementList);
    }

    public List<String> getTextElementListContent() {
        return getWebElementsText(textWebElementList);
    }
}
