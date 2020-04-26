package hw_jdi.entities;

import com.epam.jdi.tools.DataClass;
import hw_jdi.enums.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
public class MetalsAndColorsData extends DataClass<MetalsAndColorsData> {

    private static final String LINE_SEPARATOR = ", ";

    private int oddSummaryNumber;
    private int evenSummaryNumber;
    private List<Elements> elements;
    private Colors color;
    private Metals metal;
    private List<Vegetables> vegetables; //todo refactor to enums

    public List<String> getExpectedResults(){
        return new ArrayList<String>() {{
            add("Summary: " + sum());
            add("Elements: " + elements.stream().map(Enum::name).collect(Collectors.joining(LINE_SEPARATOR)));
            add("Color: " + color.name());
            add("Metal: " + metal.name());
            add("Vegetables: " + vegetables.stream().map(Enum::name).collect(Collectors.joining(LINE_SEPARATOR)));
        }};
    }

    private int sum() {
        return (oddSummaryNumber + evenSummaryNumber);
    }
}