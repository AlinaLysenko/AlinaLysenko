package hw2;

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

import java.util.List;
import java.util.stream.Collectors;

public abstract class MainTestClass {

    public WebDriver driver;
    public String URL = "https://jdi-testing.github.io/jdi-light/index.html";
    public String USERNAME = "Roman";
    public String PASSWORD = "Jdi1234";
    public SoftAssert softAssert = new SoftAssert();
    public WebDriverWait wait;

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
        getWithWaitUntilClickable(By.id("user-icon")).click();
        getWithWaitUntilVisible(By.id("name")).sendKeys(username);
        getWithWaitUntilVisible(By.id("password")).sendKeys(password);
        getWithWaitUntilClickable(By.id("login-button")).click();
    }

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        //Open test site by URL  Test site is opened
        driver.get(URL);
        driver.manage().window().maximize();
        logIn(USERNAME, PASSWORD);
    }

    @AfterClass
    //12	Close Browser	 	Browser is closed
    public void shutDown() {
        driver.quit();
    }
}
