package com.maroti.saucedemo.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public interface SauceServices {
    void login(String username, String password);
    void  addItemToCart() throws InterruptedException;
    void checkOut();
    void deliver();
    void finish();
    WebDriver driver();
}
