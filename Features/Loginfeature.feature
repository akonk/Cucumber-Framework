Feature: Login

  Scenario: Successful Login with valid credentials
    Given User Launch chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User Enter email id as "admin@yourstore.com" and  Password as "admin"
    And Click on Login
    Then Title should be "Dashboard / nopCommerce administration"
    When User Click on LogOut link
    Then Login Form Should be appeared and title Should be "Your store. Login"
    And Close the browser