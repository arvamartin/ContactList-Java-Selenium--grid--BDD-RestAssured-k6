package framework.core.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    static {
        try (InputStream fis = ConfigReader.class.getClassLoader().getResourceAsStream("CONFIG_FILE_PATH")){
            if (fis != null) {
                properties.load(fis);
            } else {
                throw new RuntimeException("Could not find Config.properties");
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not load Config.properties", e);
        }
    }

    public static String getValue(String section, String key) {
        String prefixedKey = section + "." + key;

        String systemProperty = System.getProperty(prefixedKey);
        if (systemProperty != null && !systemProperty.isEmpty()) {
            return systemProperty;
        }
        return properties.getProperty(prefixedKey);
    }
}