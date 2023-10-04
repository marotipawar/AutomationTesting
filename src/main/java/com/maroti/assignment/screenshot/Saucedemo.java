package com.maroti.assignment.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Saucedemo {
    private  static final File soucedemo;
    static {
        soucedemo = new File("soucedemo");
        soucedemo.mkdir();
    }
    public static void main(String[] args) throws IOException {

        //Step 1: UP casting
        WebDriver driver = new ChromeDriver();
        //Step 2; open a URL: https://www.saucedemo.com/inventory.html
        driver.get("https://www.saucedemo.com/inventory.html");
        driver.manage().window().maximize();
        //Step 3: find username text box
        WebElement usernameElement =driver.findElement(By.xpath("//input[@data-test='username']"));
        //step 4: check displayed status
        //step 5: check enabled status
        //step 6: enter username as 				standard_user
        if(checkElement(usernameElement)){
            usernameElement.sendKeys("standard_user");
        }
        //Step 7: find password text box
        WebElement passwordElement=driver.findElement(By.xpath("//input[@data-test='password']"));
        //step 8: check displayed status
        //step 9: check enabled status
        //step 10: enter password as 				secret_sauce
        if(checkElement(passwordElement)){
            passwordElement.sendKeys("secret_sauce");
        }
        //Step 11: Capture screenshot
        captureScreenShot(driver, "1_login.png");
        //step 12: find login button
        WebElement btnLogin=driver.findElement(By.xpath("//input[@id='login-button']"));
        //step 13: check displayed status
        //step 14: check enabled status
        //step 15:click on login button
        if(checkElement(btnLogin)){
            btnLogin.click();
        }
        //Step 16: capture screenshot
        captureScreenShot(driver, "2_homePage.png");
        //step 17: capture home page title
        System.out.println("Home Page Title :"+driver.getTitle());
        //step 18: capture home page url
        System.out.println("Home page URL :"+driver.getCurrentUrl());
        //step 19: find Sauce Labs Backpack add to cart product Object/Element
        WebElement backpack= driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']"));
        //step 20: click on add to cart
        if(checkElement(backpack)){
            backpack.click();
        }
        //step 21: capture screenshot
        captureScreenShot(driver, "3_bagpack.jpg");
        //step 22: find Sauce Labs Bike Light add to cart product
        WebElement light=driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bike-light']"));
        //step 23: click on add to cart
        if(checkElement(light)){
            light.click();
        }
        //Step 24 : capture screenshot
        captureScreenShot(driver, "4_light.png");
        //step 25: find Sauce Labs Bolt T-Shirt add to cart product
        WebElement t_shirt=driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-bolt-t-shirt']"));
        //step 26: click on add to cart
        if (checkElement(t_shirt)){
            t_shirt.click();
        }
        //Step 27: capture screenshot
        captureScreenShot(driver, "5_t_shirt.jpg");
        //step 28": find the shopping cart container
        WebElement cart=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        //step 29: click on shopping cart container
        if(checkElement(cart)){
            cart.click();
        }
        //step 30: capture screenshot
        captureScreenShot(driver, "6_cart.jpg");
        //step 31: find the checkout button
        WebElement checkout=driver.findElement(By.xpath("//button[@data-test='checkout']"));
        //step 32: capture screenshot
        captureScreenShot(driver, "7_checkout.png");
        //step 33: click on checkout button
        if(checkElement(checkout)){
            checkout.click();
        }
        //step 34: capture screenshot
        captureScreenShot(driver, "8_checkout.jpg");
        //step 35: find the first name text box
        WebElement firstName=driver.findElement(By.xpath("//input[@data-test='firstName']"));
        //step 36: enter your name
        if(checkElement(firstName)){
            firstName.sendKeys("Maroti");
        }
        //step 37 : find the last name text box
        WebElement lastName=driver.findElement(By.xpath("//input[@data-test='lastName']"));
        //step 38: enter last name
        if(checkElement(lastName)){
            lastName.sendKeys("Pawar");
        }
        //step 39: find the zip text box
        WebElement postalCode=driver.findElement(By.xpath("//input[@data-test='postalCode']"));
        //step 40: enter the zip code
        if(checkElement(postalCode)){
            postalCode.sendKeys("410001");
        }
        //step 41: capture screenshot
        captureScreenShot(driver, "9_info.jpg");
        //step 42: find the continue button
        WebElement cont=driver.findElement(By.xpath("//input[@data-test='continue']"));
        //step 43: click on continue button
        if(checkElement(cont)){
          cont.click();
        }
        captureScreenShot(driver,"10_overview.png");
        //step 44: find the finish button
        WebElement finish=driver.findElement(By.xpath("//button[@data-test='finish']"));
        //step 45: click on finish button
        if(checkElement(finish)){
            finish.click();
        }
        captureScreenShot(driver,"11_order_status.png");
        //step 46: find the back Home button
        WebElement back=driver.findElement(By.xpath("//button[@data-test='back-to-products']"));
        //step 47: click on back home button
        if(checkElement(back)){
            back.click();
        }
        //step 48: capture screenshot
        captureScreenShot(driver,"12_back.png");
    }
    public static void captureScreenShot(WebDriver driver, String fileName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(soucedemo,fileName));
    }
    public static boolean checkElement(WebElement element){
        return element.isDisplayed() && element.isEnabled();
    }
}
