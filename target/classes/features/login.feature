Feature: Log in
  As a registered user
  I want to be able to log in
  So I can access the features of a registered user

  Scenario Outline: Log in with valid credentials
    Given User opens '<homePage>' page
    When User holds the mouse over the account dropdown
    And User checks 'Sign in' button visibility
    And User clicks sign in button
    And User enters email address '<emailAddress>'
    And User enters password '<password>'
    And User clicks sign in button on login page
    And User waits until url is '<homePage>'
    And User waits until page completely loads
    And User holds the mouse over the account dropdown
    And User checks greeting message visibility
    Then User should see greeting message '<message>'

    Examples:
      | homePage                    | emailAddress              | password   | message |
      | https://www.asos.com/women/ | test.creds.asos@gmail.com | qwerty123! | Hi User |

  Scenario Outline: Log in with incorrect credentials
    Given User opens '<homePage>' page
    When User holds the mouse over the account dropdown
    And User checks 'Sign in' button visibility
    And User clicks sign in button
    And User enters email address '<emailAddress>'
    And User enters password '<password>'
    And User clicks sign in button on login page
    Then User should see warning message '<message>'

    Examples:
      | homePage                    | emailAddress              | password  | message                                  |
      | https://www.asos.com/women/ | test.creds.asos@gmail.com | qwerty123 | email address or password were incorrect |

  Scenario Outline: Log in with invalid credentials

    Given User opens '<homePage>' page
    When User holds the mouse over the account dropdown
    And User checks 'Sign in' button visibility
    And User clicks sign in button
    And User enters email address '<emailAddress>'
    And User enters password '<password>'
    And User clicks sign in button on login page
    Then User should see warning message that invalid data '<invalidEmail>'

    Examples:
      | homePage                    | emailAddress    | password  | invalidEmail |
      | https://www.asos.com/women/ | test.creds.asos | qwerty123 | Email fail!  |