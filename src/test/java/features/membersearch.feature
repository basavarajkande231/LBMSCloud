Feature: Member search feature

@MembersSmoketest1 @RegressionTest1
Scenario: Profile click and Program selection
#Adding these 2 lines beacuse from profile page select the mentioned program and continue the execution
Then click on the profile section
Then select the program "A program four"

@MembersSmoketest1 @RegressionTest1
Scenario Outline: Navigate to member search module, enter different search string and validate the result
Given Naviagte to member search module
When enter different search "<types>" and "<options>"
Then click on the first search result
Then Validate the following details "<types>" and "<options>"  
 
Examples:
|types 				 | options 						 |
|name 				 | MRF 01 						 |
|member_ref_no | MRF01 							 |
|mobile 			 | 9036820287 				 |
|email 				 | pramod.brs@xoxoday.com |

@MembersSmoketest1 @RegressionTest1
Scenario Outline: issue manual credit/debit points
Given Naviagte to member search module
When search member "MRF01"
Then click on the first search result
Then click on Actions
Then issue manual "<Transaction Type>" point of "<Points>" with "<Description>"

Examples:
| Transaction Type| Points | Description |
| Debit					  | 25		 | TestDebit	 |
| Credit 				  | 60 		 | TestCredit  |

@MembersSmoketest1 @RegressionTest1
Scenario: Suspend member
Given Naviagte to member search module
When search member "MRF01"
Then click on the first search result
Then click on Actions
Then click on suspend and confirm

@MembersSmoketest1 @RegressionTest1
Scenario: Re-Actiavte member
Given Naviagte to member search module
When search member "MRF01"
Then click on the first search result
Then click on Actions
Then click on Re-Activate

@MembersSmoketest1 @RegressionTest1
Scenario: Check Audit log for a member
Given Naviagte to member search module
When search member "MRF01"
Then click on the first search result
And click on Audit_log

@MembersSmoketest1 @RegressionTest1
Scenario: Search transactions for member using date range
Given Naviagte to member search module
When search member "MRF01"
Then click on the first search result
And Enter "11/30/2023" "12/29/2023" and click on Search

#Scenarios related to manage member attributes

@MembersSmoketest1 @RegressionTest1
Scenario: Navigate to member search and click on manage attribute link
Given Naviagte to member search module
When click on manage member attributes link

@MembersSmoketest1 @RegressionTest1
Scenario Outline: Create different member attributes using manage_member_attribute 
When click on Add new custom attribute link
Then Enter value "<Attribute_Name>" "<API_Key>" "<Data_Type>" "<Mandatory>" "<Unique>"
#And click on cancel/save button

Examples:
|Attribute_Name | API_Key 	 | Data_Type | Mandatory | Unique |
|String_FF 			| String_FF  | String		 | false 		 | false  |
|Number_TF 			| Number_TF  | Numbers	 | false     | true   |
|DATE_FT 				| DATE_FT 	 | Date      | true      | false  |
|decimal_TT 		| decimal_TT | Decimals	 | true      | true   |


