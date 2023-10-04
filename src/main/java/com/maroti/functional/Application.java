package com.maroti.functional;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;


public class Application {

    public static void testUrl(){
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://www.facebook.com");
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        String chromeTitle = chromeDriver.getTitle();

        WebDriver edgeDriver = new EdgeDriver();
        edgeDriver.get("https://www.facebook.com");
        edgeDriver.manage().window().maximize();
        String edgeTitle=edgeDriver.getTitle();

        if(chromeTitle.equals(edgeTitle)){
            System.out.println("Test case passed");
        }else{
            System.out.println("Test case failed");
        }

    }
    public static void main(String[] args) throws InterruptedException {

        testUrl();

    }
}
