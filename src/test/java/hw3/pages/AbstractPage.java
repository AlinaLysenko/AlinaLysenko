package hw3.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    WebDriver driver;
    WebDriverWait wait;

    AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);//
        initElementsOnPage();
    }

    abstract void initElementsOnPage();
}
