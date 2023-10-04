package com.maroti.goibibo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
/*
* @Author: Maroti Pawar
* @Date  : 28/06/2023 12:40 AM
* */
public class GoibiboApplication {
    private final WebDriver driver;
    private final WebDriverWait wait;

    {
        driver=new ChromeDriver();
        driver.get("https://www.goibibo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
        wait = new WebDriverWait(driver,Duration.ofSeconds(40));
        new File("screentshots").mkdir();
    }
    public WebElement find(By by){
        return driver.findElement(by);
    }
    public List<WebElement> finds(By by){
        return driver.findElements(by);
    }
    public By path(By by){
        return by;
    }
    public void takeScreenShotOfElement(WebElement element,String fileName) throws IOException {
        File src =element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("screenshots", fileName));
    }
    public void fullScreenShot(String fileName) throws IOException {
        TakesScreenshot tk = (TakesScreenshot) driver;
        File srcFile=tk.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("screenshots", fileName));
    }
    public void waitUntil(By by){
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void addAdult(int adult){
        while (adult>0){
            find(Elements.btnAdult).click();
            adult--;
        }
    }
    public void addChildren(int child){
        while(child>0){
            find(Elements.btnChild).click();
            child--;
        }
    }
    public void selectDate(String ...dt) throws InterruptedException {
        WebElement month= find(Elements.month);
        WebElement next=find(Elements.btnNext);
        boolean result=false;
        while(!result){
            if(month.getText().equals(dt[0])){
                List<WebElement> days=finds(Elements.days);
                days.forEach(day->{
                    if(day.getText().equals(dt[1])){
                        day.click();
                    }
                });
                System.out.println(month.getText());
                result=true;
            }else{
                Thread.sleep(1000);
                next.click();
            }
        }
    }
    public void searchOneWayFlight(String ...data) throws InterruptedException, IOException {
        find(Elements.fromClick).click();
        waitUntil(path(Elements.fromInput));
        find(Elements.fromInput).sendKeys(data[0]);
        WebElement selectForm=find(Elements.fromSelect);
        takeScreenShotOfElement(selectForm, "fromCity.jpg");
        selectForm.click();
        find(Elements.toInput).sendKeys(data[1]);
        WebElement toSelect=find(Elements.selectTo);
        takeScreenShotOfElement(toSelect, "toCity.jpg");
        toSelect.click();
        selectDate(data[2], data[3]);
        find(Elements.btnDone).click();
        WebElement adults=find(Elements.btnAdult);
        addAdult(Integer.parseInt( data[4]));
        WebElement children=find(Elements.btnChild);
        addChildren(Integer.parseInt(data[5]));
        WebElement btnPass=find(Elements.btnPassengerDone);
        takeScreenShotOfElement(btnPass, "passenger.png");
        btnPass.click();
        find(Elements.btnSearch).click();
        waitUntil(path(Elements.priceList));
        WebElement order=find(Elements.priceOrder);
        takeScreenShotOfElement(order, "priceList.jpg");
        List<WebElement> priceList=finds(Elements.priceList);
        System.out.println("Lowest Order prices");
        priceList.forEach(price->{
            System.out.println(price.getText());
        });
        order.click();
        System.out.println("Highest Order prices");
        priceList.forEach(price->{
            System.out.println(price.getText());
        });
        fullScreenShot("allPricesList.jpg");
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        //Step 1: Create Goibibo Application Instance
        GoibiboApplication go = new GoibiboApplication();
        //Step 2 : Call instance method of Goibibo application for searchFlight
        go.searchOneWayFlight("Pune","Mumbai","November 2023", "14", "4", "3");
    }


    static class Elements {
        public static final By fromClick= By.xpath("//div[@class='sc-12foipm-33 djFwsb'][1]");
        public static final By fromInput = By.xpath("//div[@class='sc-12foipm-37 godvBN']/input");
        public static final By fromSelect = By.xpath("//div[@class='sc-12foipm-41 haMfrh']");
        public static final By toInput= By.xpath("//div[@class='sc-12foipm-37 godvBN']/input");
        public static final By selectTo= By.xpath("//div[@class='sc-12foipm-41 haMfrh']");
        public static final By month = By.xpath("(//div[@class='DayPicker-Month']/child::div[1]/div)[1]");
        public static final By btnNext = By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']");
        public static final By days = By.xpath("//div[@class='DayPicker-Month'][1]/div[3]//child::div/p[1]");
        public static final By btnDone = By.xpath("//div[@class='sc-12foipm-54 bbkygy']/span[2]");
        public static final By btnAdult = By.xpath("//div[@class='sc-12foipm-65 kpPDsg']/div[2]/div/div[1]/child::div[1]/div/span[3]");
        public static final By btnChild = By.xpath("//div[@class='sc-12foipm-65 kpPDsg']/div[2]/div/div[1]/child::div[2]/div/span[3]");
        public static final By btnPassengerDone = By.xpath("//div[@class='sc-12foipm-65 kpPDsg']/div[3]/a[2]");
        public static final By btnSearch = By.xpath("//div[@class='sc-12foipm-29 GNtzn']/div[3]/span");
        public static final By priceOrder = By.xpath("//div[@class='NewSortOptionsstyles__SortTab-sc-1k34lsv-5 jVPxPT flex1 flexCol alignItemsCenter font10 go_blue']");
        public static final By priceList = By.xpath("//div[@class='srp-card-uistyles__Price-sc-3flq99-17 HRAwb alignItemsCenter dF fb lh1 padT5']");

    }

}
