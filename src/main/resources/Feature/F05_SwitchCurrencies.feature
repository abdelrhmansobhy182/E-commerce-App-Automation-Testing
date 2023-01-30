@smoke
Feature: switch between currencies
Background:
  Given user open the browser
  And user navigates to the login page
  And user enter "abdosobhy18220@gmail.com" and "123456" then click on login btn
  Then user logged in successfully to the home page

  Scenario:  Logged User shall switch between currencies from US->Euro
    When user enter "Pride and Prejudice" in search box
    Then search results shall appear
    And user click on Currency dropdown list and choose US currency
    Then validate dealing with US currency
    And user click on Currency dropdown list and choose Euro currency
    Then validate dealing with Euro currency
