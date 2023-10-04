package com.maroti.assignment.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class WindowHandle {
    public static void main(String[] args) throws InterruptedException {

        //Step 1: Up casting
        WebDriver driver = new ChromeDriver();

        //step 2: open a URL https://www.hyrtutorials.com/p/window-handles-practice.html

        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        driver.manage().window().maximize();
        //step 3: capture title

        System.out.println(driver.getTitle());
        //step 4: capture parent window Id number

        String parentWindowId =driver.getWindowHandle();
        System.out.println(parentWindowId);

        //step 5: click on open a new window
        Thread.sleep(2000);
        driver.findElement(By.xpath("//article/div/div//child::div[2]/button")).click();

        //step 6: capture opened window Id Number
        AtomicReference<String> newWindowId=new AtomicReference<String>();
        driver.getWindowHandles()
                .forEach(win->{
                    if(!win.equals(parentWindowId))
                    {
                        System.out.println("New Window Id :"+win);
                        newWindowId.set(win);
                    }
        });

        // step 7: switch focus to Opened window
        driver.switchTo().window(newWindowId.get()).manage().window().maximize();

        //Step 8: Enter firsname, last name, select gender and select checkbox
        driver.findElement(By.xpath("//input[@name='fName']")).sendKeys("Maroti");
        driver.findElement(By.xpath("//input[@name='lName']")).sendKeys("Pawar");
        driver.findElement(By.xpath("//input[@id='malerb']")).click();
        List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@name='language']"));
        checkboxes.forEach(checkbox->{
                if(checkbox.getText().equals("Hindi")) {
                    checkbox.click();
                }
                });
        Thread.sleep(8000);

        //step 9: switch focus to parent Window
        driver.switchTo().window(parentWindowId);

        //step 10: capture URL
        System.out.println("Capture URL :"+driver.getCurrentUrl());
    }

}
