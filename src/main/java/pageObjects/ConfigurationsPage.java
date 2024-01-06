package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import resources.BrowserUtils;

public class ConfigurationsPage extends BrowserUtils{

	public WebDriver driver;
	
	public ConfigurationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy(xpath="//span[contains(text(),' Add New Program')]")
	@FindBy(xpath="//div/div/div/button/span[contains(text(),' Add New Program')]")
	WebElement NewProgram;
	
	@FindBy(xpath="//div[@id='Configurations']")
	WebElement Configurations;
	
	@FindBy(xpath="//span[text()='Organisation']")
	WebElement Organisation;
	
	@FindBy(xpath="//span[text()='Edit']")
	WebElement Edit;
	
	@FindBy(xpath="(//span[text()='Edit'])[2]")
	WebElement Edit2;
	
	@FindBy(xpath="//input[@placeholder='Enter First Name']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@placeholder='Enter Last Name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='Enter Email Address']")
	WebElement email;
	
	@FindBy(xpath="//input[@placeholder='Enter Phone Number']")
	WebElement phone;
	
	@FindBy(xpath="//span[text()='Continue']")
	WebElement Continue;
	
	@FindBy(xpath="//input[@placeholder='Enter Registered Business Name']")
	WebElement Business;
	
	@FindBy(xpath="//input[@placeholder='Enter Company Website URL']")
	WebElement Company;
	
	@FindBy(xpath="//input[@placeholder='Enter City']")
	WebElement City;
	
	@FindBy(xpath="//input[@placeholder='Enter Region']")
	WebElement Region;
	
	@FindBy(xpath="//input[@placeholder='Enter Program Name']")
	WebElement program;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement addImage;
    
	@FindBy(xpath="//span[text()='Save']")
	WebElement saveImage;
 
	@FindBy(xpath="//input[@placeholder='Enter Terminology for Singular']")
	WebElement Singular;
	
	@FindBy(xpath="//input[@placeholder='Enter Terminology for Plural']")
	WebElement Plural;
	
	@FindBy(xpath="//input[@placeholder='Enter Point Expiration Schedule']")
	WebElement Expiration;
	
	@FindBy(xpath="//div/div/span[@class='sc-aXZVg gkvfUp eui-dd-indicator']")
	WebElement clickDropdown;
	
	@FindBy(xpath="//input[@placeholder='Enter Cashback Rate']")
	WebElement cashback;
	
	@FindBy(xpath="//input[@placeholder='Enter Customer Purchase Rate']")
	WebElement purchaseRate;
	
	@FindBy(xpath="//input[@placeholder='Enter Redemption Rate']")
	WebElement redemptionRate;
	
	@FindBy(xpath="//span[text()='Create Program']")
	WebElement createProgram;
	
	@FindBy(xpath="//span[text()='Cancel']")
	WebElement cancel;
	
	@FindBy(xpath="//span[text()='Done']")
	WebElement done;
	
	@FindBy(xpath="//span[text()='Program']")
	WebElement SectionProgram;
	
	@FindBy(xpath="//span[text()='Program Details']")
	WebElement programDetails;
	
	@FindBy(xpath="//span[text()='Point Definition']")
	WebElement pointDefinition;
	
	@FindBy(xpath="//span[text()='Marketplace']")
	WebElement marketplace;
	
	@FindBy(xpath="//span[text()='Communication']")
	WebElement communication;

	@FindBy(xpath="//div[@class='eui-dd-input']//input[@type='text']")
	WebElement countryCode;
	
	@FindBy(xpath="(//div[@class='pt-3']/div)[2]")
	WebElement recentProgram;
	
	@FindBy(xpath="//div[@class='eui-dd-input']//input[@type='text']")
	WebElement ExpirationPeriod;
	
	@FindBy(xpath="//input[@placeholder='Enter Sender Name']")
	WebElement senderName;
	
	@FindBy(xpath="//input[@placeholder='Enter Email Address']")
	WebElement senderEmail;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement filePath;
	
	
	public WebElement getNewProgram() {
		return NewProgram;
	}
	public WebElement ClickONConfigurations() {
		return Configurations;
	}
	public WebElement ClickONOrganisation() {
			return Organisation;
	}
	public WebElement ClickONEdit() {
		return Edit;
	}
	public WebElement ClickONEdit2() {
		return Edit2;
	}
	public WebElement getFirstName() {
		return firstName;
    }
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPhone() {
		return phone;
	}
	public WebElement getContinue() {
		return Continue;
	}
	public WebElement getBusiness() {
		return Business;
	}
	public WebElement getCompany() {
		return Company;
	}
	public WebElement getCity() {
		return City;
	}
	public WebElement getRegion() {
		return Region;
	}
	public WebElement getProgram() {
		return program;
	}
	public WebElement getLogoImage() {
     return addImage;
	}
	public WebElement getSingular() {
		return Singular;
	}
	public WebElement getPlural() {
		return Plural;
	}
	public WebElement getExpiration() {
		return Expiration;
	}
	public WebElement getCashback() {
		return cashback;
	}
	public WebElement getPurchaseRate() {
		return purchaseRate;
	}
	public WebElement getRedemptionRate() {
		return redemptionRate;
	}
	public WebElement createProgram() {
		return createProgram;
	}
	public WebElement getDone() {
		return done;
	}
	public WebElement cancelEdit() {
		return cancel;
	}
	public WebElement getSectionProgram() {
		return SectionProgram;
	}
	public WebElement getProgramDetails() {
		return programDetails;
    }
	public WebElement getPointDefinition() {
		return pointDefinition;
	}
	public WebElement getMarketplace() {
		return marketplace;
	}
	public WebElement getCommunication() {
		return communication;
	}
	public WebElement getCountryCode() {
		return countryCode;
	}
	public WebElement getExpirationPeriod() {
		return ExpirationPeriod;
	}
	public WebElement recentProgram() {
		return recentProgram;
	}
	public WebElement  getSenderName() {
		return senderName;
	}
	public WebElement getSenderEmail() {
		return senderEmail;
	}
	public WebElement getSaveImage() {
		return saveImage;
	}
	public WebElement getFilePath() {
	return filePath;
	}
}

	
