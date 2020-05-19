package hwAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    ERROR_UNKNOWN_WORD(1),
    ERROR_REPEAT_WORD(2),
    ERROR_CAPITALIZATION(3),
    ERROR_TOO_MANY_ERRORS(4);

    private Integer value;

    public static ErrorCode valueOfCode(Integer errorCode) {
        for (ErrorCode code : values()) {
            if (code.value.equals(errorCode)) {
                return code;
            }
        }
        return null;
    }
}
