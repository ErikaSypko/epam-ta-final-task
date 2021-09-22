Feature: Change currency
  As a user
  I want to have several currencies
  So that I can change currency

  Scenario Outline: Check currency switching
    Given User opens '<homePage>' page
    When User waits until visibility Country Selector button
    And User clicks Country Selector button
    And User waits until visibility Currency Selector button
    And User clicks Currency Selector button
    And User selects certain currency
    And User clicks Update Preferences button
    And User clicks Country Selector button
    And User clicks Currency Selector button
    Then User checks that properly currency is selected

    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |
