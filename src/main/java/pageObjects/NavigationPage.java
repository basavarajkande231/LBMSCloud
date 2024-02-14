package pageObjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class NavigationPage {

	public WebDriver driver;

	public NavigationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	//@FindBy(xpath="(//h3[text()='admin'])[1]")
	@FindBy(xpath="//div[@class='profilestyles__StyledProfileBox-sc-1k9flwi-0 ivnDVX']")
	WebElement Profile;
	
	@FindAll(@FindBy(how = How.XPATH, using = "//div[@class='program-cont']//li"))
	List<WebElement> AllPrograms;
	
	@FindBy(tagName="div")
	WebElement program;
	
	@FindBy(xpath="//span[text()='Rule Engine']")
	WebElement RuleEngineModule;
	
	@FindBy(xpath="//span[text()='Tiers']")
	WebElement TierModule;
	
	@FindBy (xpath="//span[text()='Reports']")
	WebElement ClickReports;
	
	@FindBy(xpath="//div[text()='Engage']")
	WebElement ClickEngage;
	
	@FindBy (xpath="//span[text()='Segments']")
	WebElement ClickSegmentModule;
	
	@FindBy (xpath="//span[text()='Campaigns']")
	WebElement ClickCampaignModule;
	
	@FindBy (xpath="//span[text()='Communications']")
	WebElement ClickCommunicationsModule;

	@FindBy(xpath="//div[@id='Configurations']")
	WebElement Configurations;

	@FindBy(xpath="//span[text()='Organisation']")
	WebElement Organisation;
	
	public WebElement getProfile() {
		return Profile;
	}
	public List<WebElement> getAllPrograms() {
		return AllPrograms;
	}
		
	public WebElement getprogram() {
		return program;
	}
	
	public WebElement getRuleEngineModule() {
		return RuleEngineModule;
	}
		
	public WebElement getTierModule() {
		return TierModule;
	}
	
	public WebElement  getClickReports() {
		return  ClickReports;
	}
	
	public WebElement getClickEngage() {
		return ClickEngage;
	}
	
	public WebElement  getClickSegmentModule() {
		return  ClickSegmentModule;
	}
	
	public WebElement  getClickCampaignModule() {
		return  ClickCampaignModule;
	}
	
	public WebElement  getClickCommunicationsModule() {
		return  ClickCommunicationsModule;
	}
	
	
	public WebElement getConfigurations() {
		return Configurations;
	}
	public WebElement getOrganisation() {
		return Organisation;
	}
	
	  public void selectProgram(String program) throws InterruptedException {
	  WebElement selectProgram =
	  driver.findElement(By.xpath("//div[text()='"+program+"']"));
	 // Thread.sleep(2000); 
	  selectProgram.click(); 
	  }
	 
}

