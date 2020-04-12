package hw4.pages.components;

import hw4.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

abstract class AbstractComponent {

    protected WebDriver driver;

    AbstractComponent() {
        this.driver = WebDriverSingleton.INSTANCE.getDriver();
        PageFactory.initElements(driver, this);
    }

    public List<String> getWebElementsText(List<WebElement> elementList) {
        return elementList.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
