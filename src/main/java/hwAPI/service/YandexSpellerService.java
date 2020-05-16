package hwAPI.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import hwAPI.entity.request.YandexSpellerRequest;
import hwAPI.entity.response.YandexSpellerResponse;
import hwAPI.enums.URI;

import java.lang.reflect.Type;
import java.util.List;

public class YandexSpellerService {
    public List<YandexSpellerResponse> getCheckText(YandexSpellerRequest request) {
        Type collectionType = new TypeToken<List<YandexSpellerResponse>>() {
        }.getType();
        return new Gson().fromJson(new RestAssuredService()
                .getWithParams(URI.CHECK_TEXT.getValue(), request.paramsToMap())
                .getBody().asString(), collectionType);
    }

    public List<List<YandexSpellerResponse>> getCheckTexts(YandexSpellerRequest request) {
        Type collectionType = new TypeToken<List<List<YandexSpellerResponse>>>() {
        }.getType();
        return new Gson().fromJson(new RestAssuredService()
                .getWithParams(URI.CHECK_TEXTS.getValue(), request.paramsToMap())
                .getBody().asString(), collectionType);
    }
}
