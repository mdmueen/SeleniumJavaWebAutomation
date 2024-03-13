package com.seleniumEasy.pages;

import com.mine.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public final class SimpleFormDemoPage extends BasePage{

    private final By textboxEnterValue1 = By.id("value1");
    private final By textboxEnterValue2 = By.id("value2");
    private final By buttonGetTotal = By.xpath("//button[contains(text(),'Get Total')]");
    private final By labelTotal = By.cssSelector("#displayvalue");

    public SimpleFormDemoPage(){
        HomePage.menuListNavigation("InputForms", "Simple Form Demo");
    }

    public SimpleFormDemoPage enterValue1(int value){
        textboxSendKeys(textboxEnterValue1, value);
        return this; // achieving method chaining by returning anonymous class object without reference by using - new SimpleFormDemoPage() or by using 'this' keyword
    }

    public SimpleFormDemoPage enterValue2(int value){
        textboxSendKeys(textboxEnterValue2, value);
        return this;
    }

    public void clickGetTotal(){
        buttonClick(buttonGetTotal);
    }

    public String getDisplayTotal(){
        return getTextFromTextbox(labelTotal);
    }

}
