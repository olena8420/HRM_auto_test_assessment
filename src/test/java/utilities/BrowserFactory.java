package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.HashMap;

public class BrowserFactory {
    public static WebDriver createInstance(String browserType) {

        WebDriver driver = null;

        try {
            //if driver is null then instantiate, else return
            if (driver == null) {
                if(System.getProperty("browser")==null){
                    //if System.getProperty("browser") returns null, then setup Chromedriver - like default browser
                    WebDriverManager.chromedriver().setup();
                    //chromePrefs is key value combination and useful if you change default behavior of browser like download directory
                    HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                    chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\Downloads");
                    //chromeOptions are useful if you want to manage options specific to Chromediver - like ignoring certificate
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--ignore-ssl-errors=yes");
                    options.addArguments("--ignore-certificate-errors");
                    options.addArguments("--enable-javascript");
                    //and we can even add chromePrefs that we created in line 32 and additional preferences
                    options.setExperimentalOption("prefs", chromePrefs);
                    //need to create Chromedriver with preferences
                    driver = new ChromeDriver(options);
                } else {
                    //if System.getProperty("browser") returns value then based on value Switch case will be executed
                    switch (System.getProperty("browser")) {
                        case "chromeRemote":
                            //write code to set Remote Driver for Chrome
                        case "firefox":
                            WebDriverManager.firefoxdriver().setup();
                            driver = new FirefoxDriver();
                            break;
                        case "firefoxRemote":
                            //write code to set Remote Driver for Firefox
                        default:
                            WebDriverManager.chromedriver().setup();
                            driver = new ChromeDriver();
                            break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return driver;
    }
}