package hwAPI.service;

import com.google.gson.Gson;
import hwAPI.entity.response.YandexSpellerResponse;
import hwAPI.entity.request.YandexSpellerRequest;
import hwAPI.enums.URI;
import java.util.Arrays;
import java.util.List;

public class YandexSpellerService {
    public List<YandexSpellerResponse> getCheckText(YandexSpellerRequest request) {
        return Arrays.asList(new Gson().fromJson(new RestAssuredService()
                .getWithParams(URI.CHECK_TEXT.getValue(), request.paramsToMap())
                .getBody().asString(), YandexSpellerResponse[].class));
    }

    public List<YandexSpellerResponse>  getCheckTexts(YandexSpellerRequest request) {
        YandexSpellerResponse[][] array = new Gson().fromJson(new RestAssuredService()
                .getWithParams(URI.CHECK_TEXTS.getValue(), request.paramsToMap())
                .getBody().asString(), YandexSpellerResponse[][].class);
        return Arrays.asList(array[0]);
    }

}
