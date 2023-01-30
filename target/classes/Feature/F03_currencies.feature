@smoke
Feature: Euro currency



  Scenario:  verify Euro Symbol
    Given user open browser for currency
    And User Select Symbol
    Then verify Symbol contains Euro
