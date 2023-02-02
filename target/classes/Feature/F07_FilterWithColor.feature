@smoke
Feature: Logged User filtering in products
Background:
  Given user open the browser
  And user navigates to the login page
  And user enter "abdosobhy18@gmail.com" and "123456" then click on login btn
  Then user logged in successfully to the home page



  Scenario: Logged user shall filter with color
    When user go to specific category
    And filter category products by color
    Then products should be filtered successfully
