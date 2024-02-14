package stepDefinition;

import pageObjects.NavigationPage;
import pageObjects.SegmentPage;
import resources.BrowserUtils;
import resources.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.*;

public class SegmentStepDefinition extends base {

	NavigationPage Navigation1 = new NavigationPage(driver);
	SegmentPage Segment = new SegmentPage(driver);


	@Given("User navigates to segment module")
	public void user_navigates_to_segment_module() throws InterruptedException {

		BrowserUtils.clickElement(Navigation1.getClickEngage());
		BrowserUtils.clickElement(Navigation1.getClickSegmentModule());
		Thread.sleep(1000);	
	}


	@When("user clicks on the Enable Segment or Create segment button")
	public void user_clicks_on_the_enable_segment_or_create_segment_button() throws InterruptedException {

		BrowserUtils.clickElement(Segment.getCreateSegmentButton());
		Thread.sleep(1000);

	}


	@And ("user enter the segment name as {string} and sagment tag as {string}")
	public void user_enter_the_segment_name_as_and_sagment_tag_as(String SegmentName, String SegmentTag) throws InterruptedException {

			BrowserUtils.ClearAndEnterText(Segment.getSegmentName(), SegmentName);
			BrowserUtils.ClearAndEnterText(Segment.getSegmentTag(), SegmentTag);
	
	}


