package com.seleniumEasy.pages;

import com.mine.driver.DriverManager;
import org.openqa.selenium.By;

public final class HomePage {
    private HomePage(){ }

    private final By linkDemoHome = By.xpath("//a[contains(text(),'Demo Home')]");
    private static final By linkInputForms = By.xpath("//ul[@id='treemenu']//a[normalize-space()='Input Forms']");
    private static final By linkSimpleFormDemo = By.xpath("//ul[@id='treemenu']//a[contains(text(),'Simple Form Demo')]");

    public void clickDemoHomeLink(){
        DriverManager.getDriver().findElement(linkDemoHome).click();
    }

    public static void menuListNavigation(String mainMenuName, String branchMenuName){
        // can create Enums for MenuNames and BranchMenuNames so that testers will not make spelling mistakes

        switch (mainMenuName){
            case "InputForms":
                DriverManager.getDriver().findElement(linkInputForms).click();
                break;
            case "Date pickers":
                break;
            default:
        }

        if ("Simple Form Demo".equals(branchMenuName))
            DriverManager.getDriver().findElement(linkSimpleFormDemo).click();
    }
}
