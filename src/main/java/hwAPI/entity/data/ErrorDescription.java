package hwAPI.entity.data;

import hwAPI.enums.ErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(builderMethodName = "builder")
public class ErrorDescription {
    private String expectedMistakes;
    private ErrorCode code;
    private String suggestedWord;
}
