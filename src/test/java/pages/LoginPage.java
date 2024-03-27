package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitHelper;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameTextInput;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[text()='Invalid credentials']") ////p[@class='oxd-text oxd-text--p oxd-alert-content-text']
    public WebElement errorMessageInvalidCr;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    public WebElement errorMessage2;


    public void login (String username, String password) {

        WaitHelper.waitUntilClickable(usernameTextInput,10);
        usernameTextInput.sendKeys(username);
        WaitHelper.waitUntilClickable(passwordTextInput,10);
        passwordTextInput.sendKeys(password);
        WaitHelper.waitUntilClickable(loginButton, 10);
        loginButton.click();
    }

    public void verifyErrorMessage (String expectedErrorMessage) {
        if (expectedErrorMessage.equals("Invalid credentials")) {
            String actualErrorMessage = errorMessageInvalidCr.getText();
            Assert.assertEquals("Error message validation failed!", expectedErrorMessage, actualErrorMessage);
        }else if (expectedErrorMessage.equals("Required")){
            String actualErrorMessage= errorMessage2.getText();
            Assert.assertEquals("Error message validation failed!", expectedErrorMessage, actualErrorMessage);
        }
    }
}