package com.maroti.orangeHrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMLogin {

    public static void main(String[] args) throws InterruptedException {
        //Step 1: Up casting
        WebDriver driver = new ChromeDriver();
        //Step 2: Open a URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(8000l);
        //Step 3: find the username text box
        WebElement usernameElement =driver.findElement(By.name("username"));
        //step 4: check username text box displayed status
        boolean isUsernameDisplayed=usernameElement.isDisplayed();
        System.out.println("Username Text Box Displayed :"+isUsernameDisplayed);
        //step 5: check username text box enabled status
        boolean isUsernameEnabled=usernameElement.isEnabled();
        System.out.println("Username Text Box Enabled :"+isUsernameEnabled);
        //step 6: enter the Admin username
        usernameElement.sendKeys("Admin");
        //Step 7: find the password text box
        WebElement passwordElement=driver.findElement(By.name("password"));
        //step 8: check password text box displayed status
        boolean isPasswordEnabled=passwordElement.isDisplayed();
        System.out.println("Password Text box Enabled : "+isPasswordEnabled);
        //step 9: check password text box enabled status
        boolean isPasswordDisplayed = passwordElement.isDisplayed();
        System.out.println("Password Text box displayed :"+isPasswordDisplayed);
        //step 10: enter the admin123 password
        passwordElement.sendKeys("admin123");
        // Step 11: find the login button
        WebElement buttonElement=driver.findElement(By.xpath("//button[@type='submit']"));
        //step 12: check login button displayed
        boolean isButtonElementDisplayed=buttonElement.isDisplayed();
        System.out.println("Button Displayed :"+isButtonElementDisplayed);
       //step 13: check login button enabled status
        boolean isButtonElementEnabled=buttonElement.isEnabled();
        System.out.println("Button Enabled : "+isButtonElementEnabled);
        //step 14": click on login button
        buttonElement.click();
        //step 15: capture home page title
        String title=driver.getTitle();
        System.out.println("Title : "+title);
        //step 16: capture home page url
        String url=driver.getCurrentUrl();
        System.out.println("URL :"+url);

    }
}
