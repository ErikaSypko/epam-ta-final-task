Feature: Search
  As a user
  I want to search for items
  So that I can find what I’m looking for

  Scenario Outline: Search for an item
    Given User opens '<homePage>' page
    When User enters what user wants to find '<searchText>'
    And User clicks Search button
    Then User checks that URL contains '<searchText>'

    Examples:
      | homePage                    | searchText                                  |
      | https://www.asos.com/women/ | Asos Design Petite Long Sleeve Tiered Smock |
      | https://www.asos.com/women/ | ASOS Weekend Collective oversized gilet     |


