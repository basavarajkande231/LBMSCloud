package stepDefinition;

import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.ConfigurationsPage;
import pageObjects.NavigationPage;
import resources.BrowserUtils;
import org.junit.Assert;

import resources.base;


public class ConfigurationsStepDefinition extends base{
	ConfigurationsPage Configurations=new ConfigurationsPage(driver);	
	NavigationPage Navigation = new NavigationPage(driver);

	
	@Then("click on Add new program")
	public void click_on_add_new_program() throws InterruptedException {
		BrowserUtils.clickElement(Configurations.getNewProgram());
		//Thread.sleep(3000);
	}
	@Then("Add {string} {string} {string} {string} {string}")
	public void add(String string, String string2, String string3, String string4, String string5) throws InterruptedException {
		BrowserUtils.enterText(Configurations.getFirstName(), string);
	    BrowserUtils.enterText(Configurations.getLastName(), string2);
		BrowserUtils.enterText(Configurations.getEmail(), string3);
		BrowserUtils.enterText(Configurations.getCountryCode(), string4);
		BrowserUtils.submit(Configurations.getCountryCode());
		BrowserUtils.enterText(Configurations.getPhone(), string5);
	}
	
	@Then("Click on continue button")
	public void click_on_continue_button() throws Throwable {
		BrowserUtils.clickElement(Configurations.getContinue());

	}
	
	@Then("Add company deatils {string} {string} {string} {string} {string}")
	public void add_company_deatils(String string, String string2, String string3, String string4, String string5) throws Throwable {
		BrowserUtils.enterText(Configurations.getBusiness(), string);
		BrowserUtils.enterText(Configurations.getCompany(), string2);
		BrowserUtils.enterText(Configurations.getCity(), string3);
		BrowserUtils.enterText(Configurations.getRegion(), string4);
		BrowserUtils.enterText(Configurations.getCountryCode(), string5);
		BrowserUtils.submit(Configurations.getCountryCode());
	   
	}
	@Then("Add {string}")
	public void add(String ProgramName) throws Throwable {
		  BrowserUtils.enterText(Configurations.getProgram(),ProgramName);
    }

	@Then("Add Program Logo")
	public void add_program_logo() throws Throwable {
		
		WebElement fileInput = Configurations.getFilePath();
        //WebElement fileInput = BrowserUtils.findElementByXpath("//input[@type='file']");
        String filePath = System.getProperty("user.dir") + "/test-output/suite/people.png";
        BrowserUtils.uploadFile(fileInput, filePath);
        WebElement saveImage = Configurations.getSaveImage();
      // WebElement saveImage = BrowserUtils.findElementByXpath("//span[text()='Save']");
        saveImage.click();
        
	}
	
	@Then("Select Base Currency {string}")
	public void select_base_currency(String string) throws InterruptedException {
		BrowserUtils.enterText(Configurations.getCountryCode(), string);
		BrowserUtils.submit(Configurations.getCountryCode());
		//Thread.sleep(1000);

	}
	
	@Then("Add Points Terminology as {string} {string} {string}")
	public void add_points_terminology_ad(String string, String string2, String string3) throws Throwable {
		BrowserUtils.enterText(Configurations.getSingular(),string);
		BrowserUtils.enterText(Configurations.getPlural(),string2);
		BrowserUtils.ClearAndEnterText(Configurations.getExpiration(),string3);
	}
	@Then("Select Point Expiration Period as {string}")
	public void select_point_expiration_period_as(String string1) throws InterruptedException {
		//Thread.sleep(1000);
		BrowserUtils.enterText(Configurations.getExpirationPeriod(), string1);
		BrowserUtils.submit(Configurations.getExpirationPeriod());
	}
	@Then("Add Cashback Rate {string} Customer Purchase Rate {string} Redemption Rate {string}")
	public void add_cashback_rate_customer_purchase_rate_redemption_rate(String string, String string2, String string3) throws Throwable {
		BrowserUtils.enterText(Configurations.getCashback(),string);
		BrowserUtils.enterText(Configurations.getPurchaseRate(),string2);
		BrowserUtils.enterText(Configurations.getRedemptionRate(),string3);
		//Thread.sleep(1000);
	}

	@Then("Click on Create program")
	public void click_on_create_program() throws Throwable {
		BrowserUtils.clickElement(Configurations.createProgram());
		Thread.sleep(5000);

	}
    @Given("Click on Configurations")
	public void click_on_configurations() throws Throwable{
		//BrowserUtils.clickElement(Configurations.ClickONConfigurations());
    	BrowserUtils.clickElement(Navigation.getConfigurations());
		Thread.sleep(1000);

	}
	@Then("Click on Organisation")
	public void click_on_organisation() throws InterruptedException {
		//BrowserUtils.clickElement(Configurations.ClickONOrganisation());
    	BrowserUtils.clickElement(Navigation.getOrganisation());
    	Thread.sleep(1000);
	}
	
