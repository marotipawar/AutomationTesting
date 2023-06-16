package com.maroti.assignment.dropdown;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

/*
* Author: Maroti Pawar
* Topic : Dropdown assignment on demoqa practice form
 */
public class DropdownAssignment_1 {
    private static WebDriver DRIVER = null;

    static {
        DRIVER = new ChromeDriver();
        DRIVER.get("https://demoqa.com/automation-practice-form");

        DRIVER.manage().window().maximize();
    }


    public static Select option(WebElement element){
        return new Select(element);
    }
    public static WebElement element(By by){
        return DRIVER.findElement(by);
    }

    public static boolean checkElementStatus(WebElement element){
        return element.isDisplayed()&&element.isEnabled();
    }

    public static void main(String[] args) throws InterruptedException {
        DRIVER.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        WebElement firstName = element(By.xpath("//input[@id='firstName']"));
        if(checkElementStatus(firstName))firstName.sendKeys("Maroti");
        WebElement lastName = element(By.xpath("//input[@id='lastName']"));
        if(checkElementStatus(lastName))lastName.sendKeys("Pawar");
        WebElement email = element(By.xpath("//input[@id='userEmail']"));
        if(checkElementStatus(email))email.sendKeys("pr.maroti@gmail.com");
        WebElement male = element(By.xpath("//label[@for='gender-radio-1']"));
        if(checkElementStatus(male))male.click();
        WebElement mobile = element(By.xpath("//input[@id='userNumber']"));
        if(checkElementStatus(mobile))mobile.sendKeys("+9923230741");
        WebElement dob = element(By.xpath("//input[@id='dateOfBirthInput']"));
        if(checkElementStatus(dob))dob.click();
        WebElement month = element(By.xpath("//select[@class='react-datepicker__month-select']"));
        if(checkElementStatus(month))
        {
            Select selectMonth = new Select(month);
            selectMonth.selectByIndex(2);
            System.out.println("Month :"+selectMonth.getFirstSelectedOption().getText());
        }
        WebElement year = element(By.xpath("//select[@class='react-datepicker__year-select']"));
        if(checkElementStatus(year)){
            Select selectYear = new Select(year);
            selectYear.selectByVisibleText("2020");
            System.out.println("Year :"+selectYear.getFirstSelectedOption().getText());
        }


        WebElement day=element(By.xpath("//div[text()='10'][1]"));
        if(checkElementStatus(day)){
           Actions act = new Actions(DRIVER);
           act.moveToElement(day).click().build().perform();
            //System.out.println("Day : "+day.getText());
        };

        WebElement subject = element(By.xpath("//input[@id='subjectsInput']"));

        if(checkElementStatus(subject))subject.sendKeys("Learn Selenium Automation By Praful Sir");



        WebElement sport= element(By.xpath("//label[normalize-space()='Reading']"));
       JavascriptExecutor executor = (JavascriptExecutor)DRIVER;
       executor.executeScript("argument[0].click();", sport);



        WebElement picture=element(By.xpath("//input[@id='uploadPicture']"));
        if (checkElementStatus(picture)){
           // picture.click();
        }

        WebElement submitForm=element(By.xpath("//button[@id='submit']"));
        if(checkElementStatus(submitForm))submitForm.click();


    }
}
