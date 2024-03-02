package com.mine.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public final class Driver {
    private Driver() { }

    //private static WebDriver driver;
    /*
    if we dont mention driver as static, it will lead to staleElementReferenceException while running tests in parallel.
    staleElementReferenceException means that the element is not there or spoilt in the DOM.
    I have commented the above declaration bcoz we now have implemented DriverManager with Thread Local
     */

    public static void initDriver(){
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup(); /* WebDriverManager is a class */
            //WebDriver driver = new ChromeDriver(); /* WebDriver is an interface extending SearchContext interface which has findElement & findElements methods. ChromeDriver is a class extending RemoteWebDriver class which implements WebDriver & JavaScriptExecutor interfaces. RemoteWebDriver class has almost all implementations of a driver like getTitle(), get() etc */
            DriverManager.setDriver(new ChromeDriver());
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManager.getDriver())){
            DriverManager.getDriver().quit();
            DriverManager.unloadDriver();
        }
    }
}
