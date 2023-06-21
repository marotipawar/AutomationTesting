package com.maroti.assignment.screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShot {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        TakesScreenshot ts = (TakesScreenshot)driver;
        File src =ts.getScreenshotAs(OutputType.FILE);
        File file = new File("screenShots");
        file.mkdir();
        FileUtils.copyFile(src, new File(file,"facebook.png"));

    }
}
