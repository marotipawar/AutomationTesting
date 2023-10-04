package com.maroti.testng.brokenURL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class FindBrokenUrl {
    private WebDriver driver;
    private final String url = "https://rahulshettyacademy.com/AutomationPractice/";
    private HttpURLConnection conn;
    private final int respCode = 400;


    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebElement find(By by){
        return driver.findElement(by);
    }
    public List<WebElement> finds(By by){
        return driver.findElements(by);
    }


    public void brokenUrl() throws IOException {
        driver.get(url);

        List<WebElement> links = finds(By.cssSelector("li[class='gf-li'] a"));
        for(WebElement link : links){
            //System.out.println("Link :"+ link.getText());
            String linkUrl=link.getAttribute("href");
            conn= (HttpURLConnection) (new URL(linkUrl).openConnection());
            conn.setRequestMethod("HEAD");
            conn.connect();
            int resp = conn.getResponseCode();
            System.out.println("Response Code :"+resp);

        }


    }
    public void abc() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat("dd MMMM yyyy");
        String date1=sf.format(new Date("December 17 2021"));
        String date2=sf.format(new Date("17 December 2021"));
        System.out.println(date1.equals(date2));


         }

    public static void main(String[] args) throws IOException, ParseException {
        FindBrokenUrl url = new FindBrokenUrl();

       List<String> numbers = Arrays.asList("Maroti","Jyoti","Gauri","Jagruti","Priynaka");
        Optional<String> na=numbers.stream().filter(name->name.startsWith("J")).map(name->name.toUpperCase()).findFirst();
        System.out.println(na.get());
       /*Optional<String> na=numbers.stream().findFirst();
        System.out.println(na.get());*/
    }
}
