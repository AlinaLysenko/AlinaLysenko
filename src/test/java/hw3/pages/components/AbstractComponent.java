package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

class AbstractComponent {

    protected WebDriver driver;

    AbstractComponent(WebDriver driver) {
        this.driver = (driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getWebElementsText(List<WebElement> elementList) {
        return elementList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean allElementsAreDisplayed(List<WebElement> list) {
        return list.stream()
                .filter(WebElement::isDisplayed)
                .count() == list.size();
    }
}
