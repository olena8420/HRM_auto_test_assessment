package step_definitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.BrowserFactory;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public WebDriver driver=null;
    @Before
    public void setUp(){
        driver= BrowserFactory.createInstance(ConfigurationReader.getProperty("ui-config.properties","BrowserType"));
        Driver.getInstance().setDriver(driver);
        driver=Driver.getInstance().getDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       // driver.manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
        Driver.getInstance().removeDriver();

    }
}
