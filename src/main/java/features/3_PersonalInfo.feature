#Author: Dhana Lakshmi Krishna

@FunctionalTest
Feature: Google Account Personal Info Feature

@SmokeTest @End2End
  Scenario: Google Account Personal Info Test
  Given Login and Land on Home Page
  Then Click on Personal Info
  Then Personal Info Header texts are verified
  And Browser is closed for Personal Info Test

@SmokeTest @End2End
  Scenario: Google Account Personal Info - Basic Info
  Given Login and Land on Home Page
  Then Click on Personal Info
  Then Verify Basic Info 
  And Browser is closed for Personal Info Test
 
@SmokeTest @End2End  
  Scenario: Google Account Personal Info - Contact Info
  Given Login and Land on Home Page
  Then Click on Personal Info
  Then Verify Contact Info 
  And Browser is closed for Personal Info Test
  