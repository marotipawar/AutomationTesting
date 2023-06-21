package com.maroti.assignment.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.atomic.AtomicInteger;

public class FirstCry {
    public static void main(String[] args) throws InterruptedException {
        new ChromeDriver(){{
           get("https://www.firstcry.com");
           manage().window().maximize();
           new Actions(this){{
                moveToElement(findElement(By.xpath("//div[@class='menu-container']/ul/child::li[5]"))).build().perform();{{
                    AtomicInteger mainCount= new AtomicInteger();
                    findElements(By.xpath("//div[@class='menu-container']/ul/child::li"))
                           .forEach(element -> {
                               mainCount.getAndIncrement();
                               System.out.println("Main Menu :"+element.getText());});
                    System.out.println("Total Main Menu :"+mainCount);
                    AtomicInteger subCount= new AtomicInteger();
                    findElements(By.xpath("//div[@class='option-container submenu1-4']/ul"))
                            .forEach(element -> {
                                subCount.getAndIncrement();
                                System.out.println("Sub Menu: "+element.getText());});
                    System.out.println("Sub Menu :"+subCount);
                }};
           }};
        }};
    }
}
