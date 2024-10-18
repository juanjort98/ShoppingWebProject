Feature: Registration and Logging in
    To Create and account in the webpage
    I should go to Men in nav bar and select, Tops and select jacket
    and select size of two products of the results and add them to the cart
    finally check that products appears correctly in shopping cart


    Scenario: open website
        Given user navigates to webpage


    Scenario: Create Account
        When user clicks on the create an Account link
        And fills the input field with information
            | Field Name            | Value       |
            | firstname             | <firstname> |
            | lastname              | <lastname>  |
            | email_address         | <email>     |
            | password              | <password>  |
            | password-confirmation | <password>  |
        And user clicks the Create an Account Button
        Then the account should be created successfully and the name should appear to the right of welcome

    Scenario: go to section Jackets in navigation var, select two products and add to shopping cart
        When the user navigates to the Jackets section by hovering over Men > Tops > Jackets
        And select two products, change color and size and add them to the shopping cart
        And user access shopping cart,
        Then selected products names must appear there




