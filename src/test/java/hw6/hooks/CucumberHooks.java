package hw6.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import hw6.WebDriverSingleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CucumberHooks {
    protected String url;
    protected String password;
    protected String username;

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

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriverSingleton.INSTANCE.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        WebDriverSingleton.INSTANCE.quit();
    }
}
