package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesFileHelpers {

    private static Properties properties;
    private static FileInputStream fileIn;
    private static FileOutputStream fileOut;
    static String projectPath = System.getProperty("user.dir") + "/";

    public static void setPropertiesFile(String propertiesPath) {
        properties = new Properties();
        try {
            fileIn = new FileInputStream(projectPath + propertiesPath);
            //Load properties file
            properties.load(fileIn);
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

    public static String getPropValue(String KeyProp) {
        String value = null;
        try {
            //get values from properties file
            value = properties.getProperty(KeyProp);
            System.out.println(value);
            return value;
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
        return value;
    }

    public static void setPropValue(String KeyProp, String Value, String propertiesPath) {
        try {
            fileOut = new FileOutputStream(projectPath + propertiesPath);
            properties.setProperty(KeyProp, Value);
            properties.store(fileOut, "Set new value in properties file");
            System.out.println("Set new value in file properties success.");
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            System.out.println(exp.getCause());
            exp.printStackTrace();
        }
    }

}
