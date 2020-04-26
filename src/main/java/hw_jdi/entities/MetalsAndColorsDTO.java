package hw_jdi.entities;

import hw_jdi.enums.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
public class MetalsAndColorsDTO {
    public List<Integer> summary;
    public List<String> elements;
    public String color;
    public String metals;
    public List<String> vegetables;

    public static MetalsAndColorsData getMetalAndColorsFromDTO(MetalsAndColorsDTO dto) {
        return new MetalsAndColorsData(
                dto.summary.get(0),
                dto.summary.get(1),
                dto.elements.stream().map(Elements::valueOf).collect(Collectors.toList()),
                Colors.valueOf(dto.color),
                Metals.valueOf(dto.metals),
                dto.vegetables.stream().map(Vegetables::valueOf).collect(Collectors.toList()));
    }
}
