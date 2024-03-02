package com.mine.tests;

import com.mine.driver.Driver;
import com.mine.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected BaseTest(){ } // this constructor cant be private because it has to be visible to its child classes

    @BeforeMethod
    protected void setUp(){
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quitDriver();
    }
}