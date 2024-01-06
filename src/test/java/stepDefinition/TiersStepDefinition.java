package stepDefinition;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.*;
import pageObjects.NavigationPage;
import pageObjects.TiersPage;
import resources.BrowserUtils;
import resources.base;

public class TiersStepDefinition extends base {

	NavigationPage Navigation1 = new NavigationPage(driver);

	TiersPage Tiers = new TiersPage(driver);

	@Given("User navigates to tier module")
	public void user_navigates_to_tier_module() throws InterruptedException {
Thread.sleep(1000);
		BrowserUtils.clickElement(Navigation1.getTierModule());

	}

	@When("user clicks on the Enable Tiers or Add a New Tier button")
	public void user_clicks_on_the_Enable_Tiers_or_Add_a_New_Tiers_button() throws InterruptedException {

		Thread.sleep(1000);
		boolean getEnableTiersStatus;
		try {
			getEnableTiersStatus = Tiers.getEnableTiers().isDisplayed();
		} catch (Exception e) {
			
			getEnableTiersStatus = false;
		}
		System.out.println("value of getEnableTiersstatus is " + getEnableTiersStatus);
		if (getEnableTiersStatus) {

			BrowserUtils.clickElement(Tiers.getEnableTiers());
			Thread.sleep(1000);

			String LifeTimeTierStatus = Tiers.getLifetimeStatus().getAttribute("aria-checked");

			System.out.println("status of LifeTimeTierStatus is " + LifeTimeTierStatus);

			if (LifeTimeTierStatus.equalsIgnoreCase("true")) {
				BrowserUtils.clickElement(Tiers.getRollingYearSelection());
				BrowserUtils.clickElement(Tiers.getClickContinueButton());
			} else {
				BrowserUtils.clickElement(Tiers.getLifetimeSelection());
				BrowserUtils.clickElement(Tiers.getClickContinueButton());
			}
		} else {
			Thread.sleep(3000);
			System.out.println("inside tier false condition");

			BrowserUtils.clickElement(Tiers.getAddNewTier());
		}

	}

	@And("User navigates to create new tier page and select the {string} tier icon")
	public void user_navigates_to_create_new_tier_page_and_select_the_tier_icon(String Icon)
			throws InterruptedException {

		// Upload the tier icons
		BrowserUtils.clickElement(Tiers.getUploadTierIcon());

		if (Icon.equalsIgnoreCase("Bronze")) {
			BrowserUtils.clickElement(Tiers.getBronzeTierIcon());
		}

		else if (Icon.equalsIgnoreCase("Silver")) {
			BrowserUtils.clickElement(Tiers.getSilverTierIcon());
		}

		else if (Icon.equalsIgnoreCase("Gold")) {
			BrowserUtils.clickElement(Tiers.getGoldTierIcon());

		} else {
			BrowserUtils.clickElement(Tiers.getPlatinumTierIcon());

		}
		BrowserUtils.clickElement(Tiers.getDone());

	}

	@And("enter tier name as {string} multiplier as {string} milestone as {string}  bonus as {string} and click {string}")
	public void user_navigates_to_tier_module(String tierName, String multiplierValue, String milestoneValue,
			String bonusValue, String saveButton) throws InterruptedException {

		if (Tiers.getMultiplier().isEnabled()) {
			BrowserUtils.ClearAndEnterText(Tiers.getTierName(), tierName);

			BrowserUtils.ClearAndEnterText(Tiers.getMultiplier(), multiplierValue);

			BrowserUtils.ClearAndEnterText(Tiers.getMilestone(), milestoneValue);

			BrowserUtils.ClearAndEnterText(Tiers.getBonus(), bonusValue);
		} else {
			BrowserUtils.ClearAndEnterText(Tiers.getTierName(), tierName);
		}

		if (saveButton.equalsIgnoreCase("Launch")) {
			BrowserUtils.clickElement(Tiers.getLaunch());
			BrowserUtils.clickElement(Tiers.getSaveandEnableNow());
		} else {
			BrowserUtils.clickElement(Tiers.getUpdateButton());
			BrowserUtils.clickElement(Tiers.getClickConfirmUpdate());
		}

	}

