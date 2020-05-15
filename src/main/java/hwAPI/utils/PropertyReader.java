package hwAPI.utils;

import lombok.SneakyThrows;
import java.util.Properties;

public class PropertyReader {
    private static String fileName = "hwAPI/config.properties";

    @SneakyThrows
    public static Properties getProperties() {
        Properties properties = new Properties();
        String propertyPath = fileName;
        properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(propertyPath));
        return properties;
    }
}
