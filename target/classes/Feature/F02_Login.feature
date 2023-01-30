@smoke
Feature: users could use login functionality to use their accounts

  Background: user open browser and navigates to login page
    Given user open browser
    And user navigates to login page



  Scenario:  User login with valid username and password
    When user enter "abdosobhy18220@gmail.com" and "123456" then click on login button
    Then user could login successfully to the home page


  Scenario:   user could login with invalid email and password
    When user enter "abdosobhy@gmail.com" and "123456" then click on login button
    Then  user could not login to the system





##Test Scenario 2
#  Scenario:  User shall reset his/her password
##test steps
#    When user click on forgot password
#    And user redirected to reset page
#    And user enter his valid mail then click recover button
##expected result
#    Then reset mail should be sent to user

