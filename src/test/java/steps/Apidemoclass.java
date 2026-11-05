package steps;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Apidemoclass {

    AndroidDriver driver;


    @Given("User is on home page")
    public void user_is_on_home_page() throws MalformedURLException {

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).isDisplayed();

    }
    @When("User click on text button")
    public void user_click_on_text_button() {

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Text\"]")).click();
    }
    @Then("User navigated to text related submenu")
    public void user_navigated_to_text_related_submenu() {

        DriverManager.getDriver().findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Linkify\"]")).isDisplayed();

    }

}
