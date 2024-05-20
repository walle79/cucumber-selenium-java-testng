package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features", // features file path
        glue = {"stepDefinitions", "hooks",}, // stepDefinitions file path
        monochrome = true, // display step format in console
        plugin = {"pretty", "html:target/site/cucumber-report-default.html", "json:target/site/cucumber.json", "utilities.AllureCucumberListener"},
        snippets = CucumberOptions.SnippetType.CAMELCASE, // generate step format CAMELCASE/ UNDERSCORE
<<<<<<< HEAD
        tags = "@RegisterUser"
=======
        tags = {"@Login,@Sort"}
>>>>>>> 08a8e3b0f37f65f26dac728507fa1c370d60b271
)

public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
