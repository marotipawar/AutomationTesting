package com.maroti.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Map;

public final class BaseLayer {


    public WebDriver driver;
    public static BaseLayer baseLayer;

    private BaseLayer(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://demo.guru99.com/test/newtours/register.php");


    }

    public static BaseLayer getInstance(WebDriver driver) {

        if (baseLayer == null) {
            baseLayer = new BaseLayer(driver);
        }
        return baseLayer;
    }


    public static boolean checkTextBoxEnabledOAndDisplayed(WebElement element) {
        if (element.isDisplayed() && element.isEnabled()) {
            return true;
        } else {
            return false;
        }
    }


    public static void findElementByNameAndSendKeys(WebDriver driver, Map data) {
        data.forEach((element, value) -> {
            WebElement check = driver.findElement(By.name(element.toString()));
            if (checkTextBoxEnabledOAndDisplayed(check)) {
                check.sendKeys(value.toString());
            }
        });

    }

}
