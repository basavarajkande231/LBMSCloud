package pageObjects;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ReportsPage {

	public WebDriver driver;
	public ReportsPage(WebDriver driver) {

		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	//Settings WebElements

	@FindBy (xpath="//span[text()='Settings']")
	WebElement ClickSettings;

	@FindBy(xpath="//h2[text()='Report Settings']/parent::div/div/form/div[1]/div/div/div/div/div[1]/div/div/div/input")
	WebElement FinancialYearType;

	@FindBy(xpath="//h2[text()='Report Settings']/parent::div/div/form/div[2]/div/div/div/div/div[1]/div/div/div/input")
	WebElement WeekStartDay;

	@FindBy (name="DelayDays")
	WebElement DelayDays;

	@FindBy (name="RetentionDays")
	WebElement HistoricalView;

	@FindBy (xpath="//span[text()='Save']")
	WebElement ClickSaveButton;

	@FindBy (xpath="//div[text()='Setting saved sucessfully']")
	WebElement SettingsSuccessMessage;

	@FindBy (xpath="//span[text()='Cancel']")
	WebElement ClickCancelButton;

	@FindBy (xpath="//button[@class='sc-eDPEul kAyLyY eui-modal-close']")
	WebElement ClickCloseIcon;


	//TRANSACTIONAL SECTION
	//Transactional report WebElement

	@FindBy (xpath="//span[text()='Add New View']")
	WebElement AddNewView;

	//@FindBy (xpath="//h1[text()='Add New Transactional view']")
	//@FindBy (xpath="//h1[text()=//span[text()='Transactional']")
	@FindBy (xpath="//span[text()='Transactional']")
	WebElement TransactionalSection;

	@FindBy (name="reportName")
	WebElement ReportName;

	// use this for enter the text on the dropdown 
	@FindBy (xpath="//div[text()='Report Column']/parent::div/div/div/div/input")
	//Use the below if the DOM element is not present
	@CacheLookup
	WebElement ReportColumn;


	@FindBy (xpath="//div[text()='Report saved sucessfully']")
	WebElement CreateTXNReportSuccessMessage;

	@FindBy (xpath="//div[text()='Report deleted successfully']")
	WebElement DeleteTXNReportSuccessMessage;
	
	@FindBy (xpath="//div[text()='Your report is generated now']")
	WebElement GenerateLiveReportSuccessMessage;
	

	//Reports lists all row data details
	@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td"))
	List<WebElement> AllRowsCount;

	@FindAll(@FindBy(how = How.XPATH, using = "//table[@class='MuiTable-root tss-900muf-MUIDataTable-tableRoot css-1owb465']//td"))
	List<WebElement> AllRowsData;

	@FindBy(xpath="parent::tr")
	WebElement CreatedReportRow;

	@FindBy(xpath="td[6]")
	WebElement Actionsrow;

	//View the transactional report
	
	@FindBy(xpath="//span[text()='View']")
	WebElement ClickViewButton;
	
	@FindBy(id="heading_text")
	WebElement ValidateHeader;
	
	@FindBy(xpath="//img[@role='button']")
	WebElement backButtonArrow;

	@FindBy(xpath="//span[text()='Delete']")
	WebElement ClickDeleteButton;
	
	@FindBy(xpath="//span[text()='Generate']")
	WebElement ClickGenerateButton;


	@FindBy(xpath="//span[text()='I understand & Delete']")
	WebElement ConfirmDeleteButton;
	
	// Filter column WebElement

	@FindBy (xpath="//div[text()='Filter']/parent::div/div/div/div/input")
	//Use the belw if the DOM element is not present
	@CacheLookup
	WebElement FilterColumn;

	//Period of generation WebElement
	
	@FindBy (xpath="//div[text()='Period of generation']/parent::div/div/div/div/input")
	//Use the belw if the DOM element is not present
	@CacheLookup
	WebElement PeriodOfGeneration;
	
	//DOWNLOAD REPORT LOCATORS
	
	@FindBy (xpath="//p[@class='sc-eqUAAy jHYWZO download-text']")
	WebElement DownloadPreviewLink;
	
	@FindBy (xpath="//span[text()='Download Report']")
	WebElement DownloadReportButton;
	
	@FindBy (xpath="//div[@class='css-bijwco']/div/input")
	WebElement TimeInterval;
	
	@FindBy (xpath="//p[text()='Select Date']")
	WebElement SelectDate;
	
	@FindBy (xpath="//div[@aria-current='date']")
	WebElement SelectCurrentDate;
	
	@FindBy (xpath="//p[text()='Select Week']")
	WebElement SelectWeek;
	
	@FindBy (xpath="//div[@class='react-datepicker__current-month']")
	WebElement WeekHeaderSection;
	
	
	@FindBy (xpath="//div[@aria-disabled='false']")
	WebElement SelectCurrentWeek;
	
	@FindBy (xpath="//p[text()='Select Month']")
	WebElement SelectMonth;
	
	@FindBy (xpath="//div[@aria-label='Choose December 2023']")
	WebElement SelectCurrentMonth;
	
	@FindBy (xpath="//button[@aria-label='Previous Year']")
	WebElement ClickPerviousYearIcon;
	
	@FindBy (xpath="//button[@aria-label='Next Year']")
	WebElement ClickNextYearIcon;
	
	
	@FindBy (name="save")
	WebElement ClickDownloadButton;
	
	@FindBy (xpath="//div[text()='No records found']")
	WebElement NoRecordFound;
	
	

	//MEMBERS SECTION

	//Members Reports WebElements

	@FindBy (xpath="//div[@type='default'][2]")
	WebElement MembersSection;

	@FindBy (xpath="//h1[text()='Add New Members view']")
	WebElement MemberHeader;

	@FindBy (xpath="//span[text()='Add Filters']")
	WebElement AddFilters;
	
	//member filters
	
	@FindBy(xpath="//span[text()='Filters']")
	WebElement MemberFilter;
	
	//@FindBy(xpath="//div[@class='eui-dd-input']/input")
	@FindBy(xpath="//div[@class='mb-3']//div[@class='css-bijwco']/div/input")
	WebElement operator;
	
	@FindBy(xpath="//div[@class='position-relative']//div[@class='mb-3'][2]//input|//textarea")
	WebElement InputValue1;
	
	@FindBy(xpath="//div[@class='position-relative']//div[@class='mb-3'][3]//input")
	WebElement InputValue2;
	
    @FindBy(xpath="//span[text()='Add Filter']")
	WebElement ClickAddFilterButton;
	
	@FindBy(xpath="//span[text()='Apply Filters']")
	WebElement ApplyFilter;
	
	
	//member search filter getter methods
	
		public void GetFilterandClick(String FilterName) {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//WebElement Filter = driver.findElement(By.xpath("//div[@class='d-flex align-items-end filter-card px-2 ']//div[text()='"+FilterName+"']"));
			
			WebElement Filter = driver.findElement(By.xpath("//div[text()='"+FilterName+"']"));
			Filter.click();
	
		}
	
	//COMMUNICATION SECTION

	//Communication section locators

	@FindBy (xpath="//span[text()='Communication']")
	WebElement CommunicationSection;

	@FindBy (xpath="//h1[text()='Add New Communication view']")
	WebElement CommunicationHeader;

	// Report name is directly taking from transactional section
	
	
	//LOGS SECTION
	//Logs locators
	
	@FindBy (xpath="//span[text()='Logs']")
	WebElement LogsSection;
	
	@FindBy (xpath="//input[@placeholder='Search file name']")
	WebElement SearchByFileName;
	
	@FindBy (id="start-date")
	WebElement StartDate;
	
	@FindBy (id="end-date")
	WebElement EndDate;
	
	
	
	
	public String SearchFilenameValidate(String SearchByFileName) {
		
		WebElement actualFileName=driver.findElement(By.xpath("//div[text()='"+SearchByFileName+"']"));
		return actualFileName.getText();

	}
	
	
	

	//Settings return methods

	public WebElement  getClickSettings() {
		return  ClickSettings;
	}

	public WebElement  getFinancialYearType() {
		return  FinancialYearType;
	}

	public WebElement  getWeekStartDay() {
		return  WeekStartDay;
	}

	public WebElement  getDelaydays() {
		return  DelayDays;
	}

	public WebElement  getHistoricalView() {
		return  HistoricalView;
	}

	public WebElement  getClickSaveButton() {
		return  ClickSaveButton;
	}

	public WebElement  getSettingsSuccessMessage() {
		return  SettingsSuccessMessage;
	}

	public WebElement  getClickCancelButton() {
		return  ClickCancelButton;
	}

	public WebElement  getClickCloseIcon() {
		return  ClickCloseIcon;
	}


	//Transactional reports return methods

	public WebElement  getAddNewView() {
		return AddNewView;
	}

	public WebElement  getTransactionalSection() {
		return  TransactionalSection;


	}
	public WebElement  getReportName() {
		return  ReportName;
	}

	//Reports column return methods

	public WebElement  getReportColumn() {
		return  ReportColumn;
	}

	public WebElement  getCreateTXNReportSuccessMessage() {
		return  CreateTXNReportSuccessMessage;
	}

	public WebElement  getDeleteTXNReportSuccessMessage() {
		return  DeleteTXNReportSuccessMessage;
	}
	
	public WebElement  getGenerateLiveReportSuccessMessage() {
		return  GenerateLiveReportSuccessMessage;
	}
	

	public List<WebElement> getAllRowsCount() {
		return AllRowsCount;
	}


	public List<WebElement> getAllRowsData() {
		return AllRowsData;
	}

	public WebElement getCreatedReportRow() {
		return CreatedReportRow;	
	}

	public WebElement getActionsrow() {
		return Actionsrow;
	}

	
	//View transactional return methods
	public WebElement getClickViewButton() {
		return ClickViewButton;
	}
	
	public WebElement getClickGenerateButton() {
		return ClickGenerateButton;
	}
	
	public WebElement getValidateHeader() {
		return ValidateHeader;
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

	public WebElement  getFilterColumn() {
		return  FilterColumn;
	}

	public WebElement  getPeriodOfGeneration() {
		return  PeriodOfGeneration;
	}
	
	public WebElement  getDownloadPreviewLink() {
		return  DownloadPreviewLink;
	}

	public WebElement  getDownloadReportButton() {
		return  DownloadReportButton;
	}
	
	public WebElement  getTimeInterval() {
		return  TimeInterval;
	}
	
	public WebElement  getSelectDate() {
		return  SelectDate;
	}
	
	public WebElement  getSelectCurrentDate() {
		return  SelectCurrentDate;
	}
	
	public WebElement  getSelectWeek() {
		return  SelectWeek;
	}
	
	public WebElement  getWeekHeaderSection() {
		return  WeekHeaderSection;
	}
	
	
	public WebElement  getSelectCurrentWeek() {
		return  SelectCurrentWeek;
	}
	
	public WebElement  getSelectMonth() {
		return  SelectMonth;
	}
	
	public WebElement  getSelectCurrentMonth() {
		return  SelectCurrentMonth;
	}
	
	public WebElement  getClickPerviousYearIcon() {
		return  ClickPerviousYearIcon;
	}
	
	public WebElement  ClickNextYearIcon() {
		return  ClickNextYearIcon;
	}
	
	
	public WebElement  getClickDownloadButton() {
		return  ClickDownloadButton;
	}
	
	public WebElement  getNoRecordFound() {
		return  NoRecordFound;
	}
	
	
	
	// MEMBER SECTION

	public WebElement  getMemberHeader() {
		return MemberHeader;

	}

	public WebElement  getMembersSection() {
		return MembersSection;

	}

	public WebElement  getAddFilters() {
		return AddFilters;

	}

	// Member filters return methods
	
	public WebElement getOperator() {
		return operator;
	}
	public WebElement getInputValue1() {
		return InputValue1;
	}
	public WebElement getInputValue2() {
		return InputValue2;
	}
	public WebElement getClickAddFilterButton() {
		return ClickAddFilterButton;
	}
	public WebElement getApplyFilter() {
		return ApplyFilter;
	}
	
	
	//COMMUNICATION SECTION

	//Communication section return methods

	public WebElement getCommunicationSection() {
		return CommunicationSection;
	}

	//public WebElement getCommunicationAddNewView() {
	//	return CommunicationAddNewView; }

	public WebElement  getCommunicationHeader() {
		return CommunicationHeader;

	}
	
	//LOGS SECTION 
	//Logs section return methods
	
	public WebElement getLogsSection() {
		return LogsSection;
	}
	
	public WebElement getSearchByFileName() {
		return SearchByFileName;
	}
	
	public WebElement getStartDate() {
		return StartDate;
	}
	
	public WebElement getEndDate() {
		return EndDate;
	}
	


}
