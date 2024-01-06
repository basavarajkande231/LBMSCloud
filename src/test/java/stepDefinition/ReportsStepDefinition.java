package stepDefinition;


import java.io.File;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.reporter.FileUtil;

import io.cucumber.java.en.*;
import pageObjects.NavigationPage;
import pageObjects.ReportsPage;
import resources.BrowserUtils;
import resources.base;


public class ReportsStepDefinition extends base{

	ReportsPage reports=new ReportsPage(driver);
	NavigationPage Navigation2 = new NavigationPage(driver);

	//TRANSACTIONAL SECTION

	@Given("User navigates to reports module")
	public void user_navigates_to_reports_module() throws InterruptedException {
		Thread.sleep(2000);
		BrowserUtils.clickElement(Navigation2.getClickReports());

	}

	@When("user clicks on the settings")
	public void user_clicks_on_the_settings() throws InterruptedException {

		BrowserUtils.clickElement(reports.getClickSettings());

	}

	@When("user change the Financial Year to {string} Week Starting on to {string} Delay in Generation {string} Days and Historical View as {string} Days")
	public void user_change_the_financial_year_to_week_starting_on_to_delay_in_generation_days_and_historical_view_as_days
	(String FinancialYear, String WeekStartsOn, String DelayinGenerations, String HistoricalView) throws InterruptedException {

		Thread.sleep(1000);

		BrowserUtils.enterText(reports.getFinancialYearType(), FinancialYear);
		BrowserUtils.submit(reports.getFinancialYearType());

		BrowserUtils.enterText(reports.getDelaydays(), WeekStartsOn);
		BrowserUtils.submit(reports.getDelaydays());

		BrowserUtils.ClearAndEnterText(reports.getDelaydays(), DelayinGenerations );
		BrowserUtils.ClearAndEnterText(reports.getHistoricalView(), HistoricalView);
		BrowserUtils.clickElement(reports.getClickSaveButton());

		//BrowserUtils.clickElement(reports.getClickCancelButton());
		//BrowserUtils.clickElement(reports.getClickCloseIcon());

	}


	@Then("user should get the success message as {string}")
	public void user_should_get_the_success_message_as(String successToastMessage) throws InterruptedException {

		try {
			if(successToastMessage.equalsIgnoreCase("Setting saved sucessfully")) {
				Thread.sleep(1000);

				String reportsSettingSuccess = reports.getSettingsSuccessMessage().getText();
				System.out.println("The success message is: " + reportsSettingSuccess);
				Assert.assertEquals(reportsSettingSuccess, "Setting saved sucessfully");
			}
			else if (successToastMessage.equalsIgnoreCase("Report saved successfully")) {
				Thread.sleep(1000);

				String createReportSuccessMessage = reports.getCreateTXNReportSuccessMessage().getText();
				System.out.println("The success message is: " + createReportSuccessMessage);
				Assert.assertEquals(createReportSuccessMessage, "Report saved sucessfully");

			}
			else if (successToastMessage.equalsIgnoreCase("Report deleted successfully")) {

				//Wait for 2 second then element will find and then match the condition
				Thread.sleep(1000);

				String deleteReportSuccessMessage = reports.getDeleteTXNReportSuccessMessage().getText();
				System.out.println("The success message is: " + deleteReportSuccessMessage);
				Assert.assertEquals(deleteReportSuccessMessage, "Report deleted successfully");

			}

			
		} catch (StaleElementReferenceException exception) {
			exception.printStackTrace();
			
		}
		
		
	}


