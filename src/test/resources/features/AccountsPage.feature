Feature: Accounts Page Feature

  Background:
    Given user is already logged into the application
      | username                     | password       |
      | dec2020secondbatch@gmail.com | Selenium@12345 |

  @accounts
  Scenario: Accounts page title
    Given user is on Accounts page
    When user gets the title of the page
    Then page title should be "My account - My Store"

  @accounts
  Scenario: Accounts section count
    Given user is on Accounts page
    Then user gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
      | Home                      |
    And accounts section count should be 6