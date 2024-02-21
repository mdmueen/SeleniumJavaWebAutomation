package com.mine.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginPageTest {

    @Test
    public void test1(){
        By txtboxUsername = By.xpath("//input[@placeholder='Username']");

        WebDriverManager.chromedriver().setup(); /* WebDriverManager is a class */
        WebDriver driver = new ChromeDriver(); /* WebDriver is an interface extending SearchContext interface which has findElement & findElements methods. ChromeDriver is a class extending RemoteWebDriver class which implements WebDriver & JavaScriptExecutor interfaces. RemoteWebDriver class has almost all implementations of a driver like getTitle(), get() etc */
        WebDriverWait explicitWait = new WebDriverWait(driver, 10);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(txtboxUsername)).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");

        driver.quit();
    }
}
