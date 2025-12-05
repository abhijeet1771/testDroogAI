Feature: User Authentication
  As a user
  I want to log in to my account
  So that I can access my files and folders

  Background:
    Given I am on the login page

  Scenario: User successfully logs in with valid credentials
    When I enter my email address "user@example.com"
    And I enter my password "password123"
    And I submit the login form
    Then I should be redirected to the dashboard
    And I should see my account information

  Scenario: User cannot log in with invalid credentials
    When I enter my email address "invalid@example.com"
    And I enter my password "wrongpassword"
    And I submit the login form
    Then I should see an error message "Invalid credentials"
    And I should remain on the login page

  Scenario Outline: User logs in with different account types
    Given I am on the login page
    When I enter my email address "<email>"
    And I enter my password "<password>"
    And I submit the login form
    Then I should see "<expected_page>"

    Examples:
      | email              | password    | expected_page |
      | admin@example.com  | admin123    | Admin Panel   |
      | user@example.com   | user123     | Dashboard     |

