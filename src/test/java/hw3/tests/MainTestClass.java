package hw3.tests;

import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public abstract class MainTestClass {

    public WebDriver driver;

    private String url;
    private String username;
    private String password;

    private WebDriverWait wait;
    protected SoftAssert softAssert = new SoftAssert();
    protected HomePage homePage;
    protected DifferentElementsPage diffPage;

    public void setProperties() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/hw3/config.properties");
            property.load(fis);
            url = property.getProperty("url");
            username = property.getProperty("username");
            password = property.getProperty("password");
        } catch (IOException e) {
            System.err.println("No property file");
        }
    }

    public WebElement getWithWaitUntilVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getWithWaitUntilClickable(By by) {
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public List<WebElement> getElementsWithWaitUntilVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public List<String> getWebElementsText(List<WebElement> elementList) {
        return elementList.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void logIn(String username, String password) {
        homePage.logIn(username, password);
    }

    @BeforeClass
    public void setUp() {
        setProperties();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        //Open test site by URL  Test site is opened
        driver.get(url);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        logIn(username, password);
    }

    @AfterClass
    //12	Close Browser	 	Browser is closed
    public void shutDown() {
        driver.quit();
    }
}
