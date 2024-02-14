package stepDefinition;


import static org.testng.AssertJUnit.assertEquals;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import pageObjects.NavigationPage;
import resources.BrowserUtils;
import resources.base;

public class LoginStepDefinition extends base {

	LoginPage login=new LoginPage(driver);	

	@Given("Login to the application using username and password")
	public void Login() throws Throwable {

		System.out.println("login");  

		BrowserUtils.enterText(login.getUserName(), base.getusername());

		BrowserUtils.enterText(login.getPassword(), base.getpassword());

		BrowserUtils.clickElement(login.getViewPassword());

		BrowserUtils.clickElement(login.getSignIn());

	}	
	@When("^validate if the title is \"([^\"]*)\"$")
	public void validate_if_the_title_is_something( String ExpectedTitle) throws Throwable {
		Thread.sleep(500);		
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);		
		assertEquals(ActualTitle, ExpectedTitle);
	}	
	@Then("^close browser$")
	public void close_browser() throws Throwable {

		System.out.println("logout");

	}

	NavigationPage Navigation=new NavigationPage(driver);

	@When("^click on the profile section$")
	public void click_on_the_profile_section_using_something() throws Throwable {
		Thread.sleep(3000);

		BrowserUtils.clickElement(Navigation.getProfile());

	}


	@Then("^select the program \"([^\"]*)\"$")
	public void select_the_program(String strArg1) throws Throwable {
		Thread.sleep(500);

		try {
			List<WebElement> findAndWaitForElements = BrowserUtils.findAndWaitForElements(Navigation.getAllPrograms());
			for (WebElement webElement : findAndWaitForElements) {
				WebElement program = webElement.findElement(By.tagName("div"));
				String ProgramName = program.getText();
				if (strArg1.equalsIgnoreCase(ProgramName)) 
				{ 

					program.click();
					System.out.println("The selected program name is: " +ProgramName);
				}
			}            
		} catch (StaleElementReferenceException exc) {
			exc.printStackTrace();
		}

	}
}

