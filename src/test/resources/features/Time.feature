@Time @regression
Feature: This feature file validates Time Page Functionality

  Background:
    Given user navigates to HRM Login Page
    When user enters valid username and password and clicks on login button
    And user should be able to verify dashboard name header "Dashboard" on HRM Homepage

  @smoke
  Scenario Outline: User should be able to View and Verify Project Time Report Page on HRM
    Given user clicks "Time" on the Dashboard Menu on HRM page
    When user clicks "Reports" and "Project Reports"
    Then user should be able to see "Project Report" header
    Then user query for "Apache Software " on the project name textbox
    And user includes time frame of "2021-01-01" to "2023-12-31" in you query
    And user validates the following activities are listed "<List>":
    Examples:
      | List |
      |Bug Fixes, Feature Development, Implementation, QA Testing, Requirement Gathering, Support & Maintenance |
#Found a bug. Expected is Support & Maintenance and actual is Support & Maintanance