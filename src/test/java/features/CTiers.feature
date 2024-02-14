Feature: Tiers feature
 
@TiersSmoketest1 @RegressionTest1
Scenario: Create a new tier  
Given User navigates to tier module
When user clicks on the Enable Tiers or Add a New Tier button
# currently we are using four icons as Bronze, Silver, Gold, Platinum
And User navigates to create new tier page and select the "Bronze" tier icon
And enter tier name as "Bronze" multiplier as "1.25" milestone as "100"  bonus as "10" and click "Launch"
Then user gets the success message as "Tiers has been successfully enabled"


@TiersSmoketest1 @RegressionTest1
Scenario: create second Tier  
When user clicks on the Enable Tiers or Add a New Tier button
# currently we are four icons as Bronze, Silver, Gold, Platinum
And User navigates to create new tier page and select the "Platinum" tier icon
And enter tier name as "Platinum" multiplier as "1.5" milestone as "1000"  bonus as "100" and click "Launch"
Then user gets the success message as "Tiers has been successfully enabled"


@TiersSmoketest1 @RegressionTest1
Scenario: Edit Tier  
Then user validates "Platinum" tier and clicks "Edit"
When User navigates to create new tier page and select the "Silver" tier icon
And enter tier name as "Silver" multiplier as "1.5" milestone as "500"  bonus as "50" and click "Update"
Then user gets the success message as "Tier Updated Successfully"


@TiersSmoketest2 @RegressionTest1
Scenario: Delete Tier 
Then user validates "Silver" tier and clicks "Delete"
Then user should navigate to tier lists page along with success message "Titanium" "tier has been successfully deleted"


@TiersSmoketest1 @RegressionTest1
Scenario: Tier Settings  
Given User navigates to tier module
When user change the tier settings timeframe
Then user gets the success message as "Tier Setting Updated Successfully"


