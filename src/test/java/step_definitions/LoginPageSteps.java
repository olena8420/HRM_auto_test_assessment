package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.GenericHelper;

public class LoginPageSteps {
    WebDriver driver = Driver.getInstance().getDriver();
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    private static final Logger oLog = LogManager.getLogger(GenericHelper.class);

    @Given("user navigates to HRM Login Page")
    public void userNavigatesToHRMLoginPage() {
        String url = ConfigurationReader.getProperty("ui-config.properties", "HRMOrange.url");
        driver.get(url);
        oLog.info("User navigates to HRM Orange page");
    }
    @When("user enters valid username and password and clicks on login button")
    public void user_enters_username_and_password_and_clicks_on_login_button() {
       String username = ConfigurationReader.getProperty("ui-config.properties","HRMOrange.username" );
       String password = ConfigurationReader.getProperty("ui-config.properties","HRMOrange.password" );
        loginPage.login(username, password);
        oLog.info("User enters username and password and clicks on the login button");

    }
    @When("user enters invalid {string} username and {string} password and clicks on login button")
    public void userEntersInvalidUsernameAndPasswordAndClicksOnLoginButton(String username, String password) {
        loginPage.login(username, password);
        oLog.info("User enters invalid username and password and clicks on the login button");
    }
    @When("user should be able to verify dashboard name header {string} on HRM Homepage")
    public void user_should_be_able_to_verify_dashboard_name_header_on_HRM_Homepage(String expectedDashboardText) {
        dashboardPage.verifyDashboardText(expectedDashboardText);
        oLog.info("User verifies dashboard name header on HRM Homepage");

    }

    @When("user validates {string} error message")
    public void user_validates_error_message(String invalidCredentials) {
        loginPage.verifyErrorMessage(invalidCredentials);
        oLog.info("User validates error message");
    }
}