package com.maroti.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.HashMap;
import java.util.Map;
/*
* @Title : Assignment 2
* @Author: Maroti Pawar
* @Topic : Fill value in Guru99 Register form using Selenium Automation
* @Date  : 13-june-2023
* */
public class Guru99 {

    // check username text box displayed status and check username text box enabled status
    public static boolean checkTextBoxEnabledOAndDisplayed(WebElement element){
        if(element.isDisplayed() && element.isEnabled()){
            return true;
        }else {
            return false;
        }
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

    public static void main(String[] args) {

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
        //step 4: capture home page title
        String title=driver.getTitle();
        System.out.println("Title : "+title);
        //step 5: capture home page url
        String url=driver.getCurrentUrl();
        System.out.println("Title :"+url);
    }

}
