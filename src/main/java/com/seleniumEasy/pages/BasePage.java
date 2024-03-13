package com.seleniumEasy.pages;

import com.mine.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final WebDriver driver = DriverManager.getDriver();

    private static void explicitlyWaitForElementToBeClickable(By elementLocator){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(elementLocator));
    }

    private static void explicitlyWaitForElementToBeVisible(By elementLocator){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
    }

    private static void explicitlyWaitForElementToBeEnabled(By elementLocator){
        new WebDriverWait(driver, 10)
                .until(d -> d.findElement(elementLocator).isEnabled()); // using Java 8 Functional programming way
    }

    protected static void buttonClick(By buttonLocator){
        explicitlyWaitForElementToBeClickable(buttonLocator);
        driver.findElement(buttonLocator).click();
    }

    protected static void textboxSendKeys(By textboxLocator, String value){
        explicitlyWaitForElementToBeEnabled(textboxLocator);
        driver.findElement(textboxLocator).clear();
        driver.findElement(textboxLocator).sendKeys(value);
    }

    protected static void textboxSendKeys(By textboxLocator, int value){
        explicitlyWaitForElementToBeEnabled(textboxLocator);
        driver.findElement(textboxLocator).clear();
        driver.findElement(textboxLocator).sendKeys(String.valueOf(value));
    }

    protected static String getTextFromTextbox(By textboxLocator){
        explicitlyWaitForElementToBeEnabled(textboxLocator);
        return driver.findElement(textboxLocator).getText();
    }
}
