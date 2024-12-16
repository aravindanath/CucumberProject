Feature: Add to Cart
  Scenario: Add one quantity from Store
    Given I'm on a store page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes"" in the cart
    And  I'm on a checkout page
    When I provide billing information
    And I placed the order
    And Order should be placed successfully
