package com.mine.tests; // This package contains all test cases

import com.mine.driver.DriverManager;
import com.mine.utils.ReadPropertyFile;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public final class LoginPageTest extends BaseTest {

    private LoginPageTest(){ }

    @Test()
    public void test1() throws Exception {

        WebDriverWait explicitWait = new WebDriverWait(DriverManager.getDriver(), 10); //WebDriverWait is a class which extends FluetWait class
        By headerMenu_InputForms = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Input Forms')]");
        By subMenu_InputForms_SimpleFormDemo = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Input Forms')]/following-sibling::ul/li[1]/a");
        // By subMenu_InputForms_CheckboxDemo = By.xpath("//a[@class='dropdown-toggle' and contains(text(),'Input Forms')]/following-sibling::ul/li[2]/a");

        // below is another xpath for above elements using normalize-space() method of xpath
        By subMenu_InputForms_CheckboxDemo = By.xpath("//ul[@class='dropdown-menu']//a[normalize-space()='Checkbox Demo']");
        By subMenu_InputForms_RadioButtonsDemo = By.xpath("//ul[@class='dropdown-menu']//a[normalize-space()='Radio Buttons Demo']");

        DriverManager.getDriver().get(ReadPropertyFile.getValue("Url"));
        String title_LandingPage = DriverManager.getDriver().getTitle(); // have some assertion whether landing page is opened as expected or not
        Assertions.assertThat(title_LandingPage)
                .isNotNull()
                .containsIgnoringCase("best demo website"); // Assertions is a class in AssertJ library with overloaded assertThat() methods

        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(headerMenu_InputForms)).click();
        DriverManager.getDriver().findElement(subMenu_InputForms_SimpleFormDemo).click();
        String title_SimpleFormPage = DriverManager.getDriver().getTitle();

        Assertions.assertThat(title_SimpleFormPage)
                .containsIgnoringCase("Simple Form");
        Assert.assertTrue(title_SimpleFormPage.toLowerCase().contains("simple form")); // TestNG assertion for the above AssertJ assertion. For TestNG assertion we need to give all in lower case or upper case

        DriverManager.getDriver().findElement(headerMenu_InputForms).click();
        DriverManager.getDriver().findElement(subMenu_InputForms_CheckboxDemo).click();
        String title_CheckBoxDemoPage = DriverManager.getDriver().getTitle();

        /*SoftAssertions softlyAssert = new SoftAssertions(); // soft assertion using AssertJ lib
        softlyAssert.assertThat(title_CheckBoxDemoPage)
                .isNotNull();
        softlyAssert.assertAll();*/

        /*SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(title_CheckBoxDemoPage).isNotNull();
        });*/

        DriverManager.getDriver().findElement(headerMenu_InputForms).click();
        DriverManager.getDriver().findElement(subMenu_InputForms_RadioButtonsDemo).click();
        String title_RadioButtonPage = DriverManager.getDriver().getTitle();

        Assertions.assertThat(title_RadioButtonPage)
                .as("Title does not start with the words as expected").startsWithIgnoringCase("seleniumEasy");
    }
}
