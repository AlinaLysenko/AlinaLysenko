package hw_jdi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw_jdi.entities.MetalsAndColorsDTO;
import hw_jdi.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class MetalsAndColorsDataProvider {
    private static final String PATH = "src\\test\\resources\\hw_jdi\\JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "dataset")
    public Object[] getData() {
        ArrayList<MetalsAndColorsData> list = new ArrayList<>();
        HashMap<String, MetalsAndColorsDTO> map = getMapFromFile(PATH);
        for (MetalsAndColorsDTO value : map.values()) {
            list.add(MetalsAndColorsDTO.getMetalAndColorsFromDTO(value));
        }
        return list.toArray();
    }


    private HashMap<String, MetalsAndColorsDTO> getMapFromFile(String path) {
        HashMap<String, MetalsAndColorsDTO> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(new File(path), new TypeReference<HashMap<String, MetalsAndColorsDTO>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
