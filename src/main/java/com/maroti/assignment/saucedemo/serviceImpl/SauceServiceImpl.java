package com.maroti.assignment.saucedemo.serviceImpl;

import com.maroti.assignment.saucedemo.elements.CartElements;
import com.maroti.assignment.saucedemo.elements.LoginElements;
import com.maroti.assignment.saucedemo.services.SauceServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SauceServiceImpl implements SauceServices {
    private WebDriver driver;

    public SauceServiceImpl(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
    }

    @Override
    public void login(String username, String password) {
        driver.manage().window().maximize();
        driver.findElement(LoginElements.USERNAME).sendKeys(username);
        driver.findElement(LoginElements.PASSWORD).sendKeys(password);
        driver.findElement(LoginElements.LOGIN).click();

    }

    @Override
    public void addItemToCart() throws InterruptedException {

        List<WebElement> elements =driver.findElements(CartElements.ITEMS);
        System.out.println("Item added :"+elements.get(1).getText());
        System.out.println("Item added :"+elements.get(2).getText());
        System.out.println("Item added :"+elements.get(4).getText());
        driver.findElement(CartElements.BAG).click();
        driver.findElement(CartElements.JACKET).click();
        driver.findElement(CartElements.LIGHT).click();
        driver.findElement(CartElements.CART).click();

    }
}
