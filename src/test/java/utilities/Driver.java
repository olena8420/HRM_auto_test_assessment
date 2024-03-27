package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//this is a class that follows singleton pattern by building constructor in private, static reference
//variable of the class to make it available globally, and the methods with return type as the object of the
//class
public class Driver {
    //private constructor, no objects can be created outside of this class
    private Driver() {
    }

    //private static reference variable to the class
    private static Driver instance = new Driver();

    //create a getter method with return type of the class
    public static Driver getInstance() {
        return instance;
    }

    //ThreadLocal is directed related to singleton.
    //Thread-local is responsible to keep track of the webdrivers that has been created by different threads
    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();// thread local driver object for webdriver

    //getDriver() method is the instance method of  driver class
    public WebDriver getDriver() {
        return driver.get();
    }

    //setDriver() method is the instance method of driver class
    public void setDriver(WebDriver driverParameter) {
        driver.set(driverParameter);
    }


    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}