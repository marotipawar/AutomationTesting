package com.maroti.telecomm;

import com.maroti.telecomm.model.Customer;
import com.maroti.telecomm.services.JioServices;
import com.maroti.telecomm.util.StartWebSite;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
/*
*@Author : Maroti Pawar
*@Topic :  Automation Testing of Telecomm Application
*/
public class JioTeleCommApplication {
    public static void main(String[] args) throws InterruptedException {

        StartWebSite site=StartWebSite.builder().driver(new ChromeDriver()).url("https://demo.guru99.com/telecom/index.html").build();
        JioServices services =site.jioServices();
        WebDriver driver=services.start(site.getDriver(),site.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        services.addCustomer();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        services.setTariffPlan();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        services.addTariffPlanToCustomer();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        services.payBill();



    }
}
