package com.maroti.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

@Test(groups = "login", dependsOnGroups = "success", priority = 3)
public class LoginTest {
    private String username;
    private String pass;
    @Test(priority = 1,dataProvider = "userInfo", dataProviderClass = RegisterTest.class)
    public void userInfoTest( String usrname, String userpass){
        username = usrname;
        pass=userpass;
    }
    @Test(priority = 2, dataProvider = "browserDriver", dataProviderClass = RegisterTest.class)
    public void clickLoginLink(WebDriver driver){
        driver.findElement(By.xpath("//a[@href='login.php']")).click();
    }
    @Test(priority = 3, dataProvider = "browserDriver", dataProviderClass = RegisterTest.class)
    public void login(WebDriver driver){
        WebElement userName =driver.findElement(By.xpath("//input[@name='userName']"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(pass);
        WebElement btnLogin = driver.findElement(By.xpath("//input[@name='submit']"));
        driver.findElement(By.xpath("//input[@name='submit']")).click();

    }
}
