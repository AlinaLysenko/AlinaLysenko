package hwAPI.entity.data;

import hwAPI.enums.Lang;
import hwAPI.enums.Options;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
@Builder(builderMethodName = "builder")
public class InputTextData {

    private String text;
    private Lang lang;
    private Options options;
    private List<ErrorDescription> errors;
}
