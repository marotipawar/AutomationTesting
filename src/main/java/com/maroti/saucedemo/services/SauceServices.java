package com.maroti.saucedemo.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Map;

public interface SauceServices {
    public void login(String username, String password);
    public void  addItemToCart() throws InterruptedException;
    public void checkOut();
    public void deliver();
    public void finish();
}
