package com.maroti.guru99;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/*
* @Author: Maroti Pawar
* */
public class Guru99 {
  static {
      new File("screenshot").mkdir();
  }
    // check username text box displayed status and check username text box enabled status
    public static boolean checkTextBoxEnabledOAndDisplayed(WebElement element){
        return element.isDisplayed() && element.isEnabled();
    }

    // Enter the value in text box
    public static void findElementByNameAndSendKeys(WebDriver driver, Map data){
        data.forEach((element,value)->{
            WebElement check=driver.findElement(By.name(element.toString()));
            if(checkTextBoxEnabledOAndDisplayed(check)){
                check.sendKeys(value.toString());
            }
        });

    }
    public static void fullScreenShot(WebDriver driver,String fileName) throws IOException {
        TakesScreenshot tk = (TakesScreenshot) driver;
        File srcFile=tk.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("screenshot", fileName));
    }

    public static void main(String[] args) throws IOException {

        //Set the Elements and Values
        Map<String, String> register = new HashMap<>();
        register.put("firstName","Maroti");
        register.put("lastName", "Pawar");
        register.put("phone", "9923230741");
        register.put("userName", "pr.maroti@gmail.com");
        register.put("address1", "Nanded");
        register.put("city","Nanded");
        register.put("state", "Maharashtra");
        register.put("postalCode", "410001");
        register.put("country", "India");
        register.put("email", "pr.maroti@gmail.com");
        register.put("password", "12345");
        register.put("confirmPassword","12345");

        //Step 1: Up casting
        WebDriver driver = new ChromeDriver();
        //Step 2: Open a URL
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        //Step 3: find the elements and enter the values
        findElementByNameAndSendKeys(driver, register);
        fullScreenShot(driver, "register.jpg");
        //step 4: capture home page title
        String title=driver.getTitle();
        System.out.println("Title : "+title);
        //step 5: capture home page url
        String url=driver.getCurrentUrl();
        System.out.println("Title :"+url);
    }

}
