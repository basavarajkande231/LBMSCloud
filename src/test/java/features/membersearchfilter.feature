Feature: Member search filter feature

@MemberSearchFilterSmoketest1
Scenario Outline: Apply any single filter with its respective operator and do a search  
Given Naviagte to member search module
When click on filter option

#Filters and their respective operators used in the application					
#Enrollment Date->	Is,	Is between,	Is not between,	Is within,	Is not within
#Points Available->	Is greater than or equal to,	Is less than or equal to,	Equals to,	Is between	
#Last Transaction->	Is,	Is between,	Is not between,	Is within,	Is not within
#Total Transactions->	Is greater than or equal to,	Is less than or equal to,	Equals to,	Is between	
#Age->	Is greater than or equal to,	Is less than or equal to,	Equals to,	Is between	
#Address->	Contains,	Does not contain		
	
Then select "Age" filter
Then Select operator "Is less than or equal to"
Then Enter value1 "40" and value2 "2023-09-09" for operator "Is less than or equal to"
Then click on apply filter button and validate the result

