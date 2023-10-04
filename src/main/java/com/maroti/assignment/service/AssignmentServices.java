package com.maroti.assignment.service;

import org.openqa.selenium.WebDriver;

public interface AssignmentServices {
    void openUrl(String url);
    String captureUrl();
    String captureTitle();
    void navigateTo(String url);
    void navigateBack();
    void navigateForward();
    void  getRefresh();
}
