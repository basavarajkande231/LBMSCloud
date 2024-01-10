package stepDefinition;

import static org.testng.Assert.assertEquals;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MemberSearchPage;
import resources.BrowserUtils;
import resources.base;

public class MemberSearchStepDefinition extends base {


	MemberSearchPage Membersearch=new MemberSearchPage(driver);

	@Given("^Naviagte to member search module$")
	public void NavigateToMemberSearch() throws Throwable {                      				
		Thread.sleep(5000);
		BrowserUtils.clickElement(Membersearch.getMemberSearch());
		Thread.sleep(5000);
	}	

	@When("enter different search {string} and {string}")
	public void enter_different_search(String types, String options) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		BrowserUtils.enterText(Membersearch.getMemberSearchField(), options);
		Thread.sleep(5000);

	}


	@Then("click on the first search result") public void
	click_on_the_first_search_result() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		//Thread.sleep(2000);		  
		BrowserUtils.clickElement(Membersearch.getFirstSearchRow());

	}

	@When("Validate the following details {string} and {string}")
	public void Validate_the_following_details(String types, String options) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		//Thread.sleep(1000);
		if (types.equalsIgnoreCase("name")) {
			String memberName = Membersearch.GetMemberName(options);
			System.out.println(memberName);
			//Thread.sleep(1000);
			assertEquals(options, memberName);


		}else if (types.equalsIgnoreCase("member_ref_no")) {
			String getMemberRefNo = Membersearch.GetMemberRefNo(options);
			Thread.sleep(1000);
			assertEquals(options, getMemberRefNo);

		}
		else if (types.equalsIgnoreCase("mobile")) {
			String getmemberMobile = Membersearch.GetMemberMobile(options);
			//Thread.sleep(1000);
			assertEquals(options, getmemberMobile);


		}		    		   
		else if (types.equalsIgnoreCase("email")) {
			String getmemberEMail = Membersearch.GetmemberEMail(options);
			//Thread.sleep(1000);
			assertEquals(options, getmemberEMail);

		}		    		    
		else {
			System.out.println("type is not defined");
		}		  				
	}

	@When("search member {string}")
	public void search_member(String searchValue) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		BrowserUtils.enterText(Membersearch.getMemberSearchField(), searchValue);
		Thread.sleep(5000);

	}

	@Then("click on Actions")
	public void ClickOnActions() throws InterruptedException {		
		BrowserUtils.clickElement(Membersearch.getActionButton());
	}

	@Then("issue manual {string} point of {string} with {string}")
	public void issue_manual_credit_point(String txntype, String points, String Description) throws InterruptedException {

		BrowserUtils.clickElement(Membersearch.getAddRemovePointsButton());
		BrowserUtils.enterText(Membersearch.getTXNTypeField(), txntype);		  
		BrowserUtils.submit(Membersearch.getTXNTypeField());
		BrowserUtils.enterText(Membersearch.getPointsField(), points);
		BrowserUtils.enterText(Membersearch.getDesField(), Description);

		BrowserUtils.clickElement(Membersearch.getSubmitButton());
		Thread.sleep(3000);

	}

	@Then("click on suspend and confirm")
	public void ClickOnSuspend() throws InterruptedException {
		BrowserUtils.clickElement(Membersearch.getSuspendButton());
		BrowserUtils.clickElement(Membersearch.getConfirmationButton());

	}

	@Then("click on Re-Activate")
	public void ClickOnReActivate() throws InterruptedException {
		BrowserUtils.clickElement(Membersearch.getReActivateButton());
	}

	@Then("click on Audit_log")
	public void click_on_audit_log() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		BrowserUtils.clickElement(Membersearch.getAuditLogButton());
	}

	@And("Enter {string} {string} and click on Search")
	public void Enter_date_range(String FromdateVal, String TodateVal) throws InterruptedException {
		//Write code here that turns the phrase above into concrete actions
		BrowserUtils.ClearAndEnterText(Membersearch.getFromDate(), FromdateVal);
		BrowserUtils.ClearAndEnterText(Membersearch.getToDate(), TodateVal);
		BrowserUtils.clickElement(Membersearch.getSearchButton());
		driver.navigate().refresh();
		Thread.sleep(2000);
	}


	@When("click on manage member attributes link")
	public void click_on_manage_member_attributes_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		BrowserUtils.clickElement(Membersearch.getMemberAttributeLink());
	}

	@When("click on Add new custom attribute link")
	public void click_on_Add_new_custom_attribute_link() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		BrowserUtils.clickElement(Membersearch.getAddNewCustomAttributeButton());
	}

	@Then("Enter value {string} {string} {string} {string} {string}")
	public void Enter_value(String Attribute_Name, String API_Key, String Data_Type, String Mandatory, String Unique) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		BrowserUtils.enterText(Membersearch.getAttributeName(), Attribute_Name);
		BrowserUtils.enterText(Membersearch.getAPIKey(), API_Key);
		BrowserUtils.enterText(Membersearch.getDataType(), Data_Type);
		BrowserUtils.submit(Membersearch.getDataType());
		if (Mandatory.equalsIgnoreCase("true")) {
			BrowserUtils.clickElement(Membersearch.getMandatoryCheckBox());	
		}else {
			System.out.println("mandatory is set to false hence not enabling");
		}
		if (Unique.equalsIgnoreCase("true")) {
			BrowserUtils.clickElement(Membersearch.getUniqueCheckBox());
		}else {
			System.out.println("Unique is set to false hence not enabling");
		}			
		//BrowserUtils.clickElement(Membersearch.getCancelButton());
		BrowserUtils.clickElement(Membersearch.getSaveButton());

	}
}
