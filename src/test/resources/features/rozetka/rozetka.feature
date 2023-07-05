@HomePage
Feature: Rozetka search testing
  In order to use Cucumber in my project, I want to check how to test Search page


  Scenario: User searches for a product
    Given User is on the Homepage
    And Check all element headerMenu are displayed
    When User searches for "brit care"
    Then Search page should contains title result "brit"

  Scenario Outline: Search some product with a different name
    Given User is on the Homepage
    And Check all element headerMenu are displayed
    When User searches for "<productName>"
    Then Search page should contains title result "<resultName>"


    Examples:
      | productName | resultName |
      | royal canin     | royal canin    |
      | purina one      | purina one     |
      | brit care      | brit care     |