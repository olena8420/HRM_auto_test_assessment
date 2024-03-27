package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.GenericHelper;
import utilities.HelperMethods;

import javax.swing.*;

public class RecruitmentPage {
    WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    public WebElement addButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameBoxText;

    @FindBy(xpath = "//input[@name='middleName']")
    public WebElement middleNameBoxText;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameBoxText;

    @FindBy(xpath = "//div[@class='oxd-select-text-input']")
    public WebElement vacancyDropdownBox;

    @FindBy(xpath = "(//div[@class='']/input)[4]")
    public WebElement emailBox;

    @FindBy(xpath = "(//div[@class='']/input)[5]")
    public WebElement contactNumberBox;

    @FindBy(xpath = "//div[@class='oxd-file-button']")
    public WebElement browseButton;

    @FindBy(xpath = "//input[@type='file']") //   //div[@class='oxd-file-button']
    public WebElement browseButton2;

    @FindBy(xpath = "//div[@class='oxd-file-input-div']")
    public WebElement uploadButton;

    @FindBy(xpath = "//input[@placeholder='Enter comma seperated words...']")
    public WebElement keywordsBox;

    @FindBy(xpath = "//*[contains(@placeholder, 'yyyy')]")
    public WebElement dateOfApplicationBox;

    @FindBy(xpath = "//textarea[@placeholder='Type here']")
    public WebElement notesBox;

    @FindBy(xpath = "//input[@type='checkbox']/..")
    public WebElement checkBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButton;

    @FindBy(xpath = "//label[text() ='Name']/../..//p")
    public WebElement candidateName;






    public void clickOnAddButton(){
        addButton.click();
    }

    public void vacancyDropDownBoxClick(String dropDownOption) throws InterruptedException {
        vacancyDropdownBox.click();
        Thread.sleep(5000);
        vacancyDropdownBox.sendKeys(dropDownOption);

    }

    public String findCandidate(String firstName, String lastName){
       return  driver.findElement(By.xpath("//div[contains(text(),'" + firstName + "')]")).getText();
    }


    public String vacancyOfCandidate(String firstName, String lastName){
        String actualVacancy = driver.findElement(By.xpath("(//div[contains(text(),'" + firstName + "')]/../../div)[2]/div")).getText();
        if(actualVacancy.contains(firstName) && actualVacancy.contains(lastName)){
            return actualVacancy;
        }else{
            System.out.println("Candidate not found");
            return null;
        }

    }


    public void deleteAccount(String firstName, String lastName) throws InterruptedException {
        String candidateActualName = findCandidate(firstName,lastName);
        boolean isTheAccountExisiting = candidateActualName.contains(firstName)&&candidateActualName.contains(lastName);
        if (isTheAccountExisiting){
            driver.findElement(By.xpath("//div[text()='"+ firstName +"']/../..//i[@class='oxd-icon bi-trash']")).click();
            driver.findElement(By.xpath("(//div[@class='orangehrm-modal-footer']//button)[2]")).click();
            Thread.sleep(5000);
        }
    }
}

