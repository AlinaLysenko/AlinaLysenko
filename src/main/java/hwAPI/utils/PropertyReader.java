package hwAPI.utils;

import lombok.SneakyThrows;

import java.util.Properties;

public class PropertyReader {

    private static String fileName = "hwAPI/config.properties";
    private static Properties properties;

    @SneakyThrows
    public static Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.load(PropertyReader.class.getClassLoader().getResourceAsStream(fileName));
        }
        return properties;
    }
}
