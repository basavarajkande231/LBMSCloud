package stepDefinition;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;
import pageObjects.CommunicationsPage;
import pageObjects.NavigationPage;
import resources.BrowserUtils;
import resources.base;

public class CommunicationsStepDefinition extends base {

	NavigationPage Navigation1 = new NavigationPage(driver);
	CommunicationsPage Communications = new CommunicationsPage(driver);

	@Given("User navigates to communications module")
	public void User_navigates_to_communications_module() throws InterruptedException {
		BrowserUtils.clickElement(Navigation1.getClickEngage());
		BrowserUtils.clickElement(Navigation1.getClickCommunicationsModule());
	}

	@When("user clicks on the Create Template button")
	public void user_clicks_on_the_Create_Template_button() throws InterruptedException {

		BrowserUtils.clickElement(Communications.getClickCreateTemplateButton());

	}

	@And("user enters the template name as {string} and template type as {string}")
	public void	user_enters_the_template_name_as_and_template_type_as(String templateName, String templateType) throws InterruptedException {

		BrowserUtils.ClearAndEnterText(Communications.getTemplateName(), templateName);
		BrowserUtils.submit(Communications.getTemplateName());

		if(templateType.equalsIgnoreCase("Promotional")) {

			BrowserUtils.clickElement(Communications.getSelectPromotionalTemplateType());

		}else if (templateType.equalsIgnoreCase("Transactional")) {

			BrowserUtils.clickElement(Communications.getSelectTransactionalTemplateType());

		}

	}

	@And ("user setup the Email and user enter the email subject as {string} uplaod the title image and enter the email title as {string} email body as {string} button text as {string} and button link is {string}")
	public void user_enter_the_email_subject_as_uplaod_the_title_image_and_enter_the_email_title_as_email_body_as_button_text_as_and_button_link_is(String emailSubject, String emailTitle, String emailBody, String emailButtonText, String emailButtonTextLink) throws InterruptedException {

		//Setup Email
		BrowserUtils.clickElement(Communications.getClickSetupEmail());
		BrowserUtils.ClearAndEnterText(Communications.getEmailSubject(), emailSubject);
		BrowserUtils.submit(Communications.getEmailSubject());

		//Use the below code to uplaod the image from the local machine
		WebElement fileInput = Communications.getFilePath();
		String filePath = System.getProperty("user.dir") + "/test-output/suite/EmailTitleImage.png";
		BrowserUtils.uploadFile(fileInput, filePath);
		BrowserUtils.clickElement(Communications.getClickSaveImage());
		Thread.sleep(1000);
		BrowserUtils.ClearAndEnterText(Communications.getEmailTitle(), emailTitle);
		BrowserUtils.submit(Communications.getEmailTitle());

		BrowserUtils.ClearAndEnterText(Communications.getEmailBody(), emailBody);
		BrowserUtils.submit(Communications.getEmailBody());

		BrowserUtils.ClearAndEnterText(Communications.getButtonText(), emailButtonText);
		BrowserUtils.submit(Communications.getButtonText());

		BrowserUtils.ClearAndEnterText(Communications.getButtonTextUrl(), emailButtonTextLink);
		BrowserUtils.submit(Communications.getButtonTextUrl());

		BrowserUtils.clickElement(Communications.getClickSaveButton());
		Thread.sleep(1000);

	}

	@And("user setup the SMS and user enter the SMS Template ID as {string} and SMS body as {string}")
	public void	user_setup_the_SMS_and_user_enter_the_SMS_Template_ID_as_and_SMS_body_as(String SMSTemplateID, String SMSTemplateBody) throws InterruptedException {

		//Setup SMS 
		BrowserUtils.clickElement(Communications.getClickSetupSMS());

		BrowserUtils.ClearAndEnterText(Communications.getSMSTemplateId(), SMSTemplateID);
		BrowserUtils.submit(Communications.getSMSTemplateId());

		BrowserUtils.ClearAndEnterText(Communications.getSMSTemplateBody(), SMSTemplateBody);
		BrowserUtils.submit(Communications.getSMSTemplateBody());

		BrowserUtils.clickElement(Communications.getClickSaveButton());

	}

	@And ("user setup the {string} channel and disable the {string} channel")
	public void user_setup_the_channel_and_disable_the_channel(String channel, String disableChannel) {

		if(channel.equalsIgnoreCase("Email")) {
			

		}else if(channel.equalsIgnoreCase("Email")) {

		}

	}

	@And("click on {string} button")
	public void click_on_button(String Button) throws InterruptedException {

		BrowserUtils.clickElement(Communications.getClickCreateTemplateButton());
	}


}
