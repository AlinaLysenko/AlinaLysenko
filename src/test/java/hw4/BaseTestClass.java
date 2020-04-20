package hw4;

import hw4.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

abstract public class BaseTestClass {

    protected WebDriver driver;
    protected String url;
    protected String username;
    protected String password;
    protected SoftAssert softAssert = new SoftAssert();
    protected HomePage homePage;

    public void setProperties() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/hw4/config.properties");
            property.load(fis);
            url = property.getProperty("url");
            username = property.getProperty("username");
            password = property.getProperty("password");
        } catch (IOException e) {
            System.err.println("No property file");
        }
    }

    public void openSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @BeforeClass
    public void setUp() {
        setProperties();
        WebDriverManager.chromedriver().setup();
        driver = WebDriverSingleton.INSTANCE.getDriver();
        openSite(url);
        homePage = new HomePage();
    }

    @BeforeMethod
    public void logIn (){
        homePage.logIn(username, password);
    }

    @AfterMethod
    public void logOut (){
        homePage.logOut();
    }

    @AfterClass
    //Close Browser
    public void shutDown() {
        WebDriverSingleton.INSTANCE.quit();
    }
}

