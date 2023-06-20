package com.maroti.assignment.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FramesPractice {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://praf002.github.io/");
        driver.manage().window().maximize();

       //Step 1:  Enter the name
        WebElement nameElement =driver.findElement(By.xpath("//input[@name='name']"));
        nameElement.sendKeys("Maroti");

        //Step 2: Select all odd checkbox
        driver.switchTo().frame(0);
        WebElement checkBoxFrame=driver.findElement(By.xpath("//iframe[@id='showcheckbox']"));
        driver.switchTo().frame(checkBoxFrame);
        List<WebElement> checkboxOdd =driver.findElements(By.xpath("//input[@type='checkbox']"));
        int listLength = checkboxOdd.size();
        System.out.println(listLength);
        for (WebElement checkbox : checkboxOdd){
            if(listLength%2!=0){
                checkbox.click();
            }
            listLength--;
        }

        //Step 3: Select BDD framework from drop down
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.switchTo().frame(0);
        WebElement courses=driver.findElement(By.xpath("//select[@name='course']"));
        Select selectCourse = new Select(courses);
        selectCourse.selectByVisibleText("BDD Framework");

        //Step 4:  Enter mobile Number
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@name='mob']")).sendKeys("9876543210");

        //Step 5: Unselect all odd checkbox and select even checkbox
        driver.switchTo().frame(0);
        List<WebElement> checkboxesEven=driver.findElements(By.xpath("//input[@type='checkbox']"));
        int checkBoxSize=checkboxesEven.size();
        for (WebElement checkbox : checkboxesEven){

            if(checkBoxSize%2==0){
                    checkbox.click();
                }else{
                    checkbox.click();
                }
            checkBoxSize--;
        }
        //Step 6: Enter address
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//input[@name='add']")).sendKeys("Pune");

        //Step 7: Click on selenium link
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//a[text()='Selenium']")).click();

        //Step 8:  Clear the name and enter ur last name
        driver.switchTo().defaultContent();
        WebElement nameElement1=driver.findElement(By.xpath("//input[@name='name']"));
        nameElement1.clear();
        nameElement1.sendKeys("Pawar");

        //Step 9: Clear address and enter new address
        driver.switchTo().frame(1);
        WebElement addressElement=driver.findElement(By.xpath("//input[@name='add']"));
        addressElement.clear();
        addressElement.sendKeys("Nanded");

        //Step 10: Unselect even checkbox
        driver.switchTo().defaultContent();
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        List<WebElement> checkboxList=driver.findElements(By.xpath("//input[@type='checkbox']"));
        int listLength1=checkboxList.size();
        for(WebElement checkbox : checkboxList){
            if(listLength1%2==0) {
                checkbox.click();
            }else{
                    checkbox.click();
                }
            listLength1--;
        }
    }
}
