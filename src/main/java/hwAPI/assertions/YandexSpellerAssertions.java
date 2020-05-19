package hwAPI.assertions;

import hwAPI.entity.data.InputTextData;
import hwAPI.entity.response.YandexSpellerResponse;
import hwAPI.enums.ErrorCode;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class YandexSpellerAssertions {

    private List<YandexSpellerResponse> result;
    private InputTextData excpectedData;

    public YandexSpellerAssertions(List<YandexSpellerResponse> result, InputTextData excpectedData) {
        this.result = result;
        this.excpectedData = excpectedData;
    }

    public YandexSpellerAssertions isAllErrorsFound() {
        assertThat(result.size())
                .withFailMessage(
                        "In text was %s errors, but was found %s",
                        excpectedData.getErrors().size(), result.size())
                .isEqualTo(excpectedData.getErrors().size());
        return this;
    }

    public YandexSpellerAssertions assertErrorCode() {
        for (int i = 0; i < excpectedData.getErrors().size(); i++) {
            assertThat(result.get(i).getCode())
                    .withFailMessage("Expected %s error code, but was found %s",
                            excpectedData.getErrors().get(i).getCode(), ErrorCode.valueOfCode(result.get(i).getCode()))
                    .isEqualTo(excpectedData.getErrors().get(i).getCode().getValue());
        }
        return this;
    }

    public YandexSpellerAssertions assertSuggestions() {
        for (int i = 0; i < excpectedData.getErrors().size(); i++) {
            assertThat(result.get(i).getS())
                    .withFailMessage("Expected %s will be suggested as correct, but was not",
                            excpectedData.getErrors().get(i).getSuggestedWord())
                    .contains(excpectedData.getErrors().get(i).getSuggestedWord());
        }
        return this;
    }

    public YandexSpellerAssertions assertMisspelledWord() {
        for (int i = 0; i < excpectedData.getErrors().size(); i++) {
            assertThat(result.get(i).getWord())
                    .withFailMessage("Expected %s will be defined as misspelled, but was found %s",
                            excpectedData.getErrors().get(i).getExpectedMistakes(), result.get(i).getWord())
                    .isEqualTo(excpectedData.getErrors().get(i).getExpectedMistakes());
        }
        return this;
    }

    public YandexSpellerAssertions isEmptyResponse() {
        assertThat(result).withFailMessage("Found unexpected errors %s", result.toString()).isEmpty();
        return this;
    }

    public YandexSpellerAssertions isNotEmptyResponse() {
        assertThat(result).withFailMessage("Expected errors not found").isNotEmpty();
        return this;
    }
}
