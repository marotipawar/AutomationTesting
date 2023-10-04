package com.maroti.google;

import com.maroti.google.services.GoogleServices;
import com.maroti.google.servicesimpl.GoogleSearchImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.sql.Driver;

public class Google {
    public static void main(String[] args) throws InterruptedException {

        GoogleServices go = GoogleSearchImpl
                .builder()
                .driver(new ChromeDriver())
                .url("https://www.google.com")
                .build();


        WebDriver driver=go.startBrowser();
        go.searchQuery("Pushpa the Risen");
        go.find(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
        String reDate=go.find(By.xpath("(//div[@class='plainlist'])[5]/ul/li")).getText();
        System.out.println("Release Date Wikipedia :"+reDate);
        Thread.sleep(1000);
        driver.navigate().back();
        go.find(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[2]")).click();
        Thread.sleep(4000);
        String releaseDateIMDb=go.find(By.xpath("(//div[@class='ipc-metadata-list-item__content-container'])[16]/ul/li/a")).getText();
        System.out.println("IMDb Release Date :"+releaseDateIMDb);


    }
}
