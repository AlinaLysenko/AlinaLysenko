package hwAPI.entity.request;

import hwAPI.entity.data.InputTextData;
import hwAPI.enums.Fields;
import hwAPI.enums.Lang;
import hwAPI.enums.Options;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(builderMethodName = "builder")
public class YandexSpellerRequest {
    private List<String> texts;
    private String text;
    private Lang lang;
    private Options options;

    public YandexSpellerRequest(InputTextData data) {
        this.text = data.getText();
        this.lang = data.getLang();
        this.options = data.getOptions();
    }

    public YandexSpellerRequest(Lang lang, Options options, List<InputTextData> data) {
        this.texts = data.stream().map(InputTextData::getText).collect(Collectors.toList());
        this.lang = lang;
        this.options = options;
    }

    public Map<String, Object> paramsToMap(){
        Map<String, Object> params = new HashMap<>();
        if (text != null) {
            params.put(Fields.PARAM_TEXT.getValue(), text);
        }
        if (texts != null) {
            params.put(Fields.PARAM_TEXT.getValue(), texts);
        }
        if (options != null) {
            params.put(Fields.PARAM_OPTIONS.getValue(), options.getValue());
        }
        return params;
    }
}


