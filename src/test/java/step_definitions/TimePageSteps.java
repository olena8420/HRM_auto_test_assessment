package step_definitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.TimePage;
import utilities.Driver;
import utilities.GenericHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TimePageSteps {

    WebDriver driver = Driver.getInstance().getDriver();
    TimePage timePage = new TimePage(driver);
    Actions actions = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private static final Logger oLog = LogManager.getLogger(GenericHelper.class);


    @When("user clicks {string} and {string}")
    public void user_clicks_and(String reports, String projectReports) {
        timePage.clickOnTimeReportMenu(reports);
        timePage.clickOnReportDropdownMenu(projectReports);
        oLog.info("User clicked on Reports and Project Reports on Time Page");
    }

    @Then("user should be able to see {string} header")
    public void user_should_be_able_to_see_header(String header) {
        String actualProjectReportHeader= timePage.projectReportHeader.getText();
        Assert.assertEquals("Project report header verification failed!",header,actualProjectReportHeader);
        oLog.info("Header validation passed. Expected: " + header + ", Actual: " + actualProjectReportHeader);



    }

    @Then("user query for {string} on the project name textbox")
    public void user_query_for_on_the_project_name_textbox(String projectName) throws InterruptedException {
        timePage.projectNameTextBox.clear();
        timePage.projectNameTextBox.sendKeys(projectName);

        js.executeScript("arguments[0].value='" + projectName + "';", timePage.projectNameTextBox);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.sendKeys(timePage.projectNameTextBox, Keys.DOWN).perform();
        actions.sendKeys(Keys.ENTER).perform();

        oLog.info("User queries for project name: " + projectName);
    }

    @Then("user includes time frame of {string} to {string} in you query")
    public void user_includes_time_frame_of_to_in_you_query(String from, String to) {
        timePage.projectDateRangeFromTextBox.click();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.DELETE).perform();
        timePage.projectDateRangeFromTextBox.sendKeys(from);

        timePage.projectDateRangeToTextBox.click();
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
        actions.sendKeys(Keys.DELETE).perform();
        timePage.projectDateRangeToTextBox.sendKeys(to);

        timePage.viewButton.click();
        oLog.info("User includes time frame: From " + from + " to " + to);

    }

    @Then("user validates the following activities are listed {string}:")
    public void user_validates_the_following_activities_are_listed(String expectedValues) {
        List<String> expectedValuesList = Arrays.asList(expectedValues.split(", "));
        List<String> actualValuesList = new ArrayList<>();

        for (int i=0; i<timePage.activityNameList.size(); i++) {
            actualValuesList.add(timePage.activityNameList.get(i).getText());
        }

        for (int j=0; j<expectedValuesList.size(); j++){
            System.out.println(actualValuesList.get(j));
            Assert.assertEquals("Activities list verification failed",expectedValuesList.get(j), actualValuesList.get(j));
        }
        oLog.info("Validation of activities passed on Time Page after querying for specific project");



    }
}