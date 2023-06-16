package com.maroti.assignment.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookReg {

    public static void main(String[] args) {

        //Load Driver

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/reg");
        WebElement day=driver.findElement(By.xpath("//select[@id='day']"));
        Select selectDay = new Select(day);
        selectDay.selectByVisibleText("10");
        String dayText=selectDay.getFirstSelectedOption().getText();
        System.out.println(dayText);
        WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
        Select selectMonth = new Select(month);
        selectMonth.selectByIndex(4);
        String monthText=selectMonth.getFirstSelectedOption().getText();
        System.out.println(monthText);
        WebElement year=driver.findElement(By.xpath("//select[@id='year']"));
        Select selectYear = new Select(year);
        selectYear.selectByValue("2010");
        String yearText=selectYear.getFirstSelectedOption().getText();
        System.out.println(yearText);
    }
}
