package config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    static Properties prop=new Properties();

    static {
        try(InputStream in= ConfigReader.class.getClassLoader().getResourceAsStream("config.properties")){
           if(in==null){
               throw new IllegalAccessException("file config.properties not found");
           }
            prop.load(in);
        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static String get(String key){

        String value=System.getProperty(key,prop.getProperty(key));
        if(value==null){
            throw new RuntimeException(key+" is not set");
        }
        return value;
    }
}
