package testrunner;


import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.*;


@Suite
@IncludeEngines("cucumber")
@SelectPackages("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME,value = "steps,hooks")
//@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME,value = "steps")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@smoke or @reg")

@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME,value = "pretty,io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm,html:target/cucumber-report.html,json:cucumber-report.json, rerun:target/rerun.txt")
public class TestRunnerClass {
}
