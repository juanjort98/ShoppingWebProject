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
            | Field Name            | Value                 |
            | firstname             | Juan                  |
            | lastname              | Ramirez               |
            | email_address         | testemail98@gmail.com |
            | password              | Juanjoseqwa6#         |
            | password-confirmation | Juanjoseqwa6#         |
        And user clicks the Create an Account Button
        Then the account should be created successfully

