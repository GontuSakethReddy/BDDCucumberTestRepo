Feature: LoginFeature
Scenario:
Login with valid credentials

Given user is on login page
When  User enters valid login credentials
Then  User should be taken to next page