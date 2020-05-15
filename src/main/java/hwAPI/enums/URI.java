package hwAPI.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static hwAPI.utils.PropertyReader.getProperties;

@AllArgsConstructor
@Getter
public enum URI {

    BASE_URI (getProperties().getProperty("URI").toString()),
    CHECK_TEXT ("/checkText"),
    CHECK_TEXTS ("/checkTexts");

    private String value;

}
