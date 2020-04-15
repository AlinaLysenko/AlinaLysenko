package hw5;

import hw5.pages.DifferentElementsPage;
import hw5.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class MainTestClass {

    public WebDriver driver;

    protected String url;
    protected String username;
    protected String password;

    public void setProperties() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/hw5/config.properties");
            property.load(fis);
            url = property.getProperty("url");
            username = property.getProperty("username");
            password = property.getProperty("password");
        } catch (IOException e) {
            System.err.println("No property file");
        }
    }

    @BeforeClass
    public void setUp() {
        setProperties();
        driver = WebDriverSingleton.INSTANCE.getDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void shutDown() {
        WebDriverSingleton.INSTANCE.quit();
    }
}
