package hwAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Fields {

    PARAM_TEXT("text"),
    PARAM_OPTIONS("options"),
    PARAM_LANG("lang");

    String value;
}

