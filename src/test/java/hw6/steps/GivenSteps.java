package hw6.steps;

import hw6.WebDriverSingleton;
import hw6.pages.HomePage;
import io.cucumber.java.en.Given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class GivenSteps {

    String url ;
    String username ;
    String password ;

    public GivenSteps() {
        super();
        setProperties();
    }

    public void setProperties() {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/test/resources/hw6" +
                    "/src/test/resources/config.properties");
            property.load(fis);
            url = property.getProperty("url");
            username = property.getProperty("username");
            password = property.getProperty("password");
        } catch (IOException e) {
            System.err.println("No property file");
        }
    }

    @Given("I open JDI GitHub site")
    public void openSite() {
        WebDriverSingleton.INSTANCE.getDriver().get(url);
    }

    @Given("I login as user \"Roman Iovlev\"")
    public void logIn(){
        new HomePage().logIn(username, password);
    }
}
