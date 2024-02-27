package lk.ijse.config;

import java.io.IOException;
import java.util.Properties;

public class Utility {
    public static Properties getProperties(){
        Properties properties = new Properties();

        try {
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (IOException e) {
            System.out.println("property file not found");
            System.out.println(e.getMessage());
        }
        return properties;
    }
}
