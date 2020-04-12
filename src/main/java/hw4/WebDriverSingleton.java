package hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum WebDriverSingleton {

    INSTANCE;

    private WebDriver driver;

    private WebDriverWait wait;

    public void createDriver(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 10);
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver("chrome");
        }
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void quit (){
        driver.quit();
        this.driver = null;
    }
}