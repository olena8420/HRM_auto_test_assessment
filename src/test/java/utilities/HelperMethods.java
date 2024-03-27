package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HelperMethods {

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getInstance().getDriver();
        jse.executeScript("arguments[0].scrollIntoView()", element);
    }

    public static void SelectUsingValue(WebElement dropdown, String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);

    }
}
