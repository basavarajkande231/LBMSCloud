Feature: Campaign Module

@CampaignSmoketest1 @RegressionTest1
Scenario: Create a new campaign with only send points to existing members
Given User navigates to campaign module
When user clicks on the Create campaign button
And user enter the campaign name as "cam 4" target audience as "Recently Joined" and bonus points as "500"
And user select the "Send points to existing members."
And Schedule Campaign start date as "21 Jan 2024" and click on the Continue button
And user select the template as "PROMOTIONAL" and click on the Continue button
And user navigate to summary page and click on the "Create Campaign" button
Then user should gets the success toast message as "Campaign has been successfully Added"

@CampaignSmoketest1 @RegressionTest1
Scenario: Create a new campaign with send points to both existing and new members 
#Given User navigates to campaign module
When user clicks on the Create campaign button
And user enter the campaign name as "cam 5" target audience as "Suspended" and bonus points as "200"
And user select the "Send points to existing members." and "Send points to new members."
And Schedule Campaign start date as "25 Jan 2024" and end date as "31 Dec 2024" and click on the Continue button
And user select the template as "PROMOTIONAL" and click on the Continue button
And user navigate to summary page and click on the "Create Campaign" button
Then user should gets the success toast message as "Campaign has been successfully Added"

@CampaignSmoketest1 @RegressionTest1
Scenario: Edit the recently created campaign  
#Given User navigates to campaign module
When user validate the recently created campaign "cam 5" and click on "Edit"
And user enter the campaign name as "cam 6" and bonus points as "250" and click on the Continue button
And user select the template as "PROMOTIONAL" and click on the Continue button
And user navigate to summary page and click on the "Update Campaign" button
Then user should gets the success toast message as "Updated Campaign successfully"

@CampaignSmoketest1 @RegressionTest1
Scenario: Edit the recently created campaign  
#Given User navigates to campaign module
When user validate the recently created campaign "cam 6" and click on "View"

@CampaignSmoketest1 @RegressionTest1
Scenario: Duplicate the campaign with select Send points to existing members
#Given User navigates to campaign module
When user validate the recently created campaign "cam 6" and click on "Duplicate"
And user enter the campaign name as "cam 7" target audience as "Suspended" and bonus points as "350"
And user select the "Send points to existing members."
And Schedule Campaign start date as "21 Feb 2024" and click on the Continue button
And user select the template as "PROMOTIONAL" and click on the Continue button
And user navigate to summary page and click on the "Create Campaign" button
Then user should gets the success toast message as "Campaign has been successfully Added"

@CampaignSmoketest1 @RegressionTest1
Scenario: Duplicate the campaign with select Send points to both existing members and new members
#Given User navigates to campaign module
When user validate the recently created campaign "cam 7" and click on "Duplicate"
And user enter the campaign name as "cam 8" target audience as "seg 1" and bonus points as "250"
And user select the "Send points to existing members." and "Send points to new members."
And Schedule Campaign start date as "28 Feb 2024" and end date as "31 Mar 2024" and click on the Continue button
And user select the template as "PROMOTIONAL" and click on the Continue button
And user navigate to summary page and click on the "Create Campaign" button
Then user should gets the success toast message as "Campaign has been successfully Added"

#Currently not working this scenario
@CampaignSmoketest2 @RegressionTest1 
Scenario: Enable or Disable the recently created campaign  
#Given User navigates to campaign module
When user validate the recently created campaign "Campaign_2_16-01-2024" and change the campaign status
Then user should gets the success toast message as "Campaign disabled" 
#Campaign enabled successfully