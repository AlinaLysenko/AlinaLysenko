package hwAPI;

import hwAPI.assertions.YandexSpellerAssertions;
import hwAPI.entity.data.InputTextData;
import hwAPI.entity.request.YandexSpellerRequest;
import hwAPI.entity.response.YandexSpellerResponse;
import hwAPI.enums.Lang;
import hwAPI.enums.Options;
import hwAPI.service.YandexSpellerService;
import org.testng.annotations.Test;

import java.util.List;

public class YandexSpellerCheckTextsTestClass extends AbstractTest{

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "syntaxErrorInTextsCase",
            description = "CheckTexts with one syntax error")
    public void checkTextSyntaxErrorTest(Lang lang, Options options, List<InputTextData> data) {
        YandexSpellerRequest request = new YandexSpellerRequest(lang, options, data);
        List<YandexSpellerResponse> result = yandexSpellerService.getCheckTexts(request);
        data.stream().forEach(e -> new YandexSpellerAssertions(result, e)
                .isNotEmptyResponse()
                .assertErrorCodesInTexts()
                .assertErrorDescriptionInTexts());
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "repeatedWordErrorInTextsCase",
            description = "CheckText with repeated words error")
    public void checkTextRepeatedWordErrorTest(Lang lang, Options options, List<InputTextData> data) {
        YandexSpellerRequest request = new YandexSpellerRequest(lang, options, data);
        List<YandexSpellerResponse> result = yandexSpellerService.getCheckTexts(request);
        data.stream().forEach(e -> new YandexSpellerAssertions(result, e)
                .isNotEmptyResponse()
                .assertErrorCodesInTexts()
                .assertErrorDescriptionInTexts());
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "capitalizationErrorInTextsCase",
            description = "CheckText with capitalization error")
    public void checkTextCapitalizationErrorTest(Lang lang, Options options, List<InputTextData> data) {
        YandexSpellerRequest request = new YandexSpellerRequest(lang, options, data);
        List<YandexSpellerResponse> result = yandexSpellerService.getCheckTexts(request);
        data.stream().forEach(e -> new YandexSpellerAssertions(result, e)
                .isNotEmptyResponse()
                .assertErrorCodesInTexts()
                .assertErrorDescriptionInTexts());
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "noErrorsInTextsCase",
            description = "CheckTexts with no errors")
    public void checkTextsNoErrorTest(Lang lang, Options options, List<InputTextData> data) {
        YandexSpellerRequest request = new YandexSpellerRequest(lang, options, data);
        List<YandexSpellerResponse> result = new YandexSpellerService().getCheckTexts(request);
        data.stream().forEach(e -> new YandexSpellerAssertions(result, e).isEmptyResponse());
    }

}
