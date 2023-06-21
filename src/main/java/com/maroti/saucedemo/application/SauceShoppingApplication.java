package com.maroti.saucedemo.application;

import com.maroti.saucedemo.serviceImpl.SauceServiceImpl;
import com.maroti.saucedemo.services.SauceServices;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceShoppingApplication {

    public static void main(String[] args) throws InterruptedException {

        SauceServices shop = new SauceServiceImpl(new ChromeDriver());
        shop.login("standard_user","secret_sauce");
        shop.addItemToCart();
        shop.checkOut();
        shop.deliver();
        shop.finish();


    }
}
