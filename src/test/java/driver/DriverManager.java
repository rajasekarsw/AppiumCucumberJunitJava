package driver;

import io.appium.java_client.AppiumDriver;

public class DriverManager {

    static private final ThreadLocal<AppiumDriver> DRIVER=new ThreadLocal<>();

    public static AppiumDriver getDriver(){
        return DRIVER.get();
    }
    public static void setDriver(AppiumDriver d){
        DRIVER.set(d);
    }
    public static void quitDriver(){
        if(DRIVER.get()!=null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
