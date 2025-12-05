Feature: Test login functionality
  As a user I want to test login
  
  Scenario: Test login with credentials
    Given I am on login page
    When I click on email field
    And I type "user@example.com"
    And I click on password field
    And I fill "password123"
    And I click submit button
    Then I should see dashboard
    And I verify something is displayed

  Scenario: Test logout
    Given I am logged in
    When I click logout
    Then I verify stuff happens

  Scenario Outline: Test login with different users
    Given I am on login page
    When I type "<email>"
    And I fill "<password>"
    And I click submit
    Then I should see "<expected>"

