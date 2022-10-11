Feature:Adding item to card and checkout

  Scenario: Test to validate user is able to add any item to card and checkout the item
    Given Go to the Website.
    When Navigate to Computer section.
    And  Click on Notebooks.
    And  Sort the items by Price Low to High and Display filter to maximum - 9.
    And  Get the results listed with Name and Price.
    And  Add any item to the cart, put assertion on the confirmation message displayed.
    And  Go to shoping cart page from Nav bar and verify item is added to cart.
    And  Click on check Out button on Shopping cart Page.
#    And  On SignIn page click on Register and register with any random email address.
#    And  Navigate to Shopping Cart button, increase the order Quantity to 4.
#    And  Fill up the shipping details.


