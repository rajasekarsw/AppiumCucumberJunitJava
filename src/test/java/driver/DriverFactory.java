package driver;

import config.ConfigReader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    public static AppiumDriver getDriver(){


        try{
            URL url=new URI(ConfigReader.get("appium.url")).toURL();

            String platform=ConfigReader.get("platform").toLowerCase();

            if(platform.equals("android")){

                UiAutomator2Options options=new UiAutomator2Options()
                        //.setDeviceName()
                       // .setAppPackage(ConfigReader.get("android.appPackage"))
                        .setPlatformName(platform)
                        //.setAppActivity("android.appActivity")
                        .setAutoGrantPermissions(true)
                        .setNewCommandTimeout(Duration.ofSeconds(120));
                Map<String,Object> map=new HashMap<>();
                map.put("username","oauth-rajrams104-68fae");
                map.put("accessKey","8727c431-3511-4e8b-877e-88546a3f4a05");
                map.put("appiumVersion","latest");
                map.put("idleTimeout","60");
                options.setCapability("sauce:options",map);
                options.setApp("storage:filename=ApiDemos-debug.apk");

                return new AndroidDriver(url,options);

            }
            else{
                XCUITestOptions options=new XCUITestOptions();
                return new IOSDriver(url,options);
            }

        }
        catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

}