	@Given("user selects {string} and click on add new view and add the report name as {string}")
	public void	user_selects_and_click_on_add_new_view_and_add_the_report_name_as(String Section, String ReportName) throws InterruptedException{



		if(Section.equalsIgnoreCase("Transactional")) {

			BrowserUtils.clickElement(reports.getAddNewView());
			BrowserUtils.enterText(reports.getReportName(), ReportName);

		} 
		else if(Section.equalsIgnoreCase("Members")) {

			BrowserUtils.clickElement(reports.getMembersSection());
			BrowserUtils.clickElement(reports.getAddNewView());
			BrowserUtils.enterText(reports.getReportName(), ReportName);

		}
		else if(Section.equalsIgnoreCase("Communication")) {

			BrowserUtils.clickElement(reports.getCommunicationSection());
			BrowserUtils.clickElement(reports.getAddNewView());
			BrowserUtils.enterText(reports.getReportName(), ReportName);

		}
		else if(Section.equalsIgnoreCase("Logs")) {

			BrowserUtils.clickElement(reports.getCommunicationSection());
			BrowserUtils.clickElement(reports.getAddNewView());
			BrowserUtils.enterText(reports.getReportName(), ReportName);

		}
	}


	@And("add the report column as {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_the_report_column_as(String TransactionId, String TransactionAmount, String RelationReference, String PointsIssued, String TransactionDate, String ProcessingDate, String Type, String ProductCode, String SubProductCode, String Narration, String PointsSpoiled, String MerchantName, String TransactionCount, String ImpactedMembers, String TotalPointsIssued, String TotalAmount, String TotalPointsSpoiled) throws InterruptedException {


		BrowserUtils.enterText(reports.getReportColumn(), TransactionId);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TransactionAmount);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), RelationReference);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), PointsIssued);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TransactionDate);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), ProcessingDate);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), Type);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), ProductCode);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), SubProductCode);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), Narration);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), PointsSpoiled);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), MerchantName);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TransactionCount);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), ImpactedMembers);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalPointsIssued);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalAmount);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalPointsSpoiled);
		BrowserUtils.submit(reports.getReportColumn());


	}


	@When("add the filter as {string} {string} {string} {string}")
	public void add_the_filter_as(String CreditByAccrual, String CreditByBonus, String DebitByBonus, String DebitByCashback) throws InterruptedException {
		//Enter the Transaction Id text by automatically by using key board


		BrowserUtils.enterText(reports.getFilterColumn(), CreditByAccrual);
		BrowserUtils.submit(reports.getFilterColumn());

		BrowserUtils.enterText(reports.getFilterColumn(), CreditByBonus);
		BrowserUtils.submit(reports.getFilterColumn());

		BrowserUtils.enterText(reports.getFilterColumn(), DebitByBonus);
		BrowserUtils.submit(reports.getFilterColumn());

		BrowserUtils.enterText(reports.getFilterColumn(), DebitByCashback);
		BrowserUtils.submit(reports.getFilterColumn());
	} 

	@When("select the period of generation as {string} {string} {string} {string} {string}")
	public void select_the_period_of_generation_as(String Daily, String Weekly, String Monthly, String Quarterly, String Yearly) throws InterruptedException {


		BrowserUtils.enterText(reports.getPeriodOfGeneration(), Daily);
		BrowserUtils.submit(reports.getPeriodOfGeneration());

		BrowserUtils.enterText(reports.getPeriodOfGeneration(), Weekly);
		BrowserUtils.submit(reports.getPeriodOfGeneration());

		BrowserUtils.enterText(reports.getPeriodOfGeneration(), Monthly);
		BrowserUtils.submit(reports.getPeriodOfGeneration());

		BrowserUtils.enterText(reports.getPeriodOfGeneration(), Quarterly);
		BrowserUtils.submit(reports.getPeriodOfGeneration());

		BrowserUtils.enterText(reports.getPeriodOfGeneration(), Yearly);
		BrowserUtils.submit(reports.getPeriodOfGeneration());

	}



	@When("clicks on the {string} button")
	public void clicks_on_the_button(String SaveButton) throws InterruptedException {

		//Using this method because of the "ElementClickInterceptedException" error

		try {
			Thread.sleep(1000);
			BrowserUtils.clickElement(reports.getClickSaveButton());
		} catch (ElementClickInterceptedException exception) {

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Thread.sleep(1000);
			executor.executeScript("arguments[0].click();", reports.getClickSaveButton());

		}


	}


	@When("user validate the existing report {string} and click on {string}")
	public void user_validate_the_existing_report_and_click_on(String reportName, String Actions) throws InterruptedException {
Thread.sleep(5000);
		//Use this code to perform scroll on application

				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,550)", "");
		
		try {

			List<WebElement> allRowsCount = BrowserUtils.findAndWaitForElements(reports.getAllRowsCount());
			System.out.println("The counts of rows data are " + allRowsCount.size());


			// Checking all the row data
			List<WebElement> allRowsData = BrowserUtils.findAndWaitForElements(reports.getAllRowsData());

			// Validating the created tier entry is available or not
			boolean dataStatus = false;

			for (WebElement ele : allRowsData) {
				String value = ele.getText();
				System.out.println(value);
				Thread.sleep(500);

				if (value.equalsIgnoreCase(reportName)) {
					dataStatus = true;
					System.out.println("Record found: " + dataStatus);
					Thread.sleep(500);

					WebElement Row = ele.findElement(By.xpath("parent::tr"));
					Thread.sleep(500);

					WebElement row = Row.findElement(By.xpath("td[4]"));
					Thread.sleep(500);

					WebElement ActionClick = row.findElement(By.tagName("Button"));
					Thread.sleep(500);

					ActionClick.click();

					if (Actions.equalsIgnoreCase("View")) {

						BrowserUtils.clickElement(reports.getClickViewButton());
						Thread.sleep(500);

						String ActualHeaderTitle=reports.getValidateHeader().getText();
						System.out.println("The header title is: "+ActualHeaderTitle);
						Assert.assertEquals(ActualHeaderTitle, reportName);
                        
						
					}
					else {
						BrowserUtils.clickElement(reports.getClickDeleteButton());
						BrowserUtils.clickElement(reports.getConfirmDeleteButton());

					}
				}
			}
		} catch (StaleElementReferenceException exception) {
			exception.printStackTrace();	
		}
	}


	//COMMUNICATION SECTION

	@Given("User navigates to communication section")
	public void user_navigates_to_communication_section() throws InterruptedException {
		Thread.sleep(1000);
		BrowserUtils.clickElement(reports.getCommunicationSection());
		BrowserUtils.clickElement(reports.getAddNewView());

	}

	@When("add the report column as {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_the_report_column_as(String TemplateName, String EmailStatus, String SMSStatus, String DateEmailSMSSent, String CommunicationChannel, String MemberID, String PhoneNumber, String MemberName, String Email, String TotalCommunicationSent, String TotalSuccessDelivery, String TotalFailedDelivery) throws InterruptedException {

		BrowserUtils.enterText(reports.getReportColumn(), TemplateName);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), EmailStatus);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), SMSStatus);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), DateEmailSMSSent);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), CommunicationChannel);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), MemberID);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), PhoneNumber);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), MemberName);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), Email);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalCommunicationSent);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalSuccessDelivery);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalFailedDelivery);
		BrowserUtils.submit(reports.getReportColumn());



	}

	@When("add the filter as {string} {string}")
	public void add_the_filter_as(String SMSCommunicationChannel, String EmailCommunicationChannel) throws InterruptedException {

		BrowserUtils.enterText(reports.getFilterColumn(), SMSCommunicationChannel);
		BrowserUtils.submit(reports.getFilterColumn());

		BrowserUtils.enterText(reports.getFilterColumn(), EmailCommunicationChannel);
		BrowserUtils.submit(reports.getFilterColumn());
	}


	// MEMBERS SECTION

	@When("add the report column as {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void add_the_report_column_as(String MemberID, String MemberName, String Email, String PhoneNumber, String SegmentTag, String EnrollmentDate, String Gender, String Address, 
			String Tier, String Status, String DOB, String PointsAvailable, String PointsExpired, String PointsRedeemed, String LastTransaction, String TotalTransactions, String TotalMembers, String TotalPointsIssued, String TotalPointsRedeemed, String TotalPointsExpired) throws InterruptedException {

		BrowserUtils.enterText(reports.getReportColumn(), MemberID);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), MemberName);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), Email);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), PhoneNumber);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), SegmentTag);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), EnrollmentDate);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), Gender);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), Address);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), Tier);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), Status);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), DOB);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), PointsAvailable);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), PointsExpired);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), PointsRedeemed);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), LastTransaction);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalTransactions);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalPointsIssued);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalPointsRedeemed);
		BrowserUtils.submit(reports.getReportColumn());

		BrowserUtils.enterText(reports.getReportColumn(), TotalPointsExpired);
		BrowserUtils.submit(reports.getReportColumn());	

	}

	@When("user click on the Add Filters link")
	public void user_click_on_the_Add_Filters_link() throws InterruptedException {

		BrowserUtils.clickElement(reports.getAddFilters());
		Thread.sleep(1000);
	}


	@And("select the {string} filter")
	public void select_the_filter(String AppliedFilter) throws InterruptedException {
		reports.GetFilterandClick(AppliedFilter);
		Thread.sleep(1000);
	}

	@And("select operator {string} then enter values1 {string} and click Add Filter button")
	public void select_operator_then_enter_values1_and_click_Add_Filter_button(String operatorValue, String values) throws InterruptedException {
		BrowserUtils.enterText(reports.getOperator(), operatorValue);
		BrowserUtils.submit(reports.getOperator());

		BrowserUtils.enterText(reports.getInputValue1(), values);
		BrowserUtils.clickElement(reports.getClickAddFilterButton());

	}


	@And("Enter values1 {string} and click Add Filter button")
	public void Enter_value1_and_click_Add_Filter_button(String value1) {


	}
	/*

	@And("Enter values1 {string} and values2 {string} for operator {string}")
	public void Enter_value1_and_value2_for_operator(String inputvalue1, String inputvalue2, String operator ) throws InterruptedException {

		if (operator.equalsIgnoreCase("Is greater than or equal to") || operator.equalsIgnoreCase("Is")
				|| operator.equalsIgnoreCase("Is within") || operator.equalsIgnoreCase("Is not within")
				|| operator.equalsIgnoreCase("Is less than or equal to") || operator.equalsIgnoreCase("Equals to")) {

			BrowserUtils.enterText(reports.getInputValue1(), inputvalue1);
			Thread.sleep(1000);
			System.out.println("Before Add Filter click");
			BrowserUtils.clickElement(reports.getClickAddFilterButton());
			System.out.println("After Add Filter click");
		}
		else if (operator.equalsIgnoreCase("Is between")||operator.equalsIgnoreCase("Is not between")) {

			BrowserUtils.enterText(reports.getInputValue1(), inputvalue1);
			BrowserUtils.enterText(reports.getInputValue2(), inputvalue2);

			BrowserUtils.clickElement(reports.getClickAddFilterButton());
		}		

	}

	 */

	@And("click on apply filter button and validate the filters")
	public void click_on_apply_filter_button_and_validate_the_filters() throws InterruptedException {

		BrowserUtils.clickElement(reports.getApplyFilter());
	}



	//LOGS SECTION

	@When("user click on the logs section and search the file name by entering from date as {string} and to date as {string}")
	public void user_click_on_the_logs_section_and_search_the_file_name_by_entering_from_date_as_and_to_date_as(String StartDate, String EndDate) throws InterruptedException {
		BrowserUtils.clickElement(reports.getLogsSection());

		//Use this code to perform scroll on application

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,550)", "");
		BrowserUtils.ClearAndEnterText(reports.getStartDate(), StartDate);
		BrowserUtils.ClearAndEnterText(reports.getEndDate(), EndDate);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,550)", ""); 

	}

	@And("user search the file name as {string} and validate the result")
	public void user_search_the_file_name_as_and_validate_the_result(String SearchByFileName) throws InterruptedException {

		BrowserUtils.enterText(reports.getSearchByFileName(), SearchByFileName);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,550)", "");

		String  actualresult=reports.SearchFilenameValidate(SearchByFileName);

		Assert.assertEquals(actualresult, SearchByFileName);

	}

	@When("user selects {string} section")
	public void user_selects_section(String Section) throws InterruptedException{

		if(Section.equalsIgnoreCase("Transactional")) {	
			
			BrowserUtils.clickElement(reports.getTransactionalSection());
			
		}else if(Section.equalsIgnoreCase("Members")) {

			BrowserUtils.clickElement(reports.getMembersSection());

		}else if(Section.equalsIgnoreCase("Communication")) {

			BrowserUtils.clickElement(reports.getCommunicationSection());


		}

	}	

	@And("download the {string} report")
	public void download_the_reportn(String PeriodOfGeneration) throws InterruptedException{

		// Use this code if you want to download the daily report from the preview section

		/*

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(1000);

		BrowserUtils.clickElement(reports.getDownloadPreviewLink());

		 */

		// Use Use this code if you want to download the daily/weekly/monthly report from the calender

		BrowserUtils.clickElement(reports.getDownloadReportButton());

		if(PeriodOfGeneration.equalsIgnoreCase("Daily")) {
			BrowserUtils.enterText(reports.getTimeInterval(), PeriodOfGeneration);
			BrowserUtils.submit(reports.getTimeInterval());

			BrowserUtils.clickElement(reports.getSelectDate());
			BrowserUtils.clickElement(reports.getSelectCurrentDate());

		} else if (PeriodOfGeneration.equalsIgnoreCase("Weekly")) {
			BrowserUtils.enterText(reports.getTimeInterval(), PeriodOfGeneration);
			BrowserUtils.submit(reports.getTimeInterval());

			BrowserUtils.clickElement(reports.getSelectWeek());
			BrowserUtils.clickElement(reports.getSelectCurrentWeek());

		} else if (PeriodOfGeneration.equalsIgnoreCase("Monthly")) {
			BrowserUtils.enterText(reports.getTimeInterval(), PeriodOfGeneration);
			BrowserUtils.submit(reports.getTimeInterval());

			BrowserUtils.clickElement(reports.getSelectMonth());
			BrowserUtils.clickElement(reports.getSelectCurrentMonth());

		}  else if (PeriodOfGeneration.equalsIgnoreCase("Quarterly")) {
			BrowserUtils.enterText(reports.getTimeInterval(), PeriodOfGeneration);
			BrowserUtils.submit(reports.getTimeInterval());

			BrowserUtils.clickElement(reports.getSelectDate());

		}  else if (PeriodOfGeneration.equalsIgnoreCase("Yearly")) {
			BrowserUtils.enterText(reports.getTimeInterval(), PeriodOfGeneration);
			BrowserUtils.submit(reports.getTimeInterval());

			BrowserUtils.clickElement(reports.getSelectDate());
		}

		BrowserUtils.clickElement(reports.getClickDownloadButton());
	
 
		Thread.sleep(1000);
		//Use this code if No records found error message
		System.out.println("The error message is: " +reports.getNoRecordFound().getText());
		
		//Use this code if you want to come back after view the report
		BrowserUtils.clickElement(reports.getbackButtonArrow());

	}	
	
	@And ("verify the recently downloaded {string} file")
	public void verify_the_recently_downloaded_file(String ReportName) {
		
	Assert.assertTrue(BrowserUtils.isFileDownload("abc", "csv", 5000));
		
		
		
		
	}

}



