package hwAPI;

import hwAPI.assertions.YandexSpellerAssertions;
import hwAPI.entity.data.InputTextData;
import hwAPI.entity.request.YandexSpellerRequest;
import hwAPI.entity.response.YandexSpellerResponse;
import hwAPI.enums.Lang;
import hwAPI.enums.Options;
import org.testng.annotations.Test;

import java.util.List;

public class YandexSpellerCheckTextsTestClass extends AbstractTest {
    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "syntaxErrorInTextsCase",
            description = "CheckTexts with one syntax error")
    public void checkTextSyntaxErrorTest(Lang lang, Options options, List<InputTextData> data) {
        YandexSpellerRequest request = new YandexSpellerRequest(lang, options, data);
        List<List<YandexSpellerResponse>> result = yandexSpellerService.getCheckTexts(request);
        for (int i = 0; i < data.size(); i++) {
            new YandexSpellerAssertions(result.get(i), data.get(i))
                    .isNotEmptyResponse()
                    .isAllErrorsFound()
                    .assertErrorCode()
                    .assertMisspelledWord()
                    .assertSuggestions();
        }
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "repeatedWordErrorInTextsCase",
            description = "CheckText with repeated words error")
    public void checkTextRepeatedWordErrorTest(Lang lang, Options options, List<InputTextData> data) {
        YandexSpellerRequest request = new YandexSpellerRequest(lang, options, data);
        List<List<YandexSpellerResponse>> result = yandexSpellerService.getCheckTexts(request);
        for (int i = 0; i < data.size(); i++) {
            new YandexSpellerAssertions(result.get(i), data.get(i))
                    .isNotEmptyResponse()
                    .isAllErrorsFound()
                    .assertErrorCode()
                    .assertMisspelledWord();
        }
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "capitalizationErrorInTextsCase",
            description = "CheckText with capitalization error")
    public void checkTextCapitalizationErrorTest(Lang lang, Options options, List<InputTextData> data) {
        YandexSpellerRequest request = new YandexSpellerRequest(lang, options, data);
        List<List<YandexSpellerResponse>> result = yandexSpellerService.getCheckTexts(request);
        for (int i = 0; i < data.size(); i++) {
            new YandexSpellerAssertions(result.get(i), data.get(i))
                    .isNotEmptyResponse()
                    .isAllErrorsFound()
                    .assertErrorCode()
                    .assertMisspelledWord()
                    .assertSuggestions();
        }
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "noErrorsInTextsCase",
            description = "CheckTexts with no errors")
    public void checkTextsNoErrorTest(Lang lang, Options options, List<InputTextData> data) {
        YandexSpellerRequest request = new YandexSpellerRequest(lang, options, data);
        List<List<YandexSpellerResponse>> result = yandexSpellerService.getCheckTexts(request);
        for (int i = 0; i < data.size(); i++) {
            new YandexSpellerAssertions(result.get(i), data.get(i))
                    .isEmptyResponse();
        }
    }
}
