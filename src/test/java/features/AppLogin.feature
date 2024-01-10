Feature: Login

@AppLoginSmoketest1
Scenario: Intialize browser,login to the application
Given Login to the application using username and password
When validate if the title is "Giift LBMS"
Then click on the profile section
Then select the program "UseroqjhCTOR"
