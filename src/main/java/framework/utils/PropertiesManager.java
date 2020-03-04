package framework.utils;

import framework.logger.MyLogger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static final MyLogger LOGGER = new MyLogger();
    private static FileInputStream fileInputStream;
    private static Properties properties = new Properties();
    private static String path = "src/main/resources/%s.properties";


    public static void loadProperties(String name) {
        try (FileInputStream fileInputStream = new FileInputStream(String.format(path, name))) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error("line in properties file: " + String.format(path, name) + " not found", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
