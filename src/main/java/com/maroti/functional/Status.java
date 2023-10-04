package com.maroti.functional;

import org.openqa.selenium.WebElement;

@FunctionalInterface
public interface Status<T> {
public boolean check(T t);
}
