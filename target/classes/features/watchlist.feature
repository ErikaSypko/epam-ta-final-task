Feature: watchlist
  As a user
  I want to have a possibility to save items that I liked
  So I can save viewed items

  Scenario Outline: Save several items to the watchlist
    Given User opens '<homePage>' page
    When User holds the mouse over the Shoes button
    And User checks Boots button visibility
    And User clicks Boots button
    And User saves for later first boots
    And User saves for later second boots
    And User clicks Watchlist button
    And User waits until watchlist page completely loads
    And User waits until visibility count of saved items
    Then User should see all items that user added ('<isAllItemsShowed>') to the watchlist

    Examples:
      | homePage                    | isAllItemsShowed |
      | https://www.asos.com/women/ | true             |