package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TiersPage {


	public WebDriver driver;
	public TiersPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Create new tier WebElements

	@FindBy (xpath="//span[text()='Enable Tiers']")
	WebElement EnableTiers;
	
    
    @FindBy(xpath="//div[text()='Lifetime']/parent::div/preceding-sibling::div/preceding-sibling::input[@value='0']")
    WebElement LifetimeStatus;
    

	@FindBy (xpath="//span[text()='Continue']")
	WebElement ClickContinueButton;
	
	@FindBy (xpath="//span[text()='Cancel']")
	WebElement ClickCancelButton;
	
	@FindBy (xpath= "//span[text()='Add a New Tier']")
	WebElement AddNewTier;

	@FindBy(xpath="//span[@class='sc-eDPEul ehXbdI eui-upload-button']")
	WebElement UploadTierIcon;

	@FindBy(xpath="//img[@src='https://lbms-qa-bucket-public.s3.us-west-2.amazonaws.com/awardImage/bronze_award.png']")
	WebElement BronzeIcon;

	@FindBy(xpath="//img[@src='https://lbms-qa-bucket-public.s3.us-west-2.amazonaws.com/awardImage/silver_award.png']")
	WebElement SilverIcon;

	@FindBy(xpath="//img[@src='https://lbms-qa-bucket-public.s3.us-west-2.amazonaws.com/awardImage/gold_award.png']")
	WebElement GoldIcon;

	@FindBy(xpath="//img[@src='https://lbms-qa-bucket-public.s3.us-west-2.amazonaws.com/awardImage/platinum_award.png']")
	WebElement PlatinumIcon;

	//@FindBy (xpath= "/html/body/reach-portal[2]/div[2]/div/div/div/div/div/div/div/div/div[2]/div/div[2]/button/span")
	@FindBy (xpath="//span[text()='Done']")
	WebElement Done;

	@FindBy(xpath="//input[@name='TierName']")
	WebElement Tiername;

	@FindBy(xpath="//input[@name='Multiplier']")
	WebElement Multiplier;

	@FindBy(xpath="//input[@name='MilestoneAchieve']")
	WebElement Milestone;

	@FindBy(xpath="//input[@name='BonusPoint']")
	WebElement Bonus;

	@FindBy (xpath= "//span[text()='Launch']")
	WebElement Launch;

	@FindBy (xpath="//span[text()='Update']")
	WebElement Update;

	@FindBy (xpath= "//button[@class='sc-cwHptR fCNsGD mr-2']")
	WebElement CancelTierCreateBefore;

	@FindBy (xpath= "//button[@class='sc-eDPEul kAyLyY eui-modal-close']")
	WebElement CloseIconBefore;


	@FindBy (xpath= "//span[text()='Save & Enable Now']")
	WebElement ConfirmTierCreate;

	@FindBy (xpath= "//button[@class='sc-cwHptR fCNsGD mr-1']")
	WebElement CancelTierCreate;

	@FindBy (xpath= "//span[text()='Save & Enable Now']")
	WebElement CloseTierCreate;

	//@FindBy(xpath="//div[@class='notification-container notification-container-empty']")
	@FindBy(xpath="h4[@class='title']")
	WebElement Successmessage;

	//Tier lists all row data details
	@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td"))
	List<WebElement> AllRowsCount;

	@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td"))
	List<WebElement> AllRowsData;

	@FindBy(xpath="parent::tr")
	WebElement platinumRow;

	@FindBy(xpath="td[6]")
	WebElement row;

	@FindBy(tagName="Button")
	WebElement ActionsClick;

	@FindBy(xpath="//span[text()='Edit']")
	WebElement ClickEditButton;

	//Success message validate WebElements
	
	@FindBy(xpath="//h4[text()='Tiers has been successfully enabled']")
	WebElement CreateTierSuccessMessage;
	
	@FindBy(xpath="//h4[text()='Tier Updated Successfully']")
	WebElement UpdateTierSuccessMessage;
	
	@FindBy(xpath="//h4[text()='Tiers has been successfully enabled']")
	WebElement DeleteTierSuccessMessage;
	
	@FindBy(xpath="//h4[text()='Tier Setting Updated Successfully']")
	WebElement TierSettingsSuccessMessage;
	
	

	//Tiers settings WebElements
	@FindBy(xpath="//button[@class='sc-cwHptR jXcUxV']")
	WebElement tierSettings;

	@FindBy(xpath="//div[@direction='column']")
	WebElement TiersSettingsLists;

	@FindBy(xpath="//div[text()='Rolling Year']")
	WebElement RollingYearSelection;
	

	@FindBy(xpath="//div[text()='Lifetime']")
	WebElement LifetimeSelection;
	
	@FindBy(xpath="//span[text()='Update']")
	WebElement ClickTierSettingUpdateButton;

	@FindBy(xpath="//span[text()='I understand & Proceed']")
	WebElement ClickTierSettingConfirmButton;



	//Edit tier WebElements

	@FindBy(xpath="//span[text()='I understand & Update']")
	WebElement ClickConfirmUpdate;

	//Delete tier element
	@FindBy(xpath="//span[text()='Delete']")
	WebElement DeleteTierButton;

	@FindBy(xpath="//button[@class='sc-cwHptR eDUZvy']")
	WebElement ConfirmDelete;



	//Create new tier return methods

	public WebElement  getEnableTiers() {
		return  EnableTiers;
	}
	
	public WebElement  getLifetimeStatus() {
		return  LifetimeStatus;
	}
	
	
	
	public WebElement  getClickContinueButton() {
		return  ClickContinueButton;
	}
	
	public WebElement  getClickCancelButton() {
		return  ClickCancelButton;
	}

	
	public WebElement getAddNewTier() {
		return AddNewTier;
	}

	public WebElement getUploadTierIcon() {
		return UploadTierIcon;
	}


	public WebElement getBronzeTierIcon() {
		return BronzeIcon;
	}


	public WebElement getSilverTierIcon() {
		return SilverIcon;
	}


	public WebElement getGoldTierIcon() {
		return GoldIcon;
	}


	public WebElement getPlatinumTierIcon() {
		return PlatinumIcon;
	}


	public WebElement getDone() {
		return Done;
	}


	public WebElement getTierName() {
		return Tiername;
	}


	public WebElement getMultiplier() {
		return Multiplier;
	}


	public WebElement getMilestone() {
		return Milestone;
	}


	public WebElement getBonus() {
		return Bonus;
	}


	public WebElement getLaunch() {
		return Launch;
	}


	public WebElement getSaveandEnableNow() {
		return ConfirmTierCreate;
	}


	public WebElement getSuccessmessage() {
		return Successmessage;
	}


	public List<WebElement> getAllRowsCount() {
		return AllRowsCount;
	}


	public List<WebElement> getAllRowsData() {
		return AllRowsData;
	}


	public WebElement getplatinumRow() {
		return platinumRow;	
	}


	public WebElement getrow() {
		return row;
	}


	public WebElement getActionsClick() {
		return ActionsClick;
	}

	public WebElement getClickEditButton() {
		return ClickEditButton;
	}

	//Tiers Settings return methods
	public WebElement gettierSettings() {
		return tierSettings;
	}

	public WebElement getTierSettingsLists() {
		return TiersSettingsLists;
	}

	public WebElement getRollingYearSelection() {
		return RollingYearSelection;
	}

	public WebElement getClickTierSettingUpdateButton() {
		return ClickTierSettingUpdateButton;
	}

	public WebElement getClickTierSettingConfirmButton() {
		return ClickTierSettingConfirmButton;
	}

	public WebElement getLifetimeSelection() {
		return LifetimeSelection;
	}

	//Edit tier return methods
	public WebElement getUpdateButton() {
		return Update;
	}


	public WebElement getClickConfirmUpdate() {
		return ClickConfirmUpdate;
	}

	//Delete created tier

	public WebElement getDeleteCreatedTier() {
		return DeleteTierButton;
	}

	public WebElement getConfirmDelete() {
		return ConfirmDelete;
	}
	
	//Success message validate return methods
	
	public WebElement getCreateTierSuccessMessage() {
		return CreateTierSuccessMessage;
	}
	
	public WebElement getUpdateTierSuccessMessage() {
		return UpdateTierSuccessMessage;
	}
	
	public WebElement getTierSettingsSuccessMessage() {
		return TierSettingsSuccessMessage;
	}
	
	public String getdeleteTierSuccessMessage(String tierName) {
		String deleteTierToastSuccessMessage = driver.findElement(By.xpath("//div[text()='"+tierName+" tier has been successfully deleted']")).getText();
		return deleteTierToastSuccessMessage;
	}
	

}
