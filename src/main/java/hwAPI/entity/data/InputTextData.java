package hwAPI.entity.data;

import hwAPI.enums.ErrorCode;
import hwAPI.enums.Lang;
import hwAPI.enums.Options;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder(builderMethodName = "builder")
public class InputTextData {

    private String text;
    private Lang lang;
    private Options options;

    private List<ErrorDescription> errors;

}
