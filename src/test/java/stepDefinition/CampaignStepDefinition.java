package stepDefinition;

import pageObjects.CampaignPage;
import pageObjects.NavigationPage;
import resources.BrowserUtils;
import resources.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.*;

public class CampaignStepDefinition extends base {

	NavigationPage Navigation1 = new NavigationPage(driver);
	CampaignPage Campaign = new CampaignPage(driver);

	@Given("User navigates to campaign module")
	public void user_navigates_to_campaign_module() throws InterruptedException {
		BrowserUtils.clickElement(Navigation1.getClickEngage());
		BrowserUtils.clickElement(Navigation1.getClickCampaignModule());
	}

	@When("user clicks on the Create campaign button")
	public void user_clicks_on_the_create_campaign_button() throws InterruptedException {

		BrowserUtils.clickElement(Campaign.getClickCreateCampaign());
	}

	@When("user enter the campaign name as {string} target audience as {string} and bonus points as {string}")
	public void user_enter_the_campaign_name_as_target_audience_as_and_bonus_points_as(String campaignName, String targetAudience, String bonusPoint) throws InterruptedException {

		BrowserUtils.ClearAndEnterText(Campaign.getCampaignName(), campaignName);
		Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Campaign.getTargetAudience(), targetAudience);
		BrowserUtils.submit(Campaign.getTargetAudience());

		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", Campaign.getBonusPointsToIssueLabel());

