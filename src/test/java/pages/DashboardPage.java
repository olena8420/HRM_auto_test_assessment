package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.HelperMethods;

import java.util.List;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h6[text()='Dashboard']")
    public WebElement dashboardText;

    @FindBy(xpath = "//ul[@class='oxd-main-menu']/li")
    public List<WebElement> dashboardMenu;


    public void verifyDashboardText (String expectedDashboardText) {
        String actualUsernameHeader = dashboardText.getText();
        Assert.assertEquals("Username header verification failed!",
                expectedDashboardText, actualUsernameHeader);
    }

    public void clickDashboardMenu(String dashboardOption){

        for(WebElement option : dashboardMenu ){
            if(option.getText().equals(dashboardOption)){
                option.click();
                break;
            }
        }
    }



}



