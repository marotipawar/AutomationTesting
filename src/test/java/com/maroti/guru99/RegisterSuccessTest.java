package com.maroti.guru99;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test(groups = "success", dependsOnGroups = "register", priority = 2)
public class RegisterSuccessTest {

   @Test(dataProvider = "browserDriver", dataProviderClass = RegisterTest.class)
    public void registerSuccess(WebDriver driver){
        String url=driver.getCurrentUrl();
        assertTrue(url.contains("register_sucess"));
    }



}
