package stepDefinition;


import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import resources.base;

public class Hooks extends base {

	@BeforeAll
	public static void beforeAll() throws IOException, InterruptedException {
		initializeDriver();
		System.out.println("running before all");
	}

	@AfterAll
	public static void aftermethod() throws InterruptedException {
		//Thread.sleep(3000);
		//driver.close();
		System.out.println("running after all");
	}

	/*
	@After(order = 1)
	public void takeScreenShotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	*/
	@After(order = 1)
	public void takeScreenShotOnFailure(Scenario scenario) {
		if (scenario.isFailed()) {
			 byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
	}
	
	
}

	
	


