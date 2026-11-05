package hooks;

import driver.DriverFactory;
import driver.DriverManager;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.AttachmentOptions;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;

public class Hooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        DriverManager.setDriver(DriverFactory.getDriver());
    }
    @AfterStep
    public void afterStep(Scenario scenario){
      byte[] shot=DriverManager.getDriver().getScreenshotAs(OutputType.BYTES);
      //scenario.attach(shot,"image/png",scenario.getName());

      Allure.attachment("step screenshot","image/png",new ByteArrayInputStream(shot),AttachmentOptions.withFileExtension("png"));
    }
}
