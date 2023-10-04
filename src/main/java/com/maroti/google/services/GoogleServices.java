package com.maroti.google.services;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public interface GoogleServices {
    WebElement find(By by);
    List<WebElement> finds(By by);
    void takeScreenShot(String fileName) throws IOException;
    WebDriver startBrowser();
    void searchQuery(String query);
    void selectLinkFirst();
    void captureReleaseDate();
    void selectLinkSecond();

}
