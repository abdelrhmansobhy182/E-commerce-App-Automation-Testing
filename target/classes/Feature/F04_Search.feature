@smoke
Feature: search for product
Background:
  Given user open the browser
  And user navigates to the login page
  And user enter "abdosobhy18@gmail.com" and "123456" then click on login btn
  Then user logged in successfully to the home page

  Scenario:  Logged User could search for any product
    When user enter "Pride and Prejudice" in search box
    Then search results shall appear

