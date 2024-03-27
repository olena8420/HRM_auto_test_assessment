package utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private static final Logger oLog = LogManager.getLogger(WaitHelper.class);


    public static void wait(int secs) {
        try {
            Thread.sleep(1000 * secs);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntilClickable(WebElement element, int timeToWaitInSec){
        Wait wait = new WebDriverWait(Driver.getInstance().getDriver(), timeToWaitInSec);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance().getDriver(), timeToWaitInSec);
        wait.until(ExpectedConditions.visibilityOf(element));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


}


