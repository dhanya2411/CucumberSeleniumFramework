#Author: Dhana Lakshmi Krishna

@FunctionalTest
Feature: Google Account Home Feature

@SmokeTest @RegressionTest @End2End
  Scenario: Google Account Home Test
  Given Login and Navigate to Home Page
  Then Home Page Welcome texts are verified
  And Browser is closed for Home Test

@SmokeTest @RegressionTest @End2End
  Scenario: Google Account Home - Add Recovery Details
  Given Login and Navigate to Home Page
  Then Add Recovery Details as Phone Number equals to "4377331160" and Address equals to "ABC"
  And Browser is closed for Home Test
   
@SmokeTest @End2End
  Scenario Outline: Google Account Home - Add Recovery Details using Examples keyword
  Given Login and Navigate to Home Page
  Then Add Recovery Details using Examples as Phone Number equals to "<Phone>" and Address equals to "<Address>"
  And Browser is closed for Home Test
  
  Examples:
  
  | Phone      | | Address        |
  | 4377331160 | | 6 Rotunda St   |
  | 5136789012 | | 75 Mc Murchy   |
  | 4324567890 | | 18 Withers Way |
  
@SmokeTest @End2End
  Scenario: Google Account Home - Add Recovery Details using Data Table
  Given Login and Navigate to Home Page
  Then Add Recovery Details using Data Table
  | 4377331160 | 6 Rotunda St   |
  | 5136789012 | 75 Mc Murchy   |
  | 4324567890 | 18 Withers Way |
  And Browser is closed for Home Test
  
@SmokeTest @End2End
  Scenario: Google Account Home - Add Recovery Details using Maps
  Given Login and Navigate to Home Page
  Then Add Recovery Details using Maps
  | Phone      |  Address       |    
  | 4377331160 | 6 Rotunda St   |
  | 5136789012 | 75 Mc Murchy   |
  | 4324567890 | 18 Withers Way |
  And Browser is closed for Home Test
  