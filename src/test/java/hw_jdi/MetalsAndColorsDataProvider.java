package hw_jdi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw_jdi.entities.MetalsAndColorsData;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


public class MetalsAndColorsDataProvider {
    private static final String PATH = "src\\test\\resources\\hw_jdi\\JDI_ex8_metalsColorsDataSet.json";

 @DataProvider(name = "dataset")
    public Object[] getData() {
        HashMap<String, MetalsAndColorsData> map = getMapFromFile(PATH);
        return map.values().toArray();
    }


    private HashMap<String, MetalsAndColorsData> getMapFromFile(String path) {
        HashMap<String, MetalsAndColorsData> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(new File(path), new TypeReference<HashMap<String, MetalsAndColorsData>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }



}
