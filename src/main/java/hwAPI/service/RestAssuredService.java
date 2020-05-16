package hwAPI.service;

import hwAPI.enums.URI;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestAssuredService {

    private RequestSpecification REQUEST_SPECIFICATION;

    public RestAssuredService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(URI.BASE_URI.getValue())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getWithParams(String uri, Map<String, Object> params) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (param.getValue().getClass().equals(java.util.ArrayList.class)) {
                List<String> listOfTexts = (ArrayList<String>) param.getValue();
                listOfTexts.stream().forEach(e -> specification.param(param.getKey(), e));
            } else {
                specification.param(param.getKey(), param.getValue());
            }
        }
        return specification.get(uri);
    }
}

