package pageObjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SegmentPage {

	public WebDriver driver;
	public SegmentPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	// Segment section locators
	@FindBy (xpath="//div[contains(text(),'Engage')]")
	WebElement ClickEngage;


	@FindBy (xpath="//div[text()='segment has been successfully enabled']")
	WebElement EnableSegmentSuccessMessage;

	@FindBy (xpath="//span[text()='Manage Segments']")
	WebElement ManageSegments;
	
	@FindBy (name="name")
	WebElement SegmentName;
	
	@FindBy (xpath="//h1[text()='Duplicate Segment']")
	WebElement DuplicateSegmentHeaderTitle;
	
	@FindBy (name="tag")
	WebElement SegmentTag;

	@FindBy (xpath="//span[text()='Create Segment']")
	WebElement CreateSegmentButton;

	//member search filter getter methods
	@FindBy (xpath="//div[@class='option-dropdown css-2b097c-container']//div[@class='eui-dd-value-container css-1svwnjv']")
	WebElement SelectFilterDropDown;

	//Use this code to enter and submit the filter
	@FindBy (xpath="//body[1]/reach-portal[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement SelectFilter1;
	
	@FindBy (xpath="//body[1]/reach-portal[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement SelectFilter2;
	
	@FindBy (xpath="//body[1]/reach-portal[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	WebElement SelectFilter3;

	@FindBy (xpath="//div[@id='react-select-2-option-0']")
	WebElement EnrollmentSelection;

	@FindBy (xpath="//span[text()='Age']")
	WebElement AgeSelection;

	@FindBy (xpath="//span[text()='Add Filter']")
	WebElement AddFilterButton;

	@FindBy (xpath="//span[text()='Last Transaction']")
	WebElement LastTransactionSelection;
	
	@FindBy(xpath="//div[@class='pt-4 filter-segment-options']/div/div/div/div/div/div/div/div/div/div/input")
	WebElement Operator;

	@FindBy(xpath="//input[@placeholder='Value']")
	WebElement InputValue;

	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[1]")
	WebElement InputValue1;
	
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[2]")
	WebElement InputValue2;
	
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[3]")
	WebElement InputValue3;
	
	@FindBy(xpath="(//input[@placeholder='yyyy-mm-dd'])[4]")
	WebElement InputValue4;
	
	@FindBy (xpath="//span[text()='Save']")
	WebElement ClickSaveButton;
	
	@FindBy (xpath="//span[text()='Update']")
	WebElement ClickUpdateButton;
	
	@FindBy(xpath="//img[@role='button']")
	WebElement backButtonArrow;

	@FindBy (xpath="//div[text()='Segment has been successfully Added']")
	WebElement CreateSegmentSuccessMessage;
	
	@FindBy (xpath="//div[text()='Segment has been updated successfully']")
	WebElement UpdateSegmentSuccessMessage;
	
	
	//Segment lists all row data details
		@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td"))
		List<WebElement> AllRowsCount;

		@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td"))
		List<WebElement> AllRowsData;
		
		@FindBy(xpath="//span[text()='Edit']")
		WebElement ClickEditButton;
		
		@FindBy(xpath="//span[text()='View']")
		WebElement ClickViewButton;
		
		@FindBy(xpath="//div[@class='segmentNameText pb-2']")
		WebElement ValidateHeader;
		
		@FindBy(xpath="//span[text()='Duplicate']")
		WebElement ClickDuplicateButton;

		@FindBy(xpath="//span[text()='Delete']")
		WebElement ClickDeleteButton;

		@FindBy(xpath="//span[text()='I understand & Delete']")
		WebElement ConfirmDeleteButton;
		
		@FindBy (xpath="//div[text()='Segment has been successfully deleted']")
		WebElement DeleteSegmentSuccessMessage;
		

	public WebElement  getSelectFilter1() {
		return  SelectFilter1;
	}
	
	public WebElement  getSelectFilter2() {
		return  SelectFilter2;
	}
	
	public WebElement  getSelectFilter3() {
		return  SelectFilter3;
	}
	
	public WebElement  getSelectFilterDropDown() {
		return  SelectFilterDropDown;
	}

	public WebElement  getAgeSelection() {
		return  AgeSelection;
	}

	public WebElement  getAddFilterButton() {
		return  AddFilterButton;
	}
	
	public WebElement  getEnrollmentSelection() {
		return  EnrollmentSelection;
	}

	public WebElement  getLastTransactionSelection() {
		return  LastTransactionSelection;
	}

	// Return methods
	public WebElement  getClickEngage() {
		return  ClickEngage;
	}

	public WebElement  getEnableSegmentSuccessMessage() {
		return  EnableSegmentSuccessMessage;
	}

	public WebElement  getManageSegments() {
		return  ManageSegments;
	}
	public WebElement  getCreateSegmentButton() {
		return  CreateSegmentButton;
	}

	public WebElement  getSegmentName() {
		return  SegmentName;
	}
	
	public WebElement  getDuplicateSegmentHeaderTitle() {
		return  DuplicateSegmentHeaderTitle;
	}
	
	
	public WebElement  getSegmentTag() {
		return  SegmentTag;
	}

	public WebElement  getOperator() {
		return  Operator;
	}

	public WebElement  getInputValue() {
		return  InputValue;
	}
	public WebElement getInputValue1() {
		return InputValue1;
	}
	public WebElement getInputValue2() {
		return InputValue2;
	}
	
	public WebElement getInputValue3() {
		return InputValue3;
	}
	public WebElement getInputValue4() {
		return InputValue4;
	}
	
	public WebElement  getClickSaveButton() {
		return  ClickSaveButton;
	}

	public WebElement  getClickUpdateButton() {
		return  ClickUpdateButton;
	}
	
	public WebElement  getbackButtonArrow() {
		return  backButtonArrow;
	}

	public WebElement  getCreateSegmentSuccessMessage() {
		return  CreateSegmentSuccessMessage;
	}
	
	public WebElement  getUpdateSegmentSuccessMessage() {
		return  UpdateSegmentSuccessMessage;
	}
	
	
	public List<WebElement> getAllRowsCount() {
		return AllRowsCount;
	}

	public List<WebElement> getAllRowsData() {
		return AllRowsData;
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
	
	public WebElement getValidateHeader() {
		return ValidateHeader;
	}

	public WebElement getClickDeleteButton() {
		return ClickDeleteButton;
	}

	public WebElement getConfirmDeleteButton() {
		return ConfirmDeleteButton;
	}
	
	public WebElement getDeleteSegmentSuccessMessage() {
		return DeleteSegmentSuccessMessage;
	}
}
