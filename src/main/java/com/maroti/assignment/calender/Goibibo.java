package com.maroti.assignment.calender;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Goibibo {
    public static void main(String[] args) throws InterruptedException, IOException {
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
        boolean result = false;

            do{
                WebElement months=driver.findElement(By.xpath("//div[@class='DayPicker-Month'][1]/div[1]/div"));
                WebElement nextMonth=driver.findElement(By.xpath("//div[@class='DayPicker-NavBar']/span[2]"));
                List<WebElement> days=driver.findElements(By.xpath("//div[@class='DayPicker-Month'][1]/div[3]//child::div/p[1]"));

                if(months.getText().equals("May 2024")){
                    result=true;
                    days.forEach(day->{
                        if(day.getText().equals("31")){
                            day.click();
                        }
                    });
                }else {
                    nextMonth.click();
                }
            }while(!result);

            driver.findElement(By.xpath("//div[@class='sc-12foipm-54 bbkygy']/span[2]")).click();



        //step 6: select 5 Adults 4 children

        Actions act = new Actions(driver);
        WebElement addAdults=driver.findElement(By.xpath("//div[@class='sc-12foipm-33 CAJUg']/div[2]/div[2]/div/div[1]/div[1]/div/span[3]"));
        act.click(addAdults).click(addAdults).click(addAdults).click(addAdults).build().perform();

        WebElement addChildren=driver.findElement(By.xpath("//div[@class='sc-12foipm-33 CAJUg']/div[2]/div[2]/div/div[1]/div[2]/div/span[3]"));
        act.click(addChildren).click(addChildren).click(addChildren).click(addChildren).build().perform();

        //step 7: select Travel class as "Premium Economy"
        driver.findElement(By.xpath("//div[@class='sc-12foipm-33 CAJUg']/div[2]/div[2]/div/div[2]/ul/li[2]")).click();

        //step 8: click on Done
        driver.findElement(By.xpath("//div[@class='sc-12foipm-33 CAJUg']/div[2]/div[3]/a[2]")).click();

        //step 9: Take screenshot

        TakesScreenshot shot = (TakesScreenshot)driver;
        File src =shot.getScreenshotAs(OutputType.FILE);
        new File("img").mkdir();
        FileUtils.copyFile(src, new File("img","screenshot-1.png"));
        //step 10: click on search flights
        driver.findElement(By.xpath("//div[@class='sc-1gt8xf5-3 cBVNVf']/div/div[3]/span")).click();

        //step 11: take screenshot
        File searchSrc=shot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("img", "search.png"));
        //step 12: capture all flight price high to low and print in console.
        Thread.sleep(15000);
        WebElement prices=driver.findElement(By.xpath("//div[@class='seo-srp-layoutstyles__RightWrap-sc-11ypfer-3 isaGih']/div[2]/div[1]/div[2]/div/div[4]"));
        prices.click();
        List<WebElement> priceHighest=driver.findElements(By.xpath("//div[@class='srp-card-uistyles__Price-sc-3flq99-17 HRAwb alignItemsCenter dF fb lh1 padT5']"));
        System.out.println("Highest flight Prices");
        System.out.println("-----------------------------------------------------");
        priceHighest.forEach(item->{
            System.out.println("Highest Prices :"+item.getText());
        });
        prices.click();
        List<WebElement> priceLowest=driver.findElements(By.xpath("//div[@class='srp-card-uistyles__Price-sc-3flq99-17 HRAwb alignItemsCenter dF fb lh1 padT5']"));
        System.out.println("Lowest flight Prices");
        System.out.println("-----------------------------------------------------");
        priceLowest.forEach(item->{
            System.out.println("Lowest Prices :"+item.getText());
        });

    }
}
