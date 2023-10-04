package com.maroti.assignment.serviceImpl;

import com.maroti.assignment.service.AssignmentServices;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AssignmentServiceImpl implements AssignmentServices {
   private final WebDriver driver;

    public AssignmentServiceImpl(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8L));
    }

    @Override
    public void openUrl(String url) {
        driver.get(url);
    }

    @Override
    public String captureUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String captureTitle() {
        return driver.getTitle();
    }

    @Override
    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    @Override
    public void navigateBack() {
        driver.navigate().back();
    }

    @Override
    public void navigateForward() {
        driver.navigate().forward();
    }

    @Override
    public void getRefresh() {
        driver.navigate().refresh();
    }
}
