package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TimePage {

    WebDriver driver;

    public TimePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item']")
    public List<WebElement> timeReportsMenu;

    @FindBy(xpath = "//ul[@class='oxd-dropdown-menu']/li")
    public List<WebElement> reportsDropdownMenu;

    @FindBy(xpath = "//div[@class='oxd-table-filter-header-title']")
    public WebElement projectReportHeader;

    @FindBy(xpath = "//div[contains(@class,'oxd-autocomplete-text-input oxd-autocomplete-text-input')]//input")
    public WebElement projectNameTextBox;

    @FindBy(xpath = "//input[@placeholder='From']")
    public WebElement projectDateRangeFromTextBox;

    @FindBy(xpath = "//input[@placeholder='To']")
    public WebElement projectDateRangeToTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement viewButton;

    @FindBy(xpath = "//div[@class='vertical-inner']//div[@class='rgRow']/div[@class='cell-action rgCell']")
    public List<WebElement> activityNameList;




    public void clickOnTimeReportMenu(String option){
        switch (option.trim()) {
            case "Timesheets":
                timeReportsMenu.get(0).click();
                break;
            case "Attendance":
                timeReportsMenu.get(1).click();
                break;
            case "Reports":
                timeReportsMenu.get(2).click();
                break;
            case "Project Info":

                timeReportsMenu.get(3).click();
                break;
            default:
                System.out.println("Time menu option not found");
        }

    }

    public void clickOnReportDropdownMenu(String option) {
        switch (option.trim()) {
            case "Project Reports":
                reportsDropdownMenu.get(0).click();
                break;
            case "Employee Reports":
                reportsDropdownMenu.get(1).click();
                break;
            case "Attendance Summary":
                reportsDropdownMenu.get(2).click();
                break;
            default:
                System.out.println("Report Dropdown Menu option not found");
        }
    }
}