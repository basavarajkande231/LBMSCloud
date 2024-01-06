package pageObjects;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MemberSearchPage {

	public WebDriver driver;
	
	public MemberSearchPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[text()='Members']")
	WebElement MemberSearchIcon;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search by ')]")
	WebElement MemberSearchField;
	
	@FindBy(xpath="//tbody[contains(@class,'MuiTableBody-root css-1xnox0e')]/tr[1]/td[2]/div/div")
	WebElement FirstSearchRow;
	
	@FindBy(xpath="//span[text()='Action']")
	WebElement ActionButton;
	
	@FindBy(xpath="//span[text()='Add/Remove Points']")
	WebElement AddRemovePointsButton;
	
	@FindBy(xpath="//input[@id='transactionType']")
	WebElement TXNTypeField;
	
	@FindBy(xpath="//input[@name='transactionType']")
	WebElement DebitDropDown;
	
	@FindBy(xpath="//input[@name='points']")
	WebElement PointsField;  
	
	@FindBy(xpath="//textarea[@name='description']")
	WebElement DesField;
	
	@FindBy(xpath="//button[@type='submit']/span[@class='sc-jEACwC jGdOmm btn-label']")
	WebElement SubmitButton;
	
	@FindBy(xpath="//span[text()='Send for Approval']")
	WebElement SendforApprovalButton;
	
	
	@FindBy(xpath="//span[text()='Suspend']")
	WebElement SuspendButton;
	
	@FindBy(xpath="//span[contains(text(),'Yes, ')]")
	WebElement ConfirmationButton;
	
	@FindBy(xpath="//span[text()='Re-Activate']")
	WebElement ReActivateButton;
	
	@FindBy(xpath="//span[text()='Audit Log']")
	WebElement AuditLogButton;
	
	@FindBy(xpath="//div[@class='CalendarPicker']/div/div/div/div/input")
	WebElement FromDate;
	
	@FindBy(xpath="//div[@class='CalendarPicker']/div/div/div/div[4]/input")
	WebElement Todate;
	
	@FindBy(xpath="//span[text()='Search']")
	WebElement SearchButton;
	
	
	//member search filter locators
	
	@FindBy(xpath="//span[text()='Filters']")
	WebElement MemberFilter;
	
	@FindBy(xpath="//div[@class='eui-dd-input']/input")
	WebElement operator;
	
	@FindBy(xpath="//div[@class='position-relative']//div[@class='mb-3'][2]//input|//textarea")
	WebElement InputValue1;
	
	@FindBy(xpath="//div[@class='position-relative']//div[@class='mb-3'][3]//input")
	WebElement InputValue2;
	
	@FindBy(xpath="//span[text()='Add Filter']")
	WebElement AddFilter;
	
	@FindBy(xpath="//span[text()='Apply Filters']")
	WebElement ApplyFilter;
	
	//manage member attribute locator
	
	@FindBy(xpath="//span[text()='Manage Member Attributes']")
	WebElement MemberAttributeLink;
	
	@FindBy(xpath="//span[text()='Add new custom attribute']")
	WebElement AddNewCustomAttributeButton;
	
	@FindBy(xpath="//input[@type='text'][@name='label']")
	WebElement AttributeName;
	
	@FindBy(xpath="//input[@type='text'][@name='apiKey']")
	WebElement APIKey;
	
	@FindBy(xpath="//label[text()='Data type']/parent::div/div/div/div/div/div/div/input")
	@CacheLookup
	WebElement DataType;
	
	@FindBy(xpath="//div[text()='Field is Mandatory']/parent::div/preceding-sibling::div/span")
	WebElement MandatoryCheckBox;
				  
	@FindBy(xpath="//div[text()='Field is Unique']/parent::div/preceding-sibling::div/span")
	WebElement UniqueCheckBox;
	
	@FindBy(xpath="//span[text()='Cancel']")
	WebElement CancelButton;
	
	@FindBy(xpath="//span[text()='save']")
	WebElement SaveButton;
	
	
	//getter methods for member search locators
	public WebElement getMemberSearch() {
		return MemberSearchIcon;
	}
	
	public WebElement getMemberSearchField() {
		return MemberSearchField;
	}
	
	
	public WebElement getFirstSearchRow() {
		return FirstSearchRow;
	}
	
	public String GetMemberName(String Name) {
		WebElement MemName = driver.findElement(By.xpath("//h1[text()='"+Name+"']"));
		String MemberName = MemName.getText();
		return MemberName;
	}
	public String GetMemberRefNo(String RefNo) {
		WebElement MemRefNo = driver.findElement(By.xpath("//p[text()='"+RefNo+"']"));
		String MemberRefNo = MemRefNo.getText();
		return MemberRefNo;
	}
	public String GetMemberMobile(String Mobile) {
		WebElement MemMobile = driver.findElement(By.xpath("//p[text()='"+Mobile+"']"));
		String MemberMobile = MemMobile.getText();
		return MemberMobile;
	}
	public String GetmemberEMail(String Email) {
		WebElement MemEmail = driver.findElement(By.xpath("//p[text()='"+Email+"']"));
		String MemberEmail = MemEmail.getText();
		return MemberEmail;
	}
	
	public WebElement getActionButton() {
		return ActionButton;
	}	
	
	public WebElement getAddRemovePointsButton() {
		return AddRemovePointsButton;
	}
		
	public WebElement getTXNTypeField() {
		return TXNTypeField;
	}
	
	public WebElement getDebitDropDown() {
		return DebitDropDown;
	}
	
	public WebElement getPointsField() {
		return PointsField;
	}
	public WebElement getDesField() {
		return DesField;
	}
	
	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	public WebElement getSendforApprovalButton() {
		return SendforApprovalButton;
	}
	
	public WebElement getSuspendButton() {
		return SuspendButton;
	}
	public WebElement getConfirmationButton() {
		return ConfirmationButton;
	}
	public WebElement getReActivateButton() {
		return ReActivateButton;
	}
	
	public WebElement getAuditLogButton() {
		return AuditLogButton;
	}
	
	public WebElement getFromDate() {
		return FromDate;
	}
	
	public WebElement getToDate() {
		return Todate;
	}
	
	public WebElement getSearchButton() {
		return SearchButton;
	}
	
	public WebElement getMemberFilter() {
		return MemberFilter;
	}
	
	
	//member search filter getter methods
	
	public void GetFilterandClick(String FilterNanme) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement Filter = driver.findElement(By.xpath("//div[@class='d-flex align-items-end filter-card px-2 ']//div[text()='"+FilterNanme+"']"));
		Filter.click();
				
}
	
	public WebElement getOperator() {
		return operator;
	}
	public WebElement getInputValue1() {
		return InputValue1;
	}
	public WebElement getInputValue2() {
		return InputValue2;
	}
	public WebElement getAddFilter() {
		return AddFilter;
	}
	public WebElement getApplyFilter() {
		return ApplyFilter;
	}
	
	
	//getter methods for member attributes
	
	public WebElement getMemberAttributeLink() {
		return MemberAttributeLink;
	}
	
	public WebElement getAddNewCustomAttributeButton() {
		return AddNewCustomAttributeButton;
	}
	
	public WebElement  getAttributeName(){
		return AttributeName;
	}
	public WebElement getAPIKey() {
		return APIKey;
	}
	public WebElement getDataType() {
		return DataType;
	}
	
	public WebElement getMandatoryCheckBox() {
		return MandatoryCheckBox;
	}
	
	public WebElement getUniqueCheckBox() {
		return UniqueCheckBox;
	}
	
	public WebElement getCancelButton() {
		return CancelButton;
	}
	
	public WebElement getSaveButton() {
		return SaveButton;
	}
}

