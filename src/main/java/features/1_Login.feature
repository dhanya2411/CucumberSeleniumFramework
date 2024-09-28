#Author: Dhana Lakshmi Krishna

@FunctionalTest
Feature: Google Account Login Feature
 
@SmokeTest @RegressionTest @End2End  
  Scenario: Google Account Login Test
  Given User is able to navigate to Google Login Page URL
  When Title is Sign in - Google Accounts
  Then User enters ID
  Then User clicks on Next button
  Then User enters Password
  Then User clicks on Next button 
  Then User is on Home Page
  And Browser is closed for Login Test
  
@SmokeTest @RegressionTest @End2End   
  Scenario: Google Account Forgot Email Test
  Given User is able to navigate to Google Login Page URL
  Then Click on Forgot Email link
  Then Enter Recovery Email
  Then User clicks on Next button
  Then Enter Recovery Email Details
  Then User clicks on Next button 
  And Browser is closed for Login Test

@SmokeTest @RegressionTest @End2End   
  Scenario: Google Account Learn More About using Guest mode Test
  Given User is able to navigate to Google Login Page URL
  Then Verify Learn More link text 
  Then Click on Learn more about using Guest mode link
  And Browser is closed for Login Test
    
 

  