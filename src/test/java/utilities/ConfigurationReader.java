package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties = new Properties();

    public static String getProperty(String fileName, String key) {
        try {
            String path = "src/test/resources/"+ fileName;
            //FileInputStream is Java class and will read the file
            FileInputStream stream = new FileInputStream(path);
            properties = new Properties();
            //this will load the value from key
            properties.load(stream);
            stream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(key); }

}
