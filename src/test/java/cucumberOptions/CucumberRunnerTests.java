package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
    
@CucumberOptions(tags = "", features = {"src/test/java/features"}, glue = {"stepDefinition"},
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

    
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    
}