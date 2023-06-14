package com.maroti.assignment.saucedemo.elements;

import org.openqa.selenium.By;

public class CartElements {
    public static final By ITEMS = By.xpath("//div[@class='inventory_item_name']");
    public static final By BAG= By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
    public static final By LIGHT= By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']");
    public static final By JACKET= By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']");
    public static final By CART = By.xpath("//a[@class='shopping_cart_link']");
}