		BrowserUtils.ClearAndEnterText(Campaign.getCampaignBonus(), bonusPoint);
		BrowserUtils.submit(Campaign.getCampaignBonus());
	}

	@When("user select the {string}")
	public void user_select_the(String existingMembers) {

		Campaign.getPointsCreditingCriteriaExistingMembers().isSelected();
		String SelectedCheckbox=Campaign.getPointsCreditingCriteriaExistingMembers().getText();
		System.out.println("The success message is: " + SelectedCheckbox);

		Assert.assertEquals(SelectedCheckbox, existingMembers);
	}

	//Use the below code if user wants to slect the points issue to both existing and new members
	@And("user select the {string} and {string}")
	public void user_select_the_and(String existingMembers, String newMembers) throws InterruptedException {

		try {
			Campaign.getPointsCreditingCriteriaNewMembers().click();
		} catch (Exception e) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Campaign.getPointsCreditingCriteriaNewMembers());
		}

	}

	@And("Schedule Campaign start date as {string} and click on the Continue button")
	public void Schedule_Campaign_start_date_as_and_click_on_the_Continue_button(String campaignStartDate) throws InterruptedException {

		//Use the below code to scroll the application untill the web element is find
		//((JavascriptExecutor) driver).executeScript("window.scrollBy(0,750)", "");
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", Campaign.getCampaignStartDateLabel());

		BrowserUtils.enterText(Campaign.getCampaignStartDate(), campaignStartDate);
		BrowserUtils.submit(Campaign.getCampaignStartDate());

		BrowserUtils.clickElement(Campaign.getClickContinueButton());
	}

	//use the below to to sleect both from date and to date if user select issue points to new members
	@And("Schedule Campaign start date as {string} and end date as {string} and click on the Continue button")
	public void Schedule_Campaign_start_date_as_and_end_date_as_and_click_on_the_Continue_button(String campaignStartDate, String campaignEndDate) throws InterruptedException {

		Thread.sleep(3000);
		//Use the below code to scroll till bottom of the page
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

		BrowserUtils.enterText(Campaign.getCampaignStartDate(), campaignStartDate);
		BrowserUtils.submit(Campaign.getCampaignStartDate());

		BrowserUtils.enterText(Campaign.getCampaignEndDate(), campaignEndDate);
		BrowserUtils.submit(Campaign.getCampaignEndDate());

		BrowserUtils.clickElement(Campaign.getClickContinueButton());
	}


	@And("user select the template as {string} and click on the Continue button")
	public void user_select_the_template_as_and_click_on_the_Continue_button(String selectTemplate) throws InterruptedException {
		Thread.sleep(3000);
		BrowserUtils.enterText(Campaign.getSelectCommunicationTemplate(), selectTemplate);
		BrowserUtils.submit(Campaign.getSelectCommunicationTemplate());
		Thread.sleep(3000);

		//Preview the SMS communication template
		BrowserUtils.clickElement(Campaign.getPreviewFirstCommunicationTemplate());
		Thread.sleep(3000);
		BrowserUtils.clickElement(Campaign.getClosePreviewCommunicationTemplate());
		Thread.sleep(2000);

		//Preview the SMS communication template
		BrowserUtils.clickElement(Campaign.getPreviewSecondCommunicationTemplate());
		Thread.sleep(3000);
		BrowserUtils.clickElement(Campaign.getClosePreviewCommunicationTemplate());

		BrowserUtils.clickElement(Campaign.getClickContinueButton());
	}

	@And("user navigate to summary page and click on the {string} button")
	public void user_navigate_to_summary_page_and_click_on_the_button(String createCampaignButton) throws InterruptedException {

		String expectedSummary="Summary";
		String CampaignSummary=Campaign.getValidateSummary().getText();
		System.out.println("The success message is: " + CampaignSummary);

		Assert.assertEquals(CampaignSummary, expectedSummary);

		if(createCampaignButton.equalsIgnoreCase("Create Campaign")){
			BrowserUtils.clickElement(Campaign.getClickCreateCampaignButton());
			//BrowserUtils.clickElement(Campaign.getClickSaveEnableNowButton());
			BrowserUtils.clickElement(Campaign.getClickSaveEnableLaterButton());

		}else if (createCampaignButton.equalsIgnoreCase("Update Campaign")) {
			BrowserUtils.clickElement(Campaign.getClickUpdateCampaignButton());
			BrowserUtils.clickElement(Campaign.getClickSaveEnableNowButton());
		}
	}

	@Then("user should gets the success toast message as {string}")
	public void user_should_gets_the_success_toast_message_as(String campaignSuccessmessage) throws InterruptedException {

		Thread.sleep(3000);
		if(campaignSuccessmessage.equalsIgnoreCase("Campaign has been successfully Added")) {
			Thread.sleep(3000);
			String actualSuccessMessage=Campaign.getCreateCampaignSuccessMessage().getText();
			System.out.println("The success message is: " + actualSuccessMessage);

			Assert.assertEquals(actualSuccessMessage, campaignSuccessmessage);

		}else if(campaignSuccessmessage.equalsIgnoreCase("Updated Campaign successfully")) {
			Thread.sleep(3000);
			String actualSuccessMessage=Campaign.getUpdateCampaignSuccessMessage().getText();
			System.out.println("The success message is: " + actualSuccessMessage);

			Assert.assertEquals(actualSuccessMessage, campaignSuccessmessage);

		}else if(campaignSuccessmessage.equalsIgnoreCase("Campaign disabled")) {
			Thread.sleep(3000);
			String actualSuccessMessage=Campaign.getDisabledCampaignSuccessMessage().getText();
			System.out.println("The success message is: " + actualSuccessMessage);

			Assert.assertEquals(actualSuccessMessage, campaignSuccessmessage);

		}else if(campaignSuccessmessage.equalsIgnoreCase("Campaign enabled successfully")) {
			Thread.sleep(3000);
			String actualSuccessMessage=Campaign.getEnabledCampaignSuccessMessage().getText();
			System.out.println("The success message is: " + actualSuccessMessage);

			Assert.assertEquals(actualSuccessMessage, campaignSuccessmessage);
		}
	}

	@When("user validate the recently created campaign {string} and click on {string}")
	public void user_validate_the_recently_created_campaign_and_click_on(String CampaignName, String Actions) throws InterruptedException {

		try {

			List<WebElement> allRowsCount = BrowserUtils.findAndWaitForElements(Campaign.getAllRowsCount());
			System.out.println("The counts of rows data are " + allRowsCount.size());

			// Checking all the row data
			List<WebElement> allRowsData = BrowserUtils.findAndWaitForElements(Campaign.getAllRowsData());

			// Validating the created campaign name is available or not
			boolean dataStatus = false;

			for (WebElement ele : allRowsData) {
				String value = ele.getText();
				Thread.sleep(1000);

				if (value.equalsIgnoreCase(CampaignName)) {
					dataStatus = true;
					System.out.println("Record found: " + dataStatus);
					Thread.sleep(500);

					WebElement Row = ele.findElement(By.xpath("parent::tr"));
					Thread.sleep(500);

					WebElement row = Row.findElement(By.xpath("td[6]"));
					Thread.sleep(500);

					WebElement ActionClick = row.findElement(By.tagName("Button"));
					Thread.sleep(500);

					ActionClick.click();

					if (Actions.equalsIgnoreCase("View")) {

						BrowserUtils.clickElement(Campaign.getClickViewButton());
						Thread.sleep(500);

						System.out.println(Campaign.getValidateCampaignRemainingDays().getText());
						System.out.println(Campaign.getValidateCampaignStartDate().getText());
						System.out.println(Campaign.getValidateCampaignEndDate().getText());
						System.out.println(Campaign.getValidateCampaignCreatedDate().getText());
						System.out.println("Points Issued Per Member: "+Campaign.getValidatePointsIssuedPerMember().getText());
						System.out.println("Member Size: "+Campaign.getValidateMemberSize().getText());
						System.out.println("Total Points Issued: "+Campaign.getValidateTotalPointsIssued().getText());

						// Checking all the row data
						List<WebElement> creditedMembersList = BrowserUtils.findAndWaitForElements(Campaign.getValidateCreditedMembersListData());
						System.out.println("member list count is: "+creditedMembersList.size());
						System.out.println(creditedMembersList);
						Thread.sleep(1000);						

						BrowserUtils.clickElement(Campaign.getbackButtonArrow());

					} else if (Actions.equalsIgnoreCase("Edit")) {
						BrowserUtils.clickElement(Campaign.getClickEditButton());
						Thread.sleep(500);

					}  else if (Actions.equalsIgnoreCase("Duplicate")) {
						BrowserUtils.clickElement(Campaign.getClickDuplicateButton());
						Thread.sleep(500);
					}
				}
			}
		} catch (StaleElementReferenceException exception) {
			exception.printStackTrace();	
		}
	}

	@And("user enter the campaign name as {string} and bonus points as {string} and click on the Continue button")
	public void user_enter_the_campaign_name_as_and_bonus_points_as_and_click_on_the_button(String campaignName, String bonusPoints) throws InterruptedException {

		BrowserUtils.ClearAndEnterText(Campaign.getCampaignName(), campaignName);
		BrowserUtils.submit(Campaign.getCampaignName());
		Thread.sleep(1000);
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", Campaign.getBonusPointsToIssueLabel());

		BrowserUtils.ClearAndEnterText(Campaign.getCampaignBonus(), bonusPoints);
		BrowserUtils.submit(Campaign.getCampaignBonus());

		BrowserUtils.clickElement(Campaign.getClickContinueButton());
	}

	@And("user validate the recently created campaign {string} and change the campaign status")
	public void user_validate_the_recently_created_campaign_and_change_the_campaign_status(String campaignName) throws InterruptedException {

		List<WebElement> allRowsData = BrowserUtils.findAndWaitForElements(Campaign.getAllRowsData());

		// Validating the created campaign name is available or not
		boolean dataStatus = false;

		for (WebElement ele : allRowsData) {
			String value = ele.getText();
			Thread.sleep(1000);

			if (value.equalsIgnoreCase(campaignName)) {
				dataStatus = true;
				System.out.println("Record found: " + dataStatus);
				Thread.sleep(500);

				String currentStatus = Campaign.getCampaignCurrentStatus().getAttribute("aria-checked");
				System.out.println(currentStatus);

				if (currentStatus.equalsIgnoreCase("true")) {
					Thread.sleep(1000);
					BrowserUtils.clickElement(Campaign.getCampaignDisabled());

				} else if (currentStatus.equalsIgnoreCase("false")) {
					BrowserUtils.clickElement(Campaign.getCampaignEnabled());

				}
			}
		}

	}
}
