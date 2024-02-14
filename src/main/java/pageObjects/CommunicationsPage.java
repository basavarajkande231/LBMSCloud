package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommunicationsPage {

	public WebDriver driver;
	public CommunicationsPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Communications locators

	@FindBy(xpath="//span[text()='Create Template']")
	WebElement ClickCreateTemplateButton;


	@FindBy(name="templateName")
	WebElement TemplateName;

	@FindBy(xpath="//div[text()='Promotional']")
	WebElement SelectPromotionalTemplateType;
	
	@FindBy(xpath="//div[text()='Transactional']")
	WebElement SelectTransactionalTemplateType;

	@FindBy(xpath="(//span[@class='sc-jEACwC jGdOmm btn-label'])[1]")
	WebElement ClickSetupEmail;
	
	@FindBy(name="subject")
	WebElement EmailSubject;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement filePath;
	
	@FindBy(xpath="(//span[text()='Save'])[2]")
	WebElement saveImage;
	
	@FindBy(name="title")
	WebElement EmailTitle;
	
	@FindBy(name="body")
	WebElement EmailBody;
	
	@FindBy(name="buttonText")
	WebElement ButtonText;
	
	@FindBy(name="actionUrl")
	WebElement ButtonTextUrl;
	
	@FindBy(xpath="//span[text()='Save']")
	WebElement ClickSaveButton;
	
	
	@FindBy(xpath="(//span[@class='sc-jEACwC jGdOmm btn-label'])[2]")
	WebElement ClickSetupSMS;
	
	
	@FindBy(name="templateId")
	WebElement SMSTemplateId;
	
	@FindBy(name="body")
	WebElement SMSTemplateBody;

	//Communications return methods

	public WebElement getClickCreateTemplateButton() {
		return ClickCreateTemplateButton;
	}

	public WebElement getTemplateName() {
		return TemplateName;
	}

	public WebElement getSelectPromotionalTemplateType() {
		return SelectPromotionalTemplateType;
	}
	
	public WebElement getSelectTransactionalTemplateType() {
		return SelectTransactionalTemplateType;
	}

	public WebElement getClickSetupEmail() {
		return ClickSetupEmail;
	}
	
	public WebElement getEmailSubject() {
		return EmailSubject;
	}
	
	public WebElement getFilePath() {
	return filePath;
	}
	
	public WebElement getClickSaveImage() {
		return saveImage;
	}
	
	public WebElement getEmailTitle() {
		return EmailTitle;
	}
	
	public WebElement getEmailBody() {
		return EmailBody;
	}
	
	public WebElement getButtonText() {
		return ButtonText;
	}
	
	public WebElement getButtonTextUrl() {
		return ButtonTextUrl;
	}
	
	public WebElement getClickSaveButton() {
		return ClickSaveButton;
	}
	
	public WebElement getClickSetupSMS() {
		return ClickSetupSMS;
	}
	
	public WebElement getSMSTemplateId() {
		return SMSTemplateId;
	}
	
	public WebElement getSMSTemplateBody() {
		return SMSTemplateBody;
	}
	

}
