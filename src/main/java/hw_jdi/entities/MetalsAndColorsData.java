package hw_jdi.entities;

import com.epam.jdi.tools.DataClass;
import hw_jdi.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class MetalsAndColorsData extends DataClass<MetalsAndColorsData> {

    private static final String LINE_SEPARATOR = ", ";
    public List<Integer> summary;
    private List<Elements> elements;
    private Colors color;
    private Metals metals;
    private List<Vegetables> vegetables;

    public List<String> getExpectedResults(){
        return new ArrayList<String>() {{
            add("Summary: " + sum());
            add("Elements: " + elements.stream().map(Enum::name).collect(Collectors.joining(LINE_SEPARATOR)));
            add("Color: " + color.name());
            add("Metal: " + metals.name());
            add("Vegetables: " + vegetables.stream().map(Enum::name).collect(Collectors.joining(LINE_SEPARATOR)));
        }};
    }

    private int sum() {
        return summary.stream().mapToInt(Integer::intValue).sum();

    }
}