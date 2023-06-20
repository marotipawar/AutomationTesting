package com.maroti.assignment.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramePractice {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();

        //Step 1: switch to the single frame and enter the  last name
        WebElement tab_1 =driver.findElement(By.xpath("//div[@class='tabpane']/child::ul/li[1]"));
        tab_1.click();
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Maroti");

        //Step 2: switch to the iframe with an iframe and enter the first name
        driver.switchTo().defaultContent();
        WebElement tab_2 =driver.findElement(By.xpath("//div[@class='tabpane']/child::ul/li[2]"));
        tab_2.click();
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Maroti Pawar");

        //Step 3: switch to the iframe with an iframe and capture the entered name and clear the name and enter the new name
        WebElement nameElement=driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("Capture Name From frame with frame :"+nameElement.getAttribute("value"));
        nameElement.clear();
        nameElement.sendKeys("Unknown Person-1");

       //Step 4: switch to the single frame and capture the entered name and clear the name and enter the new name
        driver.switchTo().defaultContent();
        WebElement tabs_1=driver.findElement(By.xpath("//div[@class='tabpane']/child::ul/li[1]"));
        tabs_1.click();
        driver.switchTo().frame("singleframe");
        WebElement nameElement1=driver.findElement(By.xpath("//input[@type='text']"));
        System.out.println("Capture Name From Single Frame : "+nameElement1.getAttribute("value"));
        nameElement1.clear();
        nameElement1.sendKeys("Unknown Person-2");




    }
}
