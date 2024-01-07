Feature: Reports feature
 
@ReportSettingsSmoketest1
Scenario: Change the reports settings accordingly 
Given User navigates to reports module
When user clicks on the settings
#Four Default Financial Year: 1st April - 31st March, 1st July - 30th June, 1st October - 30th September, 1st January - 31st December 
#Delay in generation is cannot more than 6 days
And user change the Financial Year to "1st July - 30th June" Week Starting on to "Monday" Delay in Generation "1" Days and Historical View as "10" Days
Then user should get the success message as "Setting saved sucessfully"

# TRANSACTIONAL SECTION

@TransactionalSmoketest1
Scenario: Create the accrual reports in the transactional section
Given User navigates to reports module
When user selects "transactional" and click on add new view and add the report name as "Spend points report"
And add the report column as "Transaction Id" "Transaction Amount" "Relation Reference" "Points Issued" "Transaction Date" "Processing Date" "Type" "Product Code" "Sub Product Code" "Narration" "Points Spoiled" "Merchant Name" "Transaction Count" "Impacted Members" "Total Points Issued" "Total Amount" "Total Points Spoiled"
And add the filter as "Credit by accrual" "Credit by bonus" "Debit By Bonus" "Debit By Cashback"
And select the period of generation as "Daily" "Weekly" "Monthly" "Quarterly" "Yearly"
#And add the "Narration" and "Memberid"
And clicks on the "Save" button
Then user should get the success message as "Report saved successfully"

@TransactionalSmoketest2
Scenario: View the recently created report in the transactional section
Given User navigates to reports module
When user validate the existing report "Accrual Report" and click on "View"
#Currently we have 5 reports generate options Daily, Weekly, Monthly, Quarterly and Yearly
And download the "Daily" report
And verify the recently downloaded "Spend points report" file


@TransactionalSmoketest1
Scenario: Delete the recently created accrual reports in the transactional section
When user validate the existing report "Spend points report" and click on "Delete"
Then user should get the success message as "Report deleted successfully"


# COMMUNICATION SECTION

@CommunicationReportSmoketest1
Scenario: Create the accrual reports in the transactional section
When user selects "Communication" and click on add new view and add the report name as "Email and SMS communication report"
And add the report column as "Template Name" "Email Status" "SMS Status" "Date Email/SMS Sent" "Communication Channel" "Member ID" "PhoneNumber" "Member Name" "Email" "Total Communication Sent" "Total Success Delivery" "Total Failed Delivery"
And add the filter as "SMS Communication Channel" "Email Communication Channel"
And select the period of generation as "Daily" "Weekly" "Monthly" "Quarterly" "Yearly"
#And add the "Narration" and "Memberid"
And clicks on the "Save" button
Then user should get the success message as "Report saved successfully"

@CommunicationReportSmoketest1
Scenario: View the recently created communication report in the communication section
When user validate the existing report "Email and SMS communication report" and click on "View"
#Currently we have 5 reports generate options Daily, Weekly, Monthly, Quarterly and Yearly
And download the "Daily" report

@CommunicationReportSmoketest1
Scenario: Delete the recently created accrual reports in the transactional section
When user validate the existing report "Email and SMS communication report" and click on "Delete"
Then user should get the success message as "Report deleted sucessfully"


# MEMBERS SECTION

@MembersReportSmoketest1
Scenario: Create the accrual reports in the transactional section
Given User navigates to reports module
When user selects "Members" and click on add new view and add the report name as "Members report"
And add the report column as "Member ID" "Member Name" "Email" "Phone Number" "Segment Tag" "Enrollment Date" "Tier" "Status" "DOB" "Gender" "Address" "Points Available" "Points Expired" "Points Redeemed" "Last Transaction" "Total Transactions" "Total Members" "Total Points Issued" "Total Points Redeemed" "Total Points Expired"
And select the period of generation as "Daily" "Weekly" "Monthly" "Quarterly" "Yearly"
And user click on the Add Filters link
And select the "Age" filter
And select operator "Is less than or equal to" then enter values1 "20" and click Add Filter button
#And Enter values1 "20" and values2 "40" for operator "Is between"
And click on apply filter button and validate the filters
#And add the "Narration" and "Memberid"
And clicks on the "Save" button
Then user should get the success message as "Report saved successfully"

@MembersReportSmoketest1
Scenario: View the recently created members reports in the Members section
When user validate the existing report "Members report" and click on "View"
#Currently we have 5 reports generate options Daily, Weekly, Monthly, Quarterly and Yearly
And download the "Daily" report

@MembersReportSmoketest1
Scenario: Delete the recently created accrual reports in the transactional section
When user validate the existing report "Members report" and click on "Delete"
Then user should get the success message as "Report deleted sucessfully"

# LOGS SECTION

@LogsSmoketest1
Scenario: View the logs by using search file name and select the require date and check the logs details
Given User navigates to reports module
When user click on the logs section and search the file name by entering from date as "11/25/2023" and to date as "01/01/2024"
And user search the file name as "1812202325p5TXN" and validate the result

@GenerateLiveReportSmoketest1
Scenario: Generate the live report
Given User navigates to reports module
When user validate the existing report "Members report" and click on "Generate"
And entering from date as "12/11/2023" and to date as "07/01/2024"




