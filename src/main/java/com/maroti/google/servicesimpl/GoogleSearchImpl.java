package com.maroti.google.servicesimpl;

import com.maroti.google.services.GoogleServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GoogleSearchImpl implements GoogleServices {


    private WebDriver driver;
    private String url;

    @Override
    public WebElement find(By by) {
        return driver.findElement(by);
    }

    @Override
    public List<WebElement> finds(By by) {
        return driver.findElements(by);
    }

    @Override
    public void takeScreenShot(String fileName) throws IOException {
        new File("googleScreenShot").mkdir();
        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcFile =ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("googleScreenShot", "googleSearch.png"));
    }

    @Override
    public WebDriver startBrowser() {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;
    }


    @Override
    public void searchQuery(String query) {
        WebElement search=find(By.xpath("//textarea[@name='q']"));
        search.sendKeys(query, Keys.ENTER);
    }

    @Override
    public void selectLinkFirst() {
        find(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[1]")).click();
    }


    @Override
    public void captureReleaseDate() {
        String relDate=find(By.xpath("(//div[@class='plainlist'])[5]/ul/li")).getText();
        System.out.println("Release Date :"+ relDate);
    }

    @Override
    public void selectLinkSecond() {
        find(By.xpath("(//h3[@class='LC20lb MBeuO DKV0Md'])[2]")).click();
    }

}
