package com.maroti.saucedemo.services;

import com.maroti.saucedemo.serviceImpl.SauceServiceImpl;
import com.maroti.saucedemo.util.Element;
import com.maroti.saucedemo.util.ElementStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

import static org.testng.Assert.*;

public class SaucedemoTest {

    private SauceServices shop;

    @BeforeClass
    public void setUp() {
        shop = new SauceServiceImpl(new ChromeDriver());
    }

    @Test(priority = 1)
    public void testLogin() {
        shop.login("standard_user", "secret_sauce");
    }

    @Test(dependsOnMethods = {"testLogin"}, alwaysRun = true)
    public void captureHomePageTitle(){
        String title=shop.driver().getTitle();
        if(title.equals("Swag Labs")){
            System.out.println("Capture title :Test case passed");
        }else{
            System.err.println("Capture title :Test case failed");
        }

    }
    @Test(dependsOnMethods = {"testLogin"}, alwaysRun = true)
    public void captureHomePageUrl(){
        String url=shop.driver().getCurrentUrl();
        if(url.contains("https://www.saucedemo.com/")){
            System.out.println("Capture URL :Test case passed");
        }else {
            System.err.println("Capture URL :Test case failed");
        }
    }
    @Test(dependsOnMethods = "testLogin")
    public void testAddItemToCart() throws InterruptedException {
        shop.addItemToCart();
    }


    @Test(dependsOnMethods = "testAddItemToCart")
    public void testCheckOut() {
        shop.checkOut();
    }

    @Test(dependsOnMethods = "testCheckOut")
    public void testDeliver() {
        shop.deliver();
    }

    @Test(dependsOnMethods = "testDeliver")
    public void testFinish() {
        shop.finish();
    }
    @Test(dependsOnMethods = "testFinish")
    public void verifyTitle(){
        String title=shop.driver().getTitle();
        if(title.equals("Swag Labs")){
            System.out.println("After Back Button Verify Title :Test case pass");
        }else{
            System.err.println("After Back Button Title :Test case failed");
        }
    }
    @AfterClass
    public void tearDown() {
        System.out.println("---------Browser closed----------------");
    }
}