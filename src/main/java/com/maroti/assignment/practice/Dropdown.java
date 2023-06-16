package com.maroti.assignment.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
       /* WebDriver driver = new ChromeDriver();
        driver.get("http://www.spicejet.com/");
        WebElement select =driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']//input[@type='text']"));
        select.click();
        WebElement from = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-ov7bg r-z2wwpe r-utggzx r-atwnbb r-cfp7ip']//div[@class='css-76zvg2 r-1xedbs3 r-ubezar']"));
        from.click();
        Thread.sleep(4000);
        WebElement to = driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-knv0ih r-1k1q3bj r-ql8eny r-1dqxon3']/div[2]/div[1]"));
        to.click();*/

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement element=driver.findElement(By.id("name"));
/*
        Actions act = new Actions(driver);
        act.sendKeys(element, "Maroti").build().perform();*/

       /* JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='Patil'",element);
*/

    }
}
