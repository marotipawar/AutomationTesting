package com.maroti.assignment.calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Goibibo {
    public static void main(String[] args) throws InterruptedException {
        //Step 1: Up casting
        WebDriver driver = new ChromeDriver();
        //Step 2: Open a https://www.goibibo.com/
        driver.get(" https://www.goibibo.com/");
        driver.manage().window().maximize();
        //Close login popup
        driver.findElement(By.xpath("//div[@data-id='auth-flow-section']/span/span")).click();
        //step 3: find the ""from"" object and enter ""Pune value"
        WebElement selectFrom =driver.findElement(By.xpath("//div[@class='sc-12foipm-33 djFwsb'][1]/child::div/div"));
        selectFrom.click();
        WebElement enterCity=driver.findElement(By.xpath("//div[@class='sc-12foipm-37 godvBN']/input"));
        enterCity.sendKeys("Pune");
        Thread.sleep(2000);
        WebElement selectFromCity=driver.findElement(By.xpath("//ul[@class='sc-12foipm-39 dMRdWf']/li[1]"));
        selectFromCity.click();
        Thread.sleep(2000);

        WebElement enterCityTo=driver.findElement(By.xpath("//div[@class='sc-12foipm-36 fWVTLG']/child::div/input"));
        enterCityTo.sendKeys("Delhi");
        Thread.sleep(2000);
        WebElement selectToCity=driver.findElement(By.xpath("//ul[@class='sc-12foipm-39 dMRdWf']/li[1]"));
        selectToCity.click();
        //step 5: select departure date as 10-Aug-2023 value

        WebElement nextMonth=driver.findElement(By.xpath("//div[@class='DayPicker']/div/child::div[1]/span[2]"));

        //step 6: select 5 Adults 4 children
        //step 7: select Travel class as "Premium Economy"
        //step 8: click on Done

        //step 9: Take screenshot

        //step 10: click on search flights

        //step 11: take screenshot

        //step 12: capture all flight price high to low and print in console.
    }
}
