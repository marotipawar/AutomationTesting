package com.maroti.assignment.service;

import org.openqa.selenium.WebDriver;

public interface AssignmentServices {
    public void openUrl(String url);
    public String captureUrl();
    public String captureTitle();
    public void navigateTo(String url);
    public void navigateBack();
    public void navigateForward();
    public void  getRefresh();
}
