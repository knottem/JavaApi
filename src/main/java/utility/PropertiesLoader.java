package utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    public static Properties properties = new Properties();

    public PropertiesLoader() {
        try {
            InputStream inputFile = PropertiesLoader.class.getClassLoader().getResourceAsStream("config.properties");
            if (inputFile != null) {
                properties.load(inputFile);
                inputFile.close();
            } else {
                System.out.println("File not found");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFakeStoreServer(){
        return properties.getProperty("fakestoreapi.server");
    }

    public String getWeatherServer(){
        return properties.getProperty("weatherapi.server");
    }




}
