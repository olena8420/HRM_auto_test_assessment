package step_definitions;

import org.openqa.selenium.WebDriver;
import pages.RecruitmentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DashboardPage;
import pages.RecruitmentPage;
import utilities.Driver;
import utilities.ExcelUtility;
import utilities.GenericHelper;
import utilities.WaitHelper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;


    public class RecruitmentPageSteps {
        WebDriver driver = Driver.getInstance().getDriver();
        RecruitmentPage recruitmentPage = new RecruitmentPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        private static final Logger oLog = LogManager.getLogger(GenericHelper.class);

        @Given("user clicks {string} on the Dashboard Menu on HRM page")
        public void user_clicks_on_the_Dashboard_Menu_on_HRM_page(String dashboardMenu) throws InterruptedException {
            dashboardPage.clickDashboardMenu(dashboardMenu);
            oLog.info("User clicks on Recruitment on the dashboard menu on Orange HRM");
        }

        @Then("user click on AddButton on Recruitment Page")
        public void user_click_on_AddButton_on_Recruitment_Page() {
            recruitmentPage.clickOnAddButton();

        }

        @Then("user fill out the first name {string}, middle name {string} and last Name {string}")
        public void user_fill_out_the_first_name_middle_name_and_last_Name(String firstName, String middleName, String lastName) throws Exception {
            // works from feature.file and Exel


            /* establishing the connection to the Excel file */
            String filePath = System.getProperty("user.dir") + "\\src\\test\\resources\\testData\\orangeHRMtestData.xlsx";
            ExcelUtility.setExcelFile(filePath, "Sheet1");
            /* retrieving data from excel file */
            firstName = ExcelUtility.getCellDataAsString(1, 1);
            middleName = ExcelUtility.getCellDataAsString(1, 2);
            lastName = ExcelUtility.getCellDataAsString(1, 3);
            System.out.println(firstName + " " + lastName);
            recruitmentPage.firstNameBoxText.sendKeys(firstName);
            recruitmentPage.middleNameBoxText.sendKeys(middleName);
            recruitmentPage.lastNameBoxText.sendKeys(lastName);
        }

        @Then("user should be able to choose Vacancy dropdown {string}")
        public void user_should_be_able_to_choose_Vacancy_dropdown(String vacancyDropdownOption) throws InterruptedException {
            recruitmentPage.vacancyDropDownBoxClick(vacancyDropdownOption);
        }

        @Then("user should be able to add gmail {string} and contact number {string}")
        public void user_should_be_able_to_add_gmail_and_contact_number(String email, String contactNumber) {
            recruitmentPage.emailBox.sendKeys(email);
            recruitmentPage.contactNumberBox.sendKeys(contactNumber);
            oLog.info("User adds email: " + email + " and contact number: " + contactNumber);

        }

        @Then("user should be able to upload resume")
        public void user_should_be_able_to_upload_resume() throws InterruptedException {

            String homeDirectory = System.getProperty("user.dir");

            String filePath = homeDirectory + "\\src\\test\\resources\\testData\\RESUME.docx";
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", recruitmentPage.browseButton2);
            recruitmentPage.browseButton2.sendKeys(filePath);
            oLog.info("User uploads a resume");

        }

        @Then("user should be able to write keywords {string} and notes {string}")
        public void user_should_be_able_to_write_keywords_and_notes(String keywords, String notes) throws InterruptedException {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            recruitmentPage.keywordsBox.sendKeys(keywords);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            recruitmentPage.dateOfApplicationBox.click();
            actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
            actions.sendKeys(Keys.DELETE).perform();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            recruitmentPage.notesBox.sendKeys(notes);
            oLog.info("User writes keywords: " + keywords +  " and notes: " + notes);

        }

        @Then("user checks the consent to keep data and click on save button")
        public void user_checks_the_consent_to_keep_data_and_click_on_save_button() throws InterruptedException {
            recruitmentPage.checkBox.click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            Thread.sleep(3000);
            recruitmentPage.saveButton.click();
               Thread.sleep(10000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            oLog.info("User checks the consent to keep data and clicks on the save button");

        }

        @Then("user verifies that the {string} {string} name is listed after saved")
        public void user_verifies_that_the_name_is_listed_after_saved(String expectedAccountName, String expectedAccountLastName) {
            WaitHelper.waitForVisibility(recruitmentPage.candidateName, 10);
            String actualAccountName = recruitmentPage.candidateName.getText();
            assertTrue(actualAccountName.contains(expectedAccountName) && actualAccountName.contains(expectedAccountLastName), "New Account Name Verification Failed");
            oLog.info("Verifying that the name or lastname is listed after saved");

        }

        @Then("user verifies that the details for the added user {string} {string} or candidate match the data provided")
        public void user_verifies_that_the_details_for_the_added_user_or_candidate_match_the_data_provided(String firstName, String lastName) throws InterruptedException {
            String nameInATable = recruitmentPage.findCandidate(firstName,lastName);
            assertTrue(nameInATable.contains(firstName) && nameInATable.contains(lastName), "Name verification failed!");
            oLog.info("Verifying that the details for the first name of added user or candidate match the data provided");

        }


        @Then("user verifies that the details for created user {string} {string} vacancy Option field is empty")
        public void userVerifiesThatTheDetailsForCreatedUserAndOrCandidateMatchTheDataProvided(String firstName, String lastName) throws InterruptedException {
            String actualVacancyColumn = recruitmentPage.vacancyOfCandidate(firstName, lastName);
            assertEquals(null, actualVacancyColumn, "Vacancy name verification failed!");
            oLog.info("Verifying that the vacancy name for the added user or candidate match the data provided");
        }


        @When("the user deletes the candidate with first name {string} {string}")
        public void theUserDeletesTheCandidateWithFirstName(String firstName, String lastname) throws InterruptedException {
            recruitmentPage.deleteAccount(firstName, lastname);
        }

        @Then("the candidate with first name {string} {string} should no longer exist in the system")
        public void theCandidateWithFirstNameShouldNoLongerExistInTheSystem(String firstName, String lastName) {


            List<WebElement> records = driver.findElements(By.xpath("//div[contains(text(),'" + firstName + "')]"));
            boolean isRecordDeleted = records.isEmpty();

            assertFalse(isRecordDeleted, "This record for '" + firstName + "' has not been deleted!");
            oLog.info("Verifying that the added candidate record has been deleted from the system");
        }
    }
