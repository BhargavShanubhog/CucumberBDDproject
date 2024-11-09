


Feature: Login

  
  Scenario: Successful Login with valid credentials
    Given User launch chrome browser
   
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password "admin"
    And click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store.Login"
    And close browser
    
    Scenario Outline: Successful Login with valid credentials DDT
    Given User launch chrome browser
   
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as <email> and Password <password>
    And click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store.Login"
    And close browser
    
 Examples:
   
  |email|password|
  |admin@yourstore.com|admin|
  |test@yourstore.com|admin|
   
    

  
