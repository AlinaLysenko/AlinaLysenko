package hwAPI;

import hwAPI.enums.ErrorCode;
import hwAPI.enums.Fields;
import hwAPI.enums.URI;
import hwAPI.service.YandexSpellerService;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public abstract class AbstractTest {

    protected RequestSpecification REQUEST_SPECIFICATION;
    protected YandexSpellerService yandexSpellerService = new YandexSpellerService();

    @BeforeMethod
    public void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(URI.BASE_URI.getValue())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }
}