	@Then("Edit basic details As {string} {string} {string} {string}")
	public void edit_basic_details(String string, String string2, String string3, String string4) throws InterruptedException {
		BrowserUtils.clickElement(Configurations.ClickONEdit());
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getFirstName(), string);
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getLastName(), string2);
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getEmail(), string3);
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getPhone(), string4);
		//Thread.sleep(1000);
		BrowserUtils.clickElement(Configurations.cancelEdit());
		//Thread.sleep(1000);
	}
	@Then("Edit company details As {string} {string} {string} {string}")
	public void edit_company_details_as(String string, String string2, String string3, String string4) throws Throwable {
		BrowserUtils.clickElement(Configurations.ClickONEdit2());
		Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getBusiness(), string);
		BrowserUtils.ClearAndEnterText(Configurations.getCompany(), string2);
		BrowserUtils.ClearAndEnterText(Configurations.getCity(), string3);
		BrowserUtils.ClearAndEnterText(Configurations.getRegion(), string4);
		BrowserUtils.clickElement(Configurations.cancelEdit());
		Thread.sleep(1000);
	}
	@Then("Add Program name")
	public void add_program_name() {
	String uniqueName = BrowserUtils.generateUniqueName();
       // WebElement nameTextbox = BrowserUtils.findElementByXpath("//input[@placeholder='Enter Program Name']");
		WebElement nameTextbox = Configurations.getProgram();
        nameTextbox.sendKeys(uniqueName);
        System.out.println(uniqueName);
        System.out.println("****************"+uniqueName+"******#$%^&*");
	}
	
	@Then("Click on recently created program")
	public void Click_on_recently_created_program() throws Throwable {
		Thread.sleep(1000);
		BrowserUtils.clickOnProgram(driver, BrowserUtils.newProgram); 
	}
	
	@Then("Verify Program Name")
		public void Verify_Program_Name() {
		String prgm= BrowserUtils.verifyProgram(driver, BrowserUtils.newProgram);
		WebElement displayedProgramName=Configurations.recentProgram();
		String prgm2=displayedProgramName.getText();
		Assert.assertEquals(prgm , prgm2);
	}
	@Then("Click on Cancel")
	public void Click_on_Cancel() throws InterruptedException {
	BrowserUtils.clickElement(Configurations.cancelEdit());
	//Thread.sleep(1000);
	}
	@Then("Click on Done")
	public void Click_on_Done()throws InterruptedException {
		
		BrowserUtils.clickElement(Configurations.getDone());
		Thread.sleep(5000);
	}
	@When("Click on Program")
	public void click_on_program() throws Throwable {
		BrowserUtils.clickElement(Configurations.getSectionProgram());
	}
	@Then("Click on Program Details try to edit then cancel {string}")
	public void click_on_program_details_try_to_edit_then_cancel(String string) throws Throwable {
		BrowserUtils.clickElement(Configurations.getProgramDetails());
		BrowserUtils.clickElement(Configurations.ClickONEdit());
		BrowserUtils.enterText(Configurations.getProgram(),string);
		Thread.sleep(1000);
		BrowserUtils.clickElement(Configurations.cancelEdit());
		Thread.sleep(1000);
	}
	@Then("Click on Point Definition try to edit then cancel {string} {string} {string} {string} {string}")
	public void click_on_point_definition_try_to_edit_then_cancel(String string, String string2, String string3, String string4, String string5) throws Throwable {
		BrowserUtils.clickElement(Configurations.getPointDefinition());
		BrowserUtils.clickElement(Configurations.ClickONEdit());
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getSingular(), string);
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getPlural(), string2);
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getCashback(), string3);
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getPurchaseRate(), string4);
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getRedemptionRate(), string5);
		//Thread.sleep(1000);
		BrowserUtils.clickElement(Configurations.cancelEdit());
		//Thread.sleep(1000);
	}
	@Then("Click on Marketplace")
	public void click_on_marketplace() throws Throwable {
		BrowserUtils.clickElement(Configurations.getMarketplace());
	}
	@Then("Click on Communication try to edit then cancel {string} {string}")
	public void click_on_communication_try_to_edit_then_cancel(String string, String string2)  throws Throwable {
		BrowserUtils.clickElement(Configurations.getCommunication());
		BrowserUtils.clickElement(Configurations.ClickONEdit());
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getSenderName(), string);
		//Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Configurations.getSenderEmail(), string2);
		BrowserUtils.clickElement(Configurations.cancelEdit());
		//Thread.sleep(1000);
	}
}
	

	
	

