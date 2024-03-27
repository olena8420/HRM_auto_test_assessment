# HRM automation test assessment

Initial technical interview  assessment:
1. Login Test:
    - Navigates to the: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
    - Performs login using credentials stored in an ui-config.properties.file
2. Add User/Candidate Test:
    - Navigates to the recruitment section
    - Adds a new candidate or user with sample data using Excel file
    - Verifies successful addition
3. Verify User/Candidate Details Test:
    - Verify that the actual details of newly added candidate is equal to expected details
4. Project Time Report Test:
    - Navigates to the "Time reports" section
    - Queries for "Apache Software Foundation - ASF - Phase 1" within the specified time frame
    - Validates the listing of specific activities

**Introduction**: 
This is a hybrid test automation framework designed for UI testing. 
It incorporates Data Driven and Behavior Driven Development approaches.

**OVERVIEW**

The framework aims to be versatile and adaptable for various testing needs. It designed to be scalable and reliable, implementing various design
patterns such as Page Object Model (POM), Page Factory and Singleton. The framework includes a library of reusable utility classes and methods, 
facilitating BDD approach with Cucumber. Configuration is centralized in ui-config.properties for convenience. Key technologies and tools include 
Java, Maven, Selenium, JUnit, Cucumber, WebDriverManager, Log4j, along with capabilities to read from Excel files. 
In case of failure framework generates screenshot and attaches it to cucumber-report.

**PREREQUISITES** 

Ensure you have the following software installed:
Java (version 8 or newer)
Maven (3.7.0 or newer)
IntelliJ IDEA or another IDE of your choice

**FUNCTIONALITY**

The following flows were automated:
Test cases for Login Page
Test cases for Recruitment Page
Test cases for Time Reports Page

The project is structured as follows:

pom.xml file: Contains  project's configuration, dependencies, and build process.
src/test/java: Contains the test code, including step definitions, utility helping classes and runners
src/test/resources: Contains test resources like feature files and configuration properties
log: Contains log files generated during test execution

**BUILT WITH**

* Java - Programming language
* Maven - Dependency Management and build automation
* Selenium WebDriver - Web Automation Framework
* JUnit - Unit Testing Framework for Java applications
* Cucumber - BDD Framework
* Cucumber Reports - for generating readable test reports
* Apache POI - to read and write Excel files, aiding in Data-Driven Testing
* Lo4j - Logging Utility

**GETTING STARTED**

*Clone the Project and copy repository link
*Open IntelliJ IDEA (or your preferred IDE), select "New" ->  "Projects", and use the "Project from Version Control" option.
*Paste git url and press "Clone".

**RUNNING THE TESTS**

Navigate to the UITestRunner class located in the src/test/java/runner/UITestRunner  directory within the 'runner' folder.
Execute the class as a JUnit test.
The framework will run the tests as per the specified tags.

To run test suit from terminal use command:
### mvn clean "-Dtest=UITestRunner" verify

Run the with different browsers options:
mvn clean test -Dtest=UITestRunner -Dbrowser=chrome
mvn clean test -Dtest=UITestRunner -Dbrowser=safari
mvn clean test -Dtest=UITestRunner -Dbrowser=edge

Selective Test Execution:
The framework utilizes Cucumber tags to facilitate selective execution of tests.
Running All Tests:
The @regression tag is set up in the UITestRunner class for executing all regression tests, encompassing a thorough and 
extensive testing process.

Specific tags are assigned to each test scenario in the feature files. For instance:
Use @smoke for running smoke tests.
Use @recruitment to execute tests related to the recruitment functionality.
Use @negative to run only negative scenarious Although not initially part of the task, negative test scenarios were 
added to enhance the testing coverage.
To run a particular set of tests, modify the tags attribute in the @CucumberOptions annotation within the UITestRunner 
class to include the desired tag.

Reviewing Test Reports:
After the execution, Cucumber generates detailed reports which are saved in the target/cucumber folder.
These reports, available as HTML files, provide a clear and interactive interface for detailed test results analysis.

**IDENTIFIED BUGS AND ISSUES** 

During the testing process, the framework effectively identified key bugs:
Time Feature: Discovered a spelling error where "Support & Maintenance" was incorrectly spelled as "Support & Maintanance".
Recruitment Feature: Noted a data inconsistency issue - the vacancy option for a newly added candidate was unexpectedly blank.
Note: software is not stable, API server errors occur.


**SCREENSHOT OF CUCUMBER REPORT** 

To see a visual representation of test results, refer to the screenshot of the Cucumber HTML report

**ASSERTIONS**

Includes assertions to validate expected outcomes using JUnit testing framework.

**TEST DATA MANAGEMENT**

Utilizes external files (Excel) for managing test data
Implements data-driven testing for various scenarios.

**CLEAN-UP**

Features a clean-up mechanism to delete test data post-testing, ensuring a clean state.

Example of execution report:

![Screenshot 2024-03-26 203624](https://github.com/olena8420/HRM_auto_test_assessment/assets/164921889/c57ff12b-967d-42ae-aa9f-9722ffd4b6a5)


Failure screenshots are attached to cucumber reports:

![Screenshot 2024-03-26 203707](https://github.com/olena8420/HRM_auto_test_assessment/assets/164921889/590b01df-e9e4-49ba-846c-4369def206ff)

