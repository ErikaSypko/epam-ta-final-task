Feature: cart
  As a user
  I want a cart
  So I can store items for later payment

  Scenario Outline: Add item to cart
    Given User opens '<homePage>' page
    When User holds the mouse over the Clothing button
    And User checks Skirts button visibility
    And User clicks Skirts button
    And User clicks Certain Skirts button
    And User clicks 'Size' button
    And User clicks to chosen size option
    And User clicks Add to Bag button
    And User waits until visibility Bag button
    And User holds the mouse over the Bag button
    Then User checks size of item
    And User checks name of item

    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |

  Scenario Outline: Increment the number of items in the cart
    Given User opens '<homePage>' page
    When User holds the mouse over the Clothing button
    And User checks Skirts button visibility
    And User clicks Skirts button
    And User clicks Certain Skirts button
    And User clicks 'Size' button
    And User clicks to chosen size option
    And User clicks Add to Bag button
    And User waits until visibility Bag button
    And User holds the mouse over the Bag button
    And User clicks View Bag button
    And User waits until visibility Quantity Items button
    And User clicks Quantity Items button
    And User clicks Certain Quantity Items button
    And User wait until clickable of Update button
    And User clicks Update button
    And User refreshed page
    And User waits until bag page completely loads
    And User waits until visibility Subtotal price
    And User waits until visibility Item Price
    Then User checks that price increments properly
    Examples:
      | homePage                    |
      | https://www.asos.com/women/ |




