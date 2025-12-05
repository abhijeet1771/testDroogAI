Feature: DroogAI Comprehensive Feature Testing
  As a developer
  I want to verify that DroogAI correctly reviews code and compares with main/master branch
  So that I can trust DroogAI's code review capabilities

  Background:
    Given DroogAI is installed and configured
    And the test repository is accessible

  Scenario: DroogAI reviews PR and compares with main branch
    Given a pull request exists in the repository
    When I run DroogAI review with enterprise mode
    Then DroogAI should analyze all changed files
    And DroogAI should compare changes with main branch
    And DroogAI should detect duplicate code
    And DroogAI should identify breaking changes
    And DroogAI should find security issues
    And DroogAI should generate a comprehensive report

  Scenario: DroogAI detects code duplicates within PR
    Given a PR with duplicate code patterns
    When DroogAI reviews the PR
    Then DroogAI should detect within-PR duplicates
    And DroogAI should report duplicate similarity percentage

  Scenario: DroogAI detects cross-repository duplicates
    Given the repository is indexed
    When DroogAI reviews a PR
    Then DroogAI should detect cross-repo duplicates
    And DroogAI should compare with main branch code

  Scenario: DroogAI identifies breaking changes
    Given a PR with method signature changes
    When DroogAI reviews the PR
    Then DroogAI should detect breaking changes
    And DroogAI should identify impacted files
    And DroogAI should report call sites affected

  Scenario: DroogAI performs security analysis
    Given a PR with potential security issues
    When DroogAI reviews the PR
    Then DroogAI should detect security vulnerabilities
    And DroogAI should identify critical security issues
    And DroogAI should flag hardcoded secrets

  Scenario: DroogAI analyzes code quality
    Given a PR with code quality issues
    When DroogAI reviews the PR
    Then DroogAI should detect code smells
    And DroogAI should identify performance issues
    And DroogAI should suggest modern best practices

  Scenario: DroogAI posts comments to GitHub PR
    Given a PR with reviewable issues
    When I run DroogAI review with --post flag
    Then DroogAI should post inline comments
    And DroogAI should post comments on correct lines
    And DroogAI should include code suggestions

  Scenario: DroogAI generates confidence scores
    Given DroogAI reviews a PR
    When the review completes
    Then DroogAI should calculate confidence scores
    And confidence scores should be between 0 and 100

  Scenario: DroogAI provides AI-powered recommendations
    Given DroogAI completes a review
    When the report is generated
    Then DroogAI should provide strategic recommendations
    And recommendations should be prioritized by severity
    And recommendations should include actionable steps


