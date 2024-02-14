package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public WebDriver driver;
	public CampaignPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// Segment section locators
	@FindBy (xpath="//div[contains(text(),'Engage')]")
	WebElement ClickEngage;

	@FindBy (xpath="//span[text()='Create Campaign']")
	WebElement ClickCreateCampaign;

	@FindBy (name="Name")
	WebElement CampaignName;

	//@FindBy (xpath="//div[@class='sc-ggpjZQ bSPhZ']/div/div/div/div/div/div/input")
	@FindBy (xpath="//div[@class='sc-iHmpnF jtNTko mx-4 my-2']/div/div/div/div/div/div/div/div/div/input")
	WebElement TargetAudience;

	@FindBy (xpath="//div[text()='Points Crediting Criteria *']")
	WebElement BonusPointsToIssueLabel;

	@FindBy (name="Bonus")
	WebElement CampaignBonus;

	@FindBy (xpath="//div[contains(text(),'Send points to existing members.')]")
	WebElement PointsCreditingCriteriaExistingMembers;

	@FindBy (xpath="//div[@class='sc-iHmpnF jtNTko mx-4 my-3']/div/div[2]/label[2]/div/span")
	WebElement PointsCreditingCriteriaNewMembers;


	@FindBy (xpath="//div[text()='Advanced Scheduling']")
	WebElement CampaignStartDateLabel;

	@FindBy (xpath="//div[@class='sc-iHmpnF jtNTko mx-4 my-3']/div/div/div/div/div/input")
	WebElement CampaignStartDate;

	@FindBy (xpath="(//div[@class='sc-iHmpnF jtNTko mx-4 my-3']/div/div/div/div/div/input)[2]")
	WebElement CampaignEndDate;

	@FindBy (xpath="//span[text()='Continue']")
	WebElement ClickContinueButton;

	@FindBy (xpath="//span[text()='Cancel']")
	WebElement ClickCancelButton;
	
	@FindBy (xpath="//h1[text()='Create New Campaign']")
	WebElement CreateCommunicationHeader;
	
	@FindBy (xpath="//h1[text()='Edit Campaign']")
	WebElement EditCommunicationHeader;
	

	@FindBy (xpath="//div[@class='sc-iHmpnF jtNTko mx-4 my-2 communication']/div/div/div/div/div/div/div/div/div/input")
	WebElement SelectCommunicationTemplate;

	@FindBy (xpath="//div[@class='flex-grow-1 communication-card']//span[@class='sc-jEACwC jGdOmm btn-label'][normalize-space()='Preview']")
	WebElement PreviewFirstCommunicationTemplate;

	@FindBy (xpath="//div[@class='flex-grow-1 communication-card ml-4']//span[@class='sc-jEACwC jGdOmm btn-label'][normalize-space()='Preview']")
	WebElement PreviewSecondCommunicationTemplate;

	@FindBy (xpath="//body/reach-portal[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]/span[1]//*[name()='svg']")
	WebElement ClosePreviewCommunicationTemplate;

	@FindBy (xpath="//h2[text()='Summary']")
	WebElement ValidateSummary;

	@FindBy (xpath="//span[text()='Create Campaign']")
	WebElement ClickCreateCampaignButton;

	@FindBy (xpath="//span[text()='Save & Enable Now']")
	WebElement ClickSaveEnableNowButton;

	@FindBy (xpath="//span[text()='Save & Enable Later']")
	WebElement ClickSaveEnableLaterButton;

	@FindBy (xpath="//div[text()='Campaign has been successfully Added']")
	WebElement CreateCampaignSuccessMessage;

	@FindBy (xpath="//span[text()='Update Campaign']")
	WebElement ClickUpdateCampaignButton;

	@FindBy (xpath="//div[text()='Updated Campaign successfully']")
	WebElement UpdateCampaignSuccessMessage;
	
	@FindBy (xpath="//div[text()='Campaign disabled']")
	WebElement DisabledCampaignSuccessMessage;
	
	@FindBy (xpath="//div[text()='Campaign enabled successfully']")
	WebElement EnabledCampaignSuccessMessage;

	//Campaign lists all row data details
	@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td"))
	List<WebElement> AllRowsCount;

	@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td"))
	List<WebElement> AllRowsData;

	@FindBy(xpath="//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td/parent::tr/td[1]/div/div/div[@aria-checked='true']")
	WebElement CampaignCurrentStatus;
	
	@FindBy(xpath="//div[@role='switch']")
	WebElement CampaignEnabled;
	
	@FindBy(xpath="//div[@role='switch']")
	WebElement CampaignDisabled;
	
	@FindBy(xpath="//span[text()='Edit']")
	WebElement ClickEditButton;

	@FindBy(xpath="//span[text()='View']")
	WebElement ClickViewButton;

	@FindBy(xpath="(//div[@class='d-flex align-items-center'])[1]")
	WebElement ValidateCampaignRemainingDays; 
	
	@FindBy(xpath="(//div[@class='d-flex align-items-center'])[2]")
	WebElement ValidateCampaignStartDate;
	
	@FindBy(xpath="(//div[@class='d-flex align-items-center pt-3'])[1]")
	WebElement ValidateCampaignEndDate;
	
	@FindBy(xpath="(//div[@class='d-flex align-items-center pt-3'])[2]")
	WebElement ValidateCampaignCreatedDate;
	
	@FindBy(xpath="(//h1[@class='sc-gsFSXq hgEqaJ pt-2'])[1]")
	WebElement ValidatePointsIssuedPerMember;
	
	@FindBy(xpath="(//h1[@class='sc-gsFSXq hgEqaJ pt-2'])[2]")
	WebElement ValidateMemberSize;
	
	@FindBy(xpath="(//h1[@class='sc-gsFSXq hgEqaJ pt-2'])[3]")
	WebElement ValidateTotalPointsIssued;
	
	@FindBy(xpath="(//h2[@class='sc-kAyceB dprlGx'])[3]")
	WebElement ValidateCreditedMembersList;
	

	@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td/parent::tr"))
	List<WebElement> ValidateCreditedMembersListData;

	@FindBy(xpath="//img[@role='button']")
	WebElement backButtonArrow;

	@FindBy(xpath="//span[text()='Duplicate']")
	WebElement ClickDuplicateButton;

	@FindBy(xpath="//span[text()='Delete']")
	WebElement ClickDeleteButton;

	@FindBy(xpath="//span[text()='I understand & Delete']")
	WebElement ConfirmDeleteButton;

	// Return methods

	public WebElement  getClickCreateCampaign() {
		return  ClickCreateCampaign;
	}

	public WebElement  getCampaignName() {
		return  CampaignName;
	}

	public WebElement  getTargetAudience() {
		return  TargetAudience;
	}

	public WebElement  getBonusPointsToIssueLabel() {
		return  BonusPointsToIssueLabel;
	}

	public WebElement  getCampaignBonus() {
		return  CampaignBonus;
	}

	public WebElement  getPointsCreditingCriteriaExistingMembers() {
		return  PointsCreditingCriteriaExistingMembers;
	}

	public WebElement  getPointsCreditingCriteriaNewMembers() {
		return  PointsCreditingCriteriaNewMembers;
	}

	public WebElement  getCampaignStartDateLabel() {
		return  CampaignStartDateLabel;
	}

	public WebElement  getCampaignStartDate() {
		return  CampaignStartDate;
	}

	public WebElement  getCampaignEndDate() {
		return  CampaignEndDate;
	}

	public WebElement  getClickContinueButton() {
		return  ClickContinueButton;
	}

	public WebElement  getClickCancelButton() {
		return  ClickCancelButton;
	}

	public WebElement  getCreateCommunicationHeader() {
		return  CreateCommunicationHeader;
	}
	
	public WebElement  getEditCommunicationHeader() {
		return  EditCommunicationHeader;
	}
	
	public WebElement  getSelectCommunicationTemplate() {
		return  SelectCommunicationTemplate;
	}

	public WebElement  getPreviewFirstCommunicationTemplate() {
		return  PreviewFirstCommunicationTemplate;
	}

	public WebElement  getPreviewSecondCommunicationTemplate() {
		return  PreviewSecondCommunicationTemplate;
	}

	public WebElement  getClosePreviewCommunicationTemplate() {
		return  ClosePreviewCommunicationTemplate;
	}


	public WebElement  getValidateSummary() {
		return  ValidateSummary;
	}

	public WebElement  getClickCreateCampaignButton() {
		return  ClickCreateCampaignButton;
	}

	public WebElement  getClickSaveEnableNowButton() {
		return  ClickSaveEnableNowButton;
	}

	public WebElement  getClickSaveEnableLaterButton() {
		return  ClickSaveEnableLaterButton;
	}

	public WebElement  getCreateCampaignSuccessMessage() {
		return  CreateCampaignSuccessMessage;
	}

	public WebElement  getClickUpdateCampaignButton() {
		return  ClickUpdateCampaignButton;
	}

	public WebElement  getUpdateCampaignSuccessMessage() {
		return  UpdateCampaignSuccessMessage;
	}
	
	public WebElement  getDisabledCampaignSuccessMessage() {
		return  DisabledCampaignSuccessMessage;
	}
	public WebElement  getEnabledCampaignSuccessMessage() {
		return  EnabledCampaignSuccessMessage;
	}
	
	public List<WebElement> getAllRowsCount() {
		return AllRowsCount;
	}

	public List<WebElement> getAllRowsData() {
		return AllRowsData;
	}
	
	public WebElement  getCampaignCurrentStatus() {
		return CampaignCurrentStatus;
	}
	
	public WebElement  getCampaignEnabled() {
		return CampaignEnabled;
	}
	public WebElement  getCampaignDisabled() {
		return CampaignDisabled;
	}
	
	
	public WebElement getClickEditButton() {
		return ClickEditButton;
	}
	public WebElement getClickViewButton() {
		return ClickViewButton;
	}
	
	public WebElement getClickDuplicateButton() {
		return ClickDuplicateButton;
	}
	
	public WebElement getValidateCampaignRemainingDays() {
		return ValidateCampaignRemainingDays;
	}
	
	public WebElement getValidateCampaignStartDate() {
		return ValidateCampaignStartDate;
	}
	
	public WebElement getValidateCampaignEndDate() {
		return ValidateCampaignEndDate;
	}
	
	public WebElement getValidateCampaignCreatedDate() {
		return ValidateCampaignCreatedDate;
	}
	
	public WebElement getValidatePointsIssuedPerMember() {
		return ValidatePointsIssuedPerMember;
	}
	
	public WebElement ValidateTotalPointsIssued() {
		return ValidateTotalPointsIssued;
	}
	
	public WebElement getValidateMemberSize() {
		return ValidateMemberSize;
	}
	
	public WebElement getValidateTotalPointsIssued() {
		return ValidateTotalPointsIssued;
	}
	
	public WebElement getValidateCreditedMembersList() {
		return ValidateCreditedMembersList;
	}
	
	public List<WebElement> getValidateCreditedMembersListData() {
		return ValidateCreditedMembersListData;
	}
	
	public WebElement getbackButtonArrow() {
		return backButtonArrow;
	}

	public WebElement getClickDeleteButton() {
		return ClickDeleteButton;
	}

	public WebElement getConfirmDeleteButton() {
		return ConfirmDeleteButton;
	}
	
	

}
