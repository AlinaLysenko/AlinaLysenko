package hwAPI;

import hwAPI.assertions.YandexSpellerAssertions;
import hwAPI.entity.data.InputTextData;
import hwAPI.entity.request.YandexSpellerRequest;
import hwAPI.entity.response.YandexSpellerResponse;
import org.testng.annotations.Test;
import java.util.List;

public class YandexSpellerCheckTextTestClass extends AbstractTest {

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "syntaxErrorCase",
            description = "CheckText with one syntax error")
    public void checkTextSyntaxErrorTest(InputTextData data) {
        YandexSpellerRequest request = new YandexSpellerRequest(data);
        List<YandexSpellerResponse> result = yandexSpellerService.getCheckText(request);
        new YandexSpellerAssertions(result, data)
                .isNotEmptyResponse()
                .isAllErrorsFound()
                .assertErrorCode()
                .assertMisspelledWord()
                .assertSuggestions();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "repeatedWordErrorCase",
            description = "CheckText with repeated words error")
    public void checkTextRepeatedWordErrorTest(InputTextData data) {
        YandexSpellerRequest request = new YandexSpellerRequest(data);
        List<YandexSpellerResponse> result = yandexSpellerService.getCheckText(request);
        new YandexSpellerAssertions(result, data)
                .isNotEmptyResponse()
                .isAllErrorsFound()
                .assertErrorCode()
                .assertMisspelledWord();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "capitalizationErrorCase",
            description = "CheckText with capitalization error")
    public void checkTextCapitalizationErrorTest(InputTextData data) {
        YandexSpellerRequest request = new YandexSpellerRequest(data);
        List<YandexSpellerResponse> result = yandexSpellerService.getCheckText(request);
        new YandexSpellerAssertions(result, data)
                .isNotEmptyResponse()
                .isAllErrorsFound()
                .assertErrorCode()
                .assertMisspelledWord()
                .assertSuggestions();
    }

    @Test(dataProviderClass = YandexSpellerDataProvider.class, dataProvider = "noErrorsCase",
            description = "CheckText with no errors")
    public void checkTextNoErrorTest(InputTextData data) {
        YandexSpellerRequest request = new YandexSpellerRequest(data);
        List<YandexSpellerResponse> result = yandexSpellerService.getCheckText(request);
        new YandexSpellerAssertions(result, data)
                .isEmptyResponse();
    }
}
