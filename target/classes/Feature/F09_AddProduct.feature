@smoke
Feature: Logged user shall add product to shopping cart/wishlist/comparelist
Background:
    Given user open the browser
    And user navigates to the login page
    And user enter "abdosobhy18@gmail.com" and "123456" then click on login btn
    Then user logged in successfully to the home page


  Scenario:  Logged User shall add different products to shopping cart
    #first product
    When user enter "Apple MacBook Pro 13-inch" in search box
    And user click on product "Apple MacBook Pro 13-inch"
    And user click on add to cart button
    Then product "Apple MacBook Pro 13-inch" shall be added to cart
    #second product
    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to cart button
    Then product "First Prize Pies" shall be added to cart



  Scenario:  Logged User shall add different products to wishlist
    #first product
    When user enter "Apple MacBook Pro 13-inch" in search box
    And user click on product "Apple MacBook Pro 13-inch"
    And user click on add to wishlist button
    Then product "Apple MacBook Pro 13-inch" shall be added to wishlist
    #second product
    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to wishlist button
    Then product "First Prize Pies" shall be added to wishlist


  Scenario:  Logged User shall add different products to compareList
    #first product
    When user enter "Apple MacBook Pro 13-inch" in search box
    And user click on product "Apple MacBook Pro 13-inch"
    And user click on add to compareList button
    Then product "Apple MacBook Pro 13-inch" shall be added to compareList
    #second product
    When user enter "First Prize Pies" in search box
    And user click on product "First Prize Pies"
    And user click on add to compareList button
    Then product "First Prize Pies" shall be added to compareList