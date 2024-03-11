package com.seleniumEasy.pages;

import com.mine.driver.DriverManager;
import org.openqa.selenium.By;

public final class SimpleFormDemoPage {

    private final By textboxEnterValue1 = By.id("value1");
    private final By textboxEnterValue2 = By.id("value2");
    private final By buttonGetTotal = By.xpath("//button[contains(text(),'Get Total')]");
    private final By labelTotal = By.cssSelector("#displayvalue");

    public SimpleFormDemoPage(){
        HomePage.menuListNavigation("InputForms", "Simple Form Demo");
    }

    public SimpleFormDemoPage enterValue1(int value){
        DriverManager.getDriver().findElement(textboxEnterValue1).sendKeys(String.valueOf(value));
        return this; // achieving method chaining by returning anonymous class object without reference by using - new SimpleFormDemoPage() or by using 'this' keyword
    }

    public SimpleFormDemoPage enterValue2(int value){
        DriverManager.getDriver().findElement(textboxEnterValue2).sendKeys(String.valueOf(value));
        return this;
    }

    public void clickGetTotal(){
        DriverManager.getDriver().findElement(buttonGetTotal).click();
    }

    public String getDisplayTotal(){
        return DriverManager.getDriver().findElement(labelTotal).getText();
    }

}
