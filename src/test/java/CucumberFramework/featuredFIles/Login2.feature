Feature: Login into account
	Existing user should be able to login to account using correct credentials
	
Scenario: Login into account with correct credentials2
Given User navigates to stackoverflow website2  
And User clicks on login button2 
And User enters a valid username2
And User enters a valid password2  
When User clicks on the login button2
Then User should be taken to the successful login page2 