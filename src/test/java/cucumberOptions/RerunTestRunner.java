package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//specify the feature file location
		features="@target/failedscenarios.txt",
		
		//specifiy spec definition location
		glue="stepDefinition",
		
		//specify if steps has to be enabled in report 
		stepNotifications = true,
		
		//specify tags if any particular test case has to be run
		tags = "@Smoketest1",
		
		//for neat console output
		monochrome=true,

		//checks if mapping exist between feature and spec definition file and does not execute in real
		//dryRun=true,
				
		// to generate cucumber report in different format
		plugin={"pretty","html:target/cucumber.html","json:target/cucumber.json",
				"junit:target/cucumber.xml","rerun:target/failedscenarios.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		//enable below plugin for extent adapter
		//plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},

		publish=true)
public class RerunTestRunner {

}
