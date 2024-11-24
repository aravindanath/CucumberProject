Feature: Shopping Cart
  Scenario: Shopping Blue Shoes
    Given I'm on a store page
    When I add a "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes"" in the cart