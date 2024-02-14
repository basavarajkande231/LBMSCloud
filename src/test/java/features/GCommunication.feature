Feature: Communication Module
 
@CommunicationsSmoketest1 @Communications
Scenario: Create the promotional template with both email and SMS channels
Given User navigates to communications module
When user clicks on the Create Template button
And user enters the template name as "promotional" and template type as "promotional"
And user setup the Email and user enter the email subject as "promotional subject" uplaod the title image and enter the email title as "promotional title" email body as "campaign bonus" button text as "Visit again" and button link is "www.abc.com"
And clicks on the "Save" button
And user setup the SMS and user enter the SMS Template ID as "promotional subject" and SMS body as "campaign bonus"
And clicks on the "Save" button
And click on "Create template" button

@CommunicationsSmoketest2 @Communications
Scenario: Create the promotional template with specific channel
Given User navigates to communications module
When user clicks on the Create Template button
And user enters the template name as "promotional two" and template type as "promotional"
And user setup the "Email" channel and disable the "SMS" channel
And user setup the Email and user enter the email subject as "promotional subject" uplaod the title image and enter the email title as "promotional title" email body as "campaign bonus" button text as "Visit again" and button link is "www.abc.com"
And click on "Create template" button

@CommunicationsSmoketest2 @Communications
Scenario: Create the promotional template with specific channel
Given User navigates to communications module
When user clicks on the Create Template button
And user enters the template name as "promotional three" and template type as "promotional"
And user setup the "SMS" channel and disable the "Email" channel
And user setup the SMS and user enter the SMS Template ID as "promotional subject" and SMS body as "campaign bonus"
And click on "Create template" button




