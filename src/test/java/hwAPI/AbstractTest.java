package hwAPI;

import hwAPI.service.YandexSpellerService;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public abstract class AbstractTest {

    protected YandexSpellerService yandexSpellerService = new YandexSpellerService();

    @BeforeMethod
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
