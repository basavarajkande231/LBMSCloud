Feature: Add new program & platform configuration

@ZConfigurationSmoketest1
Scenario Outline: Test and verify Add new program
Then click on the profile section
Then click on Add new program
Then Add "Automation" "Program" "automation@gmail.com" "+91" "9860979070"
Then Click on continue button

@ZConfigurationSmoketest1
Scenario Outline: Test and verify Add company deatils
Then Add company deatils "Automation" "Automation.com" "Pune" "South" "India"
Then Click on continue button


@ZConfigurationSmoketest1
Scenario Outline: Test and verify Add Program details
Then Add Program name
Then Add Program Logo
Then Select Base Currency "₹ - Indian Rupees"
Then Click on continue button


@ZConfigurationSmoketest1
Scenario Outline: Test and verify Points Configuration details
Then Add Points Terminology as "1" "11" "1"
Then Select Point Expiration Period as "Quarterly"
Then Add Cashback Rate "10.7" Customer Purchase Rate "5.5" Redemption Rate "10"
Then Click on Create program
Then Click on Done

@ZConfigurationSmoketest1
Scenario Outline: Test and Select newly created program & Verify Configurations details
When click on the profile section
Then Click on recently created program
Then Click on Configurations
Then Click on Organisation
Then Edit basic details As "NewProgram" "Program" "www@xoxoday.com" "9545002222"
Then Edit company details As "NewProgram" "Program" "www@xoxoday.com" "9545002222"
When Click on Program
Then Verify Program Name
Then Click on Program Details try to edit then cancel "XYZ"
Then Click on Point Definition try to edit then cancel "Point" "Points" "1.5" "0.5" "0.10"
Then Click on Marketplace
Then Click on Communication try to edit then cancel "Xoxoday" "xoxoday@xoxoday.com"














