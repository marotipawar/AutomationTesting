package com.maroti.assignment.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Google {
    public static void main(String[] args) {

        new ChromeDriver(){{
           get("https://www.google.com");
           manage().window().maximize();
        }};
    }
}
