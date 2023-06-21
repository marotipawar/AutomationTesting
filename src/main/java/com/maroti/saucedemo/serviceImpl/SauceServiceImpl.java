package com.maroti.saucedemo.serviceImpl;

import com.maroti.saucedemo.elements.CartElements;
import com.maroti.saucedemo.elements.LoginElements;
import com.maroti.saucedemo.services.SauceServices;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class SauceServiceImpl implements SauceServices {
    private final WebDriver driver;

    public SauceServiceImpl(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8000));
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

    @Override
    public void checkOut() {

        driver.findElement(By.xpath("//button[@id='checkout']")).click();

    }

    @Override
    public void deliver() {
        driver.findElement(By.id("first-name")).sendKeys("Maroti");
        driver.findElement(By.id("last-name")).sendKeys("Pawar");
        driver.findElement(By.id("postal-code")).sendKeys("400001");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Override
    public void finish() {
        driver.findElement(By.xpath("//button[@id='finish']")).click();
    }
}
