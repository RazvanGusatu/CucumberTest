Feature: Test login functionality

  Scenario Outline: Check login is successful with valid credentials
    Given browser has been open
    And user is on login page
    When user enters <username> and <password>
    And user clicks on login
    Then user is navigated to the home page

    Examples: 
      | username | password |
      | Gabriel  |    12345 |
      | Razvan   |    12345 |