	@And("select the {string} as filter")
	public void select_the_as_filter(String FilterName) throws InterruptedException {

		try {

			if(FilterName.equalsIgnoreCase("Last Transaction")){
				//Use the below code to scroll the application untill the web element is find
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Segment.getAddFilterButton());
				BrowserUtils.clickElement(Segment.getSelectFilter1());
				BrowserUtils.clickElement(Segment.getLastTransactionSelection());
				Thread.sleep(1000);
				
				//Use the below to code scroll the application for specific lenght
				//((JavascriptExecutor) driver).executeScript("document.querySelector(\".col-8.pr-0.modal-segment-form-content\").scrollTop=600");
				
			}else if (FilterName.equalsIgnoreCase("Enrollment Date")){
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Segment.getAddFilterButton());

				BrowserUtils.clickElement(Segment.getSelectFilter1());
				BrowserUtils.clickElement(Segment.getEnrollmentSelection());
				Thread.sleep(1000);
			}
		}catch (StaleElementReferenceException exception) {
			exception.printStackTrace();
		}
	}

	@And("select operator {string}")
	public void select_operator(String Operator) throws InterruptedException {
		
		//Use the below code to scroll the application untill the web element is find
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", Segment.getAddFilterButton());

		BrowserUtils.enterText(Segment.getOperator(), Operator);
		BrowserUtils.submit(Segment.getOperator());


	}

	@And("enter first value as {string} and second value as {string} for operator {string}")
	public void enter_first_value_as_and_second_value_as_for_operator(String firstvalue, String secondvalue, String operator)
			throws InterruptedException {

		if (operator.equalsIgnoreCase("Is greater than or equal to") || operator.equalsIgnoreCase("Is")
				|| operator.equalsIgnoreCase("Is within") || operator.equalsIgnoreCase("Is not within")
				|| operator.equalsIgnoreCase("Is less than or equal to") || operator.equalsIgnoreCase("Equals to")) {
			BrowserUtils.enterText(Segment.getInputValue1(), firstvalue);
			BrowserUtils.submit(Segment.getInputValue1());
			BrowserUtils.enterText(Segment.getInputValue2(), secondvalue);
			BrowserUtils.submit(Segment.getInputValue2());

		}
		else if (operator.equalsIgnoreCase("Is between")||operator.equalsIgnoreCase("Is not between")) {

			BrowserUtils.enterText(Segment.getInputValue1(), firstvalue);
			BrowserUtils.submit(Segment.getInputValue1());
			BrowserUtils.enterText(Segment.getInputValue2(), secondvalue);
			BrowserUtils.submit(Segment.getInputValue2());

			/*
			BrowserUtils.clickElement(Segment.getAddFilterButton());
			Thread.sleep(500);


			BrowserUtils.enterText(Segment.getInputValue3(), firstvalue);
			BrowserUtils.submit(Segment.getInputValue3());
			BrowserUtils.enterText(Segment.getInputValue4(), secondvalue);
			BrowserUtils.submit(Segment.getInputValue4());
			 */
		}		

	}

	@And("user add the multiple filters by click Add Filter button")
	public void user_add_the_multiple_filters_by_click_Add_Filter_button() throws InterruptedException {
		//BrowserUtils.clickElement(Segment.getAddFilterButton());
		//Thread.sleep(500);	

	}


	@And("clicks on {string} button")
	public void clicks_on_button(String Button) throws InterruptedException {
		
		if(Button.equalsIgnoreCase("Save")) {
		BrowserUtils.clickElement(Segment.getClickSaveButton());
		Thread.sleep(1000);
		
		}else if (Button.equalsIgnoreCase("Update")){
			BrowserUtils.clickElement(Segment.getClickUpdateButton());
			
		}
	}

	@Then("user should gets the success message as {string}")
	public void user_should_gets_the_success_message_as(String successMessage) throws InterruptedException {

		try {
			if (successMessage.equalsIgnoreCase("Segment has been successfully Added")) {
				Thread.sleep(1000);

				String createSegmentSuccessMessage = Segment.getCreateSegmentSuccessMessage().getText();
				System.out.println("The success message is: " + createSegmentSuccessMessage);
				Assert.assertEquals(createSegmentSuccessMessage, successMessage);

			}else if (successMessage.equalsIgnoreCase("Segment has been updated successfully")) {
				Thread.sleep(1000);
				String updateSegmentSuccessMessage = Segment.getUpdateSegmentSuccessMessage().getText();
				System.out.println("The success message is: " + updateSegmentSuccessMessage);
				Assert.assertEquals(updateSegmentSuccessMessage, successMessage);
				Thread.sleep(1000);

			}
			else if (successMessage.equalsIgnoreCase("Segment has been successfully deleted")) {
				Thread.sleep(1000);

				String deleteSegmentSuccessMessage = Segment.getDeleteSegmentSuccessMessage().getText();
				System.out.println("The success message is: " + deleteSegmentSuccessMessage);
				Assert.assertEquals(deleteSegmentSuccessMessage, successMessage);
			}

		}catch (StaleElementReferenceException exception) {
			exception.printStackTrace();

		}
	}

	@When("user validate the recently created segment {string} and click on {string}")
	public void user_validate_the_recently_created_segment_and_click_on(String SegmentName, String Actions) throws InterruptedException {


		//Use this code to perform scroll on application
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", "");

		try {

			List<WebElement> allRowsCount = BrowserUtils.findAndWaitForElements(Segment.getAllRowsCount());
			System.out.println("The counts of rows data are " + allRowsCount.size());


			// Checking all the row data
			List<WebElement> allRowsData = BrowserUtils.findAndWaitForElements(Segment.getAllRowsData());

			// Validating the created segment entry is available or not
			boolean dataStatus = false;

			for (WebElement ele : allRowsData) {
				String value = ele.getText();
				//System.out.println(value);
				Thread.sleep(1000);

				if (value.equalsIgnoreCase(SegmentName)) {
					dataStatus = true;
					System.out.println("Record found: " + dataStatus);
					Thread.sleep(500);

					WebElement Row = ele.findElement(By.xpath("parent::tr"));
					Thread.sleep(500);

					WebElement row = Row.findElement(By.xpath("td[4]"));
					Thread.sleep(500);

					WebElement ActionClick = row.findElement(By.tagName("Button"));
					Thread.sleep(500);

					ActionClick.click();

					if (Actions.equalsIgnoreCase("View")) {

						BrowserUtils.clickElement(Segment.getClickViewButton());
						Thread.sleep(500);

						String ActualHeaderTitle=Segment.getValidateHeader().getText();
						System.out.println("The header title is: "+ActualHeaderTitle);
						Assert.assertEquals(ActualHeaderTitle, SegmentName);
						
						BrowserUtils.clickElement(Segment.getbackButtonArrow());


					} else if (Actions.equalsIgnoreCase("Edit")) {

						BrowserUtils.clickElement(Segment.getClickEditButton());
						BrowserUtils.ClearAndEnterText(Segment.getSegmentName(), SegmentName);
						
						Thread.sleep(500);

					}  else if (Actions.equalsIgnoreCase("Duplicate")) {

						BrowserUtils.clickElement(Segment.getClickDuplicateButton());
						Thread.sleep(500);

					}
					else if(Actions.equalsIgnoreCase("Delete")){
						BrowserUtils.clickElement(Segment.getClickDeleteButton());
						BrowserUtils.clickElement(Segment.getConfirmDeleteButton());

					}
				}
			}
		} catch (StaleElementReferenceException exception) {
			exception.printStackTrace();	
		}
	}
	
	@And ("user enter the segment name as {string}")
	public void user_enter_the_segment_name_as(String segmentName) throws InterruptedException {
		
		BrowserUtils.ClearAndEnterText(Segment.getSegmentName(), segmentName);
		
	}
}


