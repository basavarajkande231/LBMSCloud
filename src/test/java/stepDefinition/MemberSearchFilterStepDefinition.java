package stepDefinition;

import org.openqa.selenium.JavascriptExecutor;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MemberSearchPage;
import resources.BrowserUtils;
import resources.base;

public class MemberSearchFilterStepDefinition extends base {

	MemberSearchPage Membersearch = new MemberSearchPage(driver);

	@When("^click on filter option$")
	public void click_on_filter_option() throws InterruptedException {
		
		//Use this code to perform scroll on application
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-550)", "");
		
		BrowserUtils.clickElement(Membersearch.getMemberFilter());
	}

	@Then("select {string} filter")
	public void select_filter(String FilterName) throws InterruptedException {
		Membersearch.GetFilterandClick(FilterName);		
	}

	@Then("Select operator {string}")
	public void select_operator(String operatorValue) throws InterruptedException {
		BrowserUtils.enterText(Membersearch.getOperator(), operatorValue);
		BrowserUtils.submit(Membersearch.getOperator());
	}

	@Then("Enter value1 {string} and value2 {string} for operator {string}")
	public void enter_value_for_operator(String inputvalue1, String inputvalue2, String operator)
			throws InterruptedException {
		
		if (operator.equalsIgnoreCase("Is greater than or equal to") || operator.equalsIgnoreCase("Is")
				|| operator.equalsIgnoreCase("Is within") || operator.equalsIgnoreCase("Is not within")
				|| operator.equalsIgnoreCase("Is less than or equal to") || operator.equalsIgnoreCase("Equals to")) {
			BrowserUtils.enterText(Membersearch.getInputValue1(), inputvalue1);
			BrowserUtils.clickElement(Membersearch.getAddFilter());
		}
		else if (operator.equalsIgnoreCase("Is between")||operator.equalsIgnoreCase("Is not between")) {
			BrowserUtils.enterText(Membersearch.getInputValue1(), inputvalue1);
			BrowserUtils.enterText(Membersearch.getInputValue2(), inputvalue2);
			BrowserUtils.clickElement(Membersearch.getAddFilter());
		}		
		
	}
	
	@Then("click on apply filter button and validate the result")
	public void click_on_apply_filter_and_validate_result() throws InterruptedException {
		BrowserUtils.clickElement(Membersearch.getApplyFilter());
	}
	

}
