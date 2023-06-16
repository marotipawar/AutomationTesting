package com.maroti.assignment.alert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement btn1 =driver.findElement(By.cssSelector("button[onclick='myFunctionAlert()']"));
        btn1.click();
        Alert alert1 =driver.switchTo().alert();
        System.out.println("Alert :"+alert1.getText());
        alert1.accept();
        WebElement btn2 =driver.findElement(By.cssSelector("button[onclick='myFunctionConfirm()']"));
        btn2.click();
        Alert alert2 =driver.switchTo().alert();
        System.out.println("Alert :"+alert2.getText());
        alert2.accept();
        System.out.println("HTMl Text After button press :"+driver.findElement(By.id("demo")).getText());
        WebElement btn3 =driver.findElement(By.cssSelector("button[onclick='myFunctionPrompt()']"));
        btn3.click();
        Alert alert3 =driver.switchTo().alert();
        System.out.println("Alert :"+alert3.getText());
        alert3.sendKeys("Maroti Pawar");
        alert3.accept();
        System.out.println("HTMl Text After button press :"+driver.findElement(By.id("demo")).getText());

    }
}
