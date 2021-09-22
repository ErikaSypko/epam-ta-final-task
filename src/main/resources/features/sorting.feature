Feature: Sorting system
  As a user
  I want to have sorting system
  So that I can sort items

  Scenario Outline: Sort items by price from high to low
    Given User opens '<homePage>' page
    Then User holds the mouse over the Shoes button
    And User checks Boots button visibility
    And User clicks Boots button
    And User clicks Sort button
    And User clicks Price From High To Low button
    And User waits until boots page completely loads
    Then User checks if price sorted

    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |
