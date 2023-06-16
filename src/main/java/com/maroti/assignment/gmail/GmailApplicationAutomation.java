package com.maroti.assignment.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailApplicationAutomation {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        WebElement gmail =driver.findElement(By.xpath("//a[@class='gb_v']"));
        gmail.click();
        WebElement loginGmail=driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
       loginGmail.click();
       driver.findElement(By.xpath("//div/input[@name='identifier']")).sendKeys("pr.maroti@gmail.com");
       driver.findElement(By.xpath("//div/button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 qIypjc TrZEUc lw1w4b']")).click();

    }
}
