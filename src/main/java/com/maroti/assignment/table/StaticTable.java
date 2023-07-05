package com.maroti.assignment.table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class StaticTable {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://prafpawar11.github.io/emptable.html");
        WebElement studentTbl=driver.findElement(By.xpath("//table[@id='student']"));
        List<WebElement> tbl_cols =studentTbl.findElements(By.xpath("//tbody/tr[1]/th"));
        int colCount =0;
        for (WebElement ele : tbl_cols){
            colCount++;
            System.out.println("Column "+colCount+": "+ele.getText());

        }
        System.out.println("----------------------------------");
        System.out.println("Total Number of Column in table :"+ colCount);

        List<WebElement> tbl_rows=driver.findElements(By.xpath("//tbody/tr[2]/td"));
        int rowCount=0;

        System.out.println("----------------------------------------------------------------");
        for(WebElement row : tbl_rows){
            rowCount++;
            System.out.print(" | "+row.getText());
        }
        System.out.println("\n---------------------------------------------------------------");
        System.out.println("Total row in table :"+rowCount);
    }

}
