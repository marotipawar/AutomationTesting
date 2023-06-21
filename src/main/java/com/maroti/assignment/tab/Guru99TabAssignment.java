package com.maroti.assignment.tab;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class Guru99TabAssignment {
    public static void main(String[] args) {
        WebDriver driver =new ChromeDriver();
        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
        WebElement firstName =driver.findElement(By.xpath("//input[@name='firstName']"));
        Actions act = new Actions(driver);
        act.sendKeys(firstName,"Maroti")
                .keyDown(Keys.TAB).sendKeys("Pawar")
                .keyDown(Keys.TAB).sendKeys("9876543210")
                .keyDown(Keys.TAB).sendKeys("pr.maroti@gmail.com")
                .keyDown(Keys.TAB).sendKeys("Pune")
                .keyDown(Keys.TAB).sendKeys("Pune")
                .keyDown(Keys.TAB).sendKeys("Maharashtra")
                .keyDown(Keys.TAB).sendKeys("410001")
                .keyDown(Keys.TAB).sendKeys("India")
                .keyDown(Keys.TAB).sendKeys("user")
                .keyDown(Keys.TAB).sendKeys("password")
                .keyDown(Keys.TAB).sendKeys("password")
                .keyDown(Keys.TAB).keyDown(Keys.ENTER)
                .build().perform();
    }
}