	@Then("user validates {string} tier and clicks {string}")
	public void user_validates_created_tier_clicks_edit(String Tiername, String Action) throws InterruptedException {
		Thread.sleep(3000);

		try {
			List<WebElement> allRowsCount = BrowserUtils.findAndWaitForElements(Tiers.getAllRowsCount());
			System.out.println("The counts of rows data are " + allRowsCount.size());

			// Checking all the row data
			List<WebElement> allRowsData = BrowserUtils.findAndWaitForElements(Tiers.getAllRowsData());

			// Validating the created tier entry is available or not
			boolean dataStatus = false;

			for (WebElement ele : allRowsData) {
				String value = ele.getText();
				System.out.println(value);

				if (value.equalsIgnoreCase(Tiername)) {
					dataStatus = true;
					System.out.println("Record found: " + dataStatus);
					Thread.sleep(1000);

					WebElement platinumRow = ele.findElement(By.xpath("parent::tr"));
					Thread.sleep(1000);

					WebElement row = platinumRow.findElement(By.xpath("td[6]"));
					Thread.sleep(1000);

					WebElement ActionClick = row.findElement(By.tagName("Button"));
					Thread.sleep(1000);

					ActionClick.click();

					if (Action.equalsIgnoreCase("Edit")) {

						BrowserUtils.clickElement(Tiers.getClickEditButton());

					} else if (Action.equalsIgnoreCase("Delete")) {

						if (Tiers.getDeleteCreatedTier().isEnabled()) {
							BrowserUtils.clickElement(Tiers.getDeleteCreatedTier());
							BrowserUtils.clickElement(Tiers.getConfirmDelete());
						} else {
							System.out.println("Delete button is not enabled as it is default tier");
						}
					}
				}

			}
			Assert.assertTrue("Record not found: ", dataStatus);
		} catch (StaleElementReferenceException exc) {
			exc.printStackTrace();
		}
	}

	@Then("user should navigate to tier lists page along with success message {string} {string}")
	public void user_should_navigate_to_tier_lists_page_along_with_success_message(String tierName,
			String SuccessMessage) {

	if(SuccessMessage.equalsIgnoreCase(tierName)) {
		
		String ActualSuccessmessage=Tiers.getCreateTierSuccessMessage().getText();
		Assert.assertEquals(ActualSuccessmessage, tierName);
		
	}else if(SuccessMessage.equalsIgnoreCase(tierName)) {
		
		String ActualSuccessmessage=Tiers.getUpdateTierSuccessMessage().getText();
		Assert.assertEquals(ActualSuccessmessage, tierName);
		
	}else if(SuccessMessage.equalsIgnoreCase(tierName)) {
		
		String ActualSuccessmessage=Tiers.getTierSettingsSuccessMessage().getText();
		Assert.assertEquals(ActualSuccessmessage, tierName);
		
	}else if(SuccessMessage.equalsIgnoreCase(tierName)) {
		
		String ActualSuccessmessage=Tiers.getdeleteTierSuccessMessage(tierName);
		Assert.assertEquals(ActualSuccessmessage, tierName);
		
	}
		
	}

	@Given("user change the tier settings timeframe")
	public void user_change_the_tier_settings_timeframe() throws InterruptedException {

		Thread.sleep(1000);

		BrowserUtils.clickElement(Tiers.gettierSettings());


		String LifeTimeTierStatus = Tiers.getLifetimeStatus().getAttribute("aria-checked");

		System.out.println("status of LifeTimeTierStatus is " + LifeTimeTierStatus);

		if (LifeTimeTierStatus.equalsIgnoreCase("true")) {
			BrowserUtils.clickElement(Tiers.getRollingYearSelection());

		} else if (LifeTimeTierStatus.equalsIgnoreCase("false")) {
			BrowserUtils.clickElement(Tiers.getLifetimeSelection());

		}
		BrowserUtils.clickElement(Tiers.getClickTierSettingUpdateButton());
		BrowserUtils.clickElement(Tiers.getClickTierSettingConfirmButton());
	}

	@Then("user gets the success message as {string}")
	public void user_gets_the_success_message_as(String SuccessMessage) {

		if (SuccessMessage.equalsIgnoreCase("Tier Setting Updated Successfully")) {
			String tieSettingSuccess = driver.findElement(By.xpath("//div[text()='Tier Setting Updated Successfully']")).getText();
			System.out.println("The tiers settings success message is: " + tieSettingSuccess);
			Assert.assertEquals("Tier Setting Updated Successfully", tieSettingSuccess);
		}
	}

}
