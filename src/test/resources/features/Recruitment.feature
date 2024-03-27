@Recruitment @regression
Feature: This feature file validates Recruitment Page Functionality

  Background:
    Given user navigates to HRM Login Page
    When user enters valid username and password and clicks on login button
    And user should be able to verify dashboard name header "Dashboard" on HRM Homepage

  @smoke @wic @recruitment
  Scenario Outline: User should be able to add a new candidate on Recruitment Page on HRM
    Given user clicks "<an option>" on the Dashboard Menu on HRM page
    Then user click on AddButton on Recruitment Page
    And user fill out the first name "<firstName>", middle name "<middleName>" and last Name "<lastName>"
    Then user should be able to choose Vacancy dropdown "<vacancyOption>"
    And user should be able to add gmail "<email>" and contact number "<contactNumber>"
    Then user should be able to upload resume
    And user should be able to write keywords "<Keywords>" and notes "<notes>"
    Then user checks the consent to keep data and click on save button
    Then user verifies that the "<firstName>" "<lastName>" name is listed after saved
    Examples:
      |an option   | firstName | middleName | lastName| vacancyOption           |email              | contactNumber | Keywords| notes|
      |Recruitment | Olena     |            |  Mar    |                         | olena@gmail.com   |0123456789     | abcd    | notes|

  @smoke @negative
  Scenario Outline: User should be able to navigate to recruitment section and verify the details for added candidate
    Given user clicks "<an option>" on the Dashboard Menu on HRM page
    Then user verifies that the details for the added user "<firstName>" "<lastName>" or candidate match the data provided
    Then user verifies that the details for created user "<firstName>" "<lastName>" vacancy Option field is empty
    Examples:
      |an option   | firstName    |lastName        |
      |Recruitment | Olena        |Mar             |

  @delete
  Scenario Outline: User should be able to delete the candidate created during the test
    Given user clicks "<an option>" on the Dashboard Menu on HRM page
    When the user deletes the candidate with first name "<firstName>" "<lastName>"
    Then the candidate with first name "<firstName>" "<lastName>" should no longer exist in the system

    Examples:
      |an option  | firstName | lastName
      |Recruitment| Olena     | Mar