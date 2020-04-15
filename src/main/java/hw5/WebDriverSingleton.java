package hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public enum WebDriverSingleton {

    INSTANCE;

    private WebDriver driver;

    public void createDriver(String browserName) {
        if ("CHROME".equalsIgnoreCase(browserName)) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            createDriver("chrome");
        }
        return driver;
    }

    public void quit (){
        driver.quit();
        this.driver = null;
    }
}