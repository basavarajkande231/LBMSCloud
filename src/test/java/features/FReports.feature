Feature: Reports Module
 
@ReportSettingsSmoketest1 @Reports
Scenario: Change the reports settings accordingly 
Given User navigates to reports module
When user clicks on the settings
#Four Default Financial Year: 1st April - 31st March, 1st July - 30th June, 1st October - 30th September, 1st January - 31st December 
#Delay in generation is cannot more than 6 days
And user change the Financial Year to "1st July - 30th June" Week Starting on to "Monday" Delay in Generation "1" Days and Historical View as "100" Days
Then user should get the success message as "Setting saved sucessfully"

# TRANSACTIONAL SECTION

@TransactionalReportSmoketest1 @RegressionTest1 @Reports
Scenario: Create the accrual reports in the transactional section
Given User navigates to reports module
When user selects "transactional" and click on add new view and add the report name as "Spend points report"
And add the report column as "Transaction Id" "Transaction Amount" "Relation Reference" "Points" "Transaction Date" "Processing Date" "Type" "Product Code" "Sub Product Code" "Narration" "Points Spoiled" "Merchant Name" "Transaction Count" "Impacted Members" "Total Points Issued" "Total Amount" "Total Points Spoiled"
And add the filter as "Credit by accrual" "Credit by bonus" "Debit By Bonus" "Debit By Cashback"
And select the period of generation as "Daily" "Weekly" "Monthly" "Quarterly" "Yearly"
#And add the "Narration" and "Memberid"
And clicks on the "Save" button
Then user should get the success message as "Report saved sucessfully"
 
@TransactionalReportSmoketest2 @RegressionTest1 @Reports
Scenario: View the recently created report in the transactional section
Given User navigates to reports module
When user validate the existing report "Accrual Report" and click on "View"
#Currently we have 5 reports generate options Daily, Weekly, Monthly, Quarterly and Yearly
And download the "Daily" report
#And verify the recently downloaded "Accrual Report" file

@TransactionalReportSmoketest1 @RegressionTest1 @Reports
Scenario: Delete the recently created accrual reports in the transactional section
When user validate the existing report "Accrual Report" and click on "Delete"
Then user should get the success message as "Report deleted sucessfully"

# MEMBERS SECTION
 
@MembersReportSmoketest1 @RegressionTest1 @Reports
Scenario: Create the members reports in the Members section
Given User navigates to reports module
When user selects "Members" and click on add new view and add the report name as "Members report two"
And add the report column as "Relation Reference" "Segment Tag" "Enrollment Date" "Tier" "Status" "Activated Date" "Points Available" "Points Expired" "Points Redeemed" "Last Transaction" "Total Transactions" "Total Members" "Total Points Issued" "Total Points Redeemed" "Total Points Expired"
And select the period of generation as "Daily" "Weekly" "Monthly" "Quarterly" "Yearly"
And user click on the Add Filters link
And select the "Age" filter
And select operator "Is less than or equal to" then enter values1 "20" and click Add Filter button
#And Enter values1 "20" and values2 "40" for operator "Is between"
And click on apply filter button and validate the filters
#And add the "Narration" and "Memberid"
And clicks on the "Save" button
Then user should get the success message as "Report saved successfully"

@MembersReportSmoketest1 @RegressionTest1 @Reports
Scenario: View the recently created members reports in the Members section
When user validate the existing report "Members report" and click on "View"
#Currently we have 5 reports generate options Daily, Weekly, Monthly, Quarterly and Yearly
And download the "Daily" report
And verify the recently downloaded "Members report" file

@MembersReportSmoketest1 @RegressionTest1
Scenario: Delete the recently created members reports in the Members section
When user validate the existing report "Members report" and click on "Delete"
Then user should get the success message as "Report deleted sucessfully"

# COMMUNICATION SECTION

@CommunicationReportSmoketest1 @RegressionTest1 @Reports
Scenario: Create the communication reports in the Communication section
When user selects "Communication" and click on add new view and add the report name as "Email and SMS communication report"
And add the report column as "Template Name" "Email Status" "SMS Status" "Date Email/SMS Sent" "Communication Channel" "Member ID" "PhoneNumber" "Member Name" "Email" "Total Communication Sent" "Total Success Delivery" "Total Failed Delivery"
And add the filter as "SMS Communication Channel" "Email Communication Channel"
And select the period of generation as "Daily" "Weekly" "Monthly" "Quarterly" "Yearly"
#And add the "Narration" and "Memberid"
And clicks on the "Save" button
Then user should get the success message as "Report saved sucessfully"

@CommunicationReportSmoketest1 @RegressionTest1 @Reports
Scenario: View the recently created communication report in the Communication section
When user validate the existing report "Email and SMS communication report" and click on "View"
#Currently we have 5 reports generate options Daily, Weekly, Monthly, Quarterly and Yearly
And download the "Daily" report

@CommunicationReportSmoketest1 @RegressionTest1 @Reports
Scenario: Delete the recently created communication report in the Communication section
When user validate the existing report "Email and SMS communication report" and click on "Delete"
Then user should get the success message as "Report deleted sucessfully"

# LIABILITY SECTION

@LiabilityReportSmoketest1 @RegressionTest1 @Reports
Scenario: Generate from beginning to current month liability report
Given User navigates to reports module
When user selects "Liability" section and click on the Generate Custom Report
And select From Beginning and to date as "Feb" "2024"
And clicks on the "Generate" button
Then user should get the success message as "Your report is generated now"

@LiabilityReportSmoketest1 @RegressionTest1 @Reports
Scenario: Generate the current month liability report
#Given User navigates to reports module
When user selects "Liability" section and click on the Generate Custom Report
And select the from date as "Feb" "2024" and to date as "Feb" "2024"
And clicks on the "Generate" button
Then user should get the success message as "Your report is generated now"

@LiabilityReportSmoketest1 @RegressionTest1 @Reports
Scenario: Generate the from last year to current month liability report
When user selects "Liability" section and click on the Generate Custom Report
And select the from date as "May" "2023" and to date as "Feb" "2024"
And clicks on the "Generate" button
Then user should get the success message as "Your report is generated now"




# LOGS SECTION

@LogsSmoketest1 @RegressionTest1 @Reports
Scenario: View the logs by using search file name and select the require date and check the logs details
Given User navigates to reports module
When user click on the logs section and search the file name by entering from date as "11/25/2023" and to date as "01/01/2024"
And user search the file name as "1812202325p5TXN" and validate the result

@GenerateLiveReportSmoketest1 @RegressionTest1 @Reports
Scenario: Generate the live report
Given User navigates to reports module
When user validate the existing report "Accrual report" and click on "Generate"
And user enters the from date as "12/11/2023" and to date as "07/01/2024"
Then user should get the success message as "Your report is generated now"




