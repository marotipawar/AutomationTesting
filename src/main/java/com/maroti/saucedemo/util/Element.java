package com.maroti.saucedemo.util;

import org.openqa.selenium.WebElement;

public class Element implements ElementStatus<WebElement>{
    @Override
    public boolean isDisplayAndEnabled(WebElement element) {
        return element.isDisplayed() && element.isEnabled();
    }
}
