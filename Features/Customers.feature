

Feature: Customers
Background: Steps common for all scenarios
Given User launch chrome browser
   
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password "admin"
    And click on Login
    Then User can view Dashboard

  

  
  Scenario: Add New Customer
    
    When User click on customers Menu
    And click on customres Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message"The new customer has been added successfully."
    And close browser
    
    
  Scenario: Search Customer by email
  
  When User click on customers Menu
  And click on customres Menu Item
  And Enter customer email
  When Click on search button
  Then User should found Email in the search table
  And close browser
  
  
  Scenario: Search Customer by Name
  
  When User click on customers Menu
  And click on customres Menu Item
  And Enter customer Firstname
  And Enter customer Lastname
  When Click on search button
  Then User should found Name in the search table
  And close browser
  
  
    
    
    

  
