package com.maroti.testng.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class FollowingSibling {
    private static WebDriver driver;

    static{
        driver= new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();
    }

    public static void main(String[] args) {
        List<WebElement> vegList =driver.findElements(By.xpath("//tr/td[1]"));

       List<String> list= vegList.stream().filter(s->s.getText().contains("Strawberry")).map(e->getPrice(e)).collect(Collectors.toList());
       list.forEach(e-> System.out.println(e));
    }

    public static  String getPrice(WebElement wb){
        return wb.findElement(By.xpath("following-sibling::td[1]")).getText();

    }

}
