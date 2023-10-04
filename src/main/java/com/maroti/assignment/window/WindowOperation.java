package com.maroti.assignment.window;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicReference;

public class WindowOperation {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        String parentWindow=driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.facebook.com");
        driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://www.youtube.com");
        AtomicReference<String> facebook = new AtomicReference<String>();
        driver.getWindowHandles().forEach(window->{
            if(!window.equals(parentWindow)){
                facebook.set(window);
            }
        });

        System.out.println("Facebook Window ID :"+facebook.get());
        driver.switchTo().window(parentWindow);
        driver.switchTo().window(facebook.get());

    }
}
