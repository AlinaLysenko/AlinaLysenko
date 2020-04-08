package hw3.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;

    AbstractComponent(WebDriver driver) {
        this.driver = (driver);
        wait = new WebDriverWait(driver, 30);//
        PageFactory.initElements(driver, this);//
    }

    public List<String> getWebElementsText(List<WebElement> elementList) {
        return elementList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean allElementsAreDisplayed(List<WebElement> list) {
        return list.stream()
                .filter(s -> s.isDisplayed())
                .count() == list.size();
    }

}
