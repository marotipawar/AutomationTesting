package com.maroti.assignment.calender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class IRCTC_Calender {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
        WebElement clickSpan =driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']"));
        clickSpan.click();


        // 12-Nov-2023

        while(true){

                WebElement nextMonth=driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all ng-tns-c58-10 ng-star-inserted']"));
                WebElement month=driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']/span[1]"));
                WebElement year=driver.findElement(By.xpath("//div[@class='ui-datepicker-title ng-tns-c58-10']/span[2]"));

                if(month.getText().equals("October") && year.getText().equals("2023")){
                    List<WebElement> days =driver.findElements(By.xpath("//tbody[@class='ng-tns-c58-10']/tr/td"));
                    for (WebElement day : days){
                        if(day.getText().equals("12")){
                            Thread.sleep(4000);
                            day.click();
                            break;
                        }
                    }
                    break;
                }else{
                    nextMonth.click();
                }

        }
        WebElement selectedDate=driver.findElement(By.xpath("//input[@class='ng-tns-c58-10 ui-inputtext ui-widget ui-state-default ui-corner-all ng-star-inserted']"));
        System.out.println(selectedDate.getAttribute("value"));
    }
}
