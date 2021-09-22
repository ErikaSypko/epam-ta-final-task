Feature: Filtering System
  As a user
  I want to have a filtering system
  So I can see only interesting items for me

  Scenario Outline: Check that filtering works correctly
    Given User opens '<homePage>' page
    When User holds the mouse over the Shoes button
    And User checks Boots button visibility
    And User clicks Boots button
    And User clicks Price Range button
    And User changes minimum price ('<xToRight>', '<y>')
    And User clicks Price Range button
    And User changes maximum price ('<xToLeft>', '<y>')
    And User clicks Size button
    And User clicks Specific Size button
    And User clicks Colour button
    And User clicks Pink Colour button
    Then User clicks Price Range button
    And User checks applied price range ('<minPrice>', '<maxPrice>')
    And User clicks Size button
    And User checks that the specific filter name is specific size('<size>')
    And User checks count of selected filters ('<countFilters>')
    And User clicks Colour button
    And User checks that the specific filter name is specific color ('<color>')
    And User checks count of selected filters ('<countFilters>')

    Examples:
      | homePage                    | xToRight | xToLeft | y | minPrice | maxPrice | color | size  | countFilters |
      | https://www.asos.com/women/ | 100      | -50     | 0 | 135      | 290      | Pink  | EU 37 | 1 selected   |