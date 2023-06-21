package com.maroti.assignment.screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShot {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("");
        WebElement element =driver.findElement(By.xpath(""));

    }
}
