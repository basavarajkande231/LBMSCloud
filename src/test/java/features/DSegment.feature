Feature: Segment Module

@SegmentSmoketest1 @RegressionTest1
Scenario: Create a new segment  
Given User navigates to segment module
When user clicks on the Enable Segment or Create segment button
And user enter the segment name as "Last Transaction is not between" and sagment tag as "seg two"
And select the "Last Transaction" as filter
#And select the operator "Is less than or equal to" then enter values1 "20"
And select operator "Is not between"
And enter first value as "2023-09-09" and second value as "2023-10-09" for operator "Is not between"
#And user add the multiple filters by click Add Filter button
#And select the "Enrollment Date" as filter
#And select operator "Is between"
#And enter first value as "2023-11-12" and second value as "2023-12-31" for operator "Is between"
And clicks on "Save" button
Then user should gets the success message as "Segment has been successfully Added"

@SegmentSmoketest1 @RegressionTest1
Scenario: View the recently created segment 
#Given User navigates to segment module
When user validate the recently created segment "Last Transaction is not between" and click on "View"

@SegmentSmoketest1 @RegressionTest1
Scenario: Edit the recently created segment 
#Given User navigates to segment module
When user validate the recently created segment "Last Transaction is not between" and click on "Edit"
And user enter the segment name as "Update Segment have Enrollment Date"
And select the "Enrollment Date" as filter
And select operator "Is between"
And enter first value as "2023-11-09" and second value as "2023-12-09" for operator "Is between"
And clicks on "Update" button
Then user should gets the success message as "Segment has been updated successfully"

@SegmentSmoketest1 @RegressionTest1
Scenario: Duplicate the recently created segment 
#Given User navigates to segment module
When user validate the recently created segment "Update Segment have Enrollment Date" and click on "Duplicate"
And user enter the segment name as "Segment ab" and sagment tag as "segment asbc"
And select the "Enrollment Date" as filter
And select operator "Is not between"
And enter first value as "2024-01-01" and second value as "2024-01-17" for operator "Is between"
And clicks on "Save" button
Then user should gets the success message as "Segment has been successfully Added"

@SegmentSmoketest1 @RegressionTest1
Scenario: Delete the recently created segment 
#Given User navigates to segment module
When user validate the recently created segment "Segment ab" and click on "Delete"
Then user should gets the success message as "Segment has been successfully deleted"
