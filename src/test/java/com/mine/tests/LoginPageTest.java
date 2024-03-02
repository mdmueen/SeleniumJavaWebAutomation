package com.mine.tests; // This package contains all test cases

import com.mine.driver.DriverManager;
import com.mine.utils.ReadPropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public final class LoginPageTest extends BaseTest {

    private LoginPageTest(){ }

    @Test()
    public void test1() throws Exception {

        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), 10);
        By headerMenu_InputForms = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Input Forms')]");
        By subMenu_InputForms_SimpleFormDemo = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Input Forms')]/following-sibling::ul/li[1]/a");
        // By subMenu_InputForms_CheckboxDemo = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Input Forms')]/following-sibling::ul/li[2]/a");

        // below is another xpath for above element using normalize-space() method of xpath
        By subMenu_InputForms_CheckboxDemo = By.xpath("//ul[@class='dropdown-menu']//a[normalize-space()='Checkbox Demo']");
        By subMenu_InputForms_RadioButtonsDemo = By.xpath("//ul[@class='dropdown-menu']//a[normalize-space()='Radio Buttons Demo']");

        DriverManager.getDriver().get(ReadPropertyFile.getValue("Url"));
        System.out.println(DriverManager.getDriver().getTitle()); // have some assertion whether landing page is opened as expected or not

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(headerMenu_InputForms)).click();
        DriverManager.getDriver().findElement(subMenu_InputForms_SimpleFormDemo).click();
        System.out.println(DriverManager.getDriver().getTitle());

        DriverManager.getDriver().findElement(headerMenu_InputForms).click();
        DriverManager.getDriver().findElement(subMenu_InputForms_CheckboxDemo).click();
        System.out.println(DriverManager.getDriver().getTitle());

        DriverManager.getDriver().findElement(headerMenu_InputForms).click();
        DriverManager.getDriver().findElement(subMenu_InputForms_RadioButtonsDemo).click();
        System.out.println(DriverManager.getDriver().getTitle());
    }
}
