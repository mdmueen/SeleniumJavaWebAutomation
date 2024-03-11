package com.seleniumEasy.tests;

import com.mine.driver.DriverManager;
import com.mine.tests.BaseTest;
import com.mine.utils.ReadPropertyFile;
import com.seleniumEasy.pages.SimpleFormDemoPage;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.IntegerAssert;
import org.testng.annotations.Test;

public final class SimpleFormDemoTest extends BaseTest {
    private SimpleFormDemoTest(){ }

    @Test
    public void testcase1() throws Exception {

        int value1 = 22;
        int value2 = 30;

        DriverManager.getDriver().get(ReadPropertyFile.getValue("Url"));

        SimpleFormDemoPage simpleFormDemoPage = new SimpleFormDemoPage();
        simpleFormDemoPage.enterValue1(value1).enterValue2(value2).clickGetTotal(); // Method Chaining of non static methods of the class can be achieved here

        Assertions.assertThat(simpleFormDemoPage.getDisplayTotal())
                .isEqualTo(String.valueOf(value1 + value2)) // need to check why it is failing if we pass the parameter as (new IntegerAssert(value1 + value2))
                .isNotNull();
    }
}
