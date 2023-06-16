package com.maroti.telecomm;

import com.maroti.telecomm.services.JioServices;
import com.maroti.telecomm.util.StartWebSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
/*
*@Author : Maroti Pawar
*@Topic :  Automation Testing of Telecomm Application
*/
public class JioTeleCommApplication {
    public static void main(String[] args) throws InterruptedException {

        StartWebSite site=StartWebSite.builder().driver(new ChromeDriver()).url("https://demo.guru99.com/telecom/index.html").build();
        JioServices services =site.jioServices();
       //opening browser
        WebDriver driver=services.start(site.getDriver(),site.getUrl());

        //Add new Customer
        services.addCustomer();

        //Add Tariff plan
        services.setTariffPlan();

        //Allocate tariff plan to customer
        services.addTariffPlanToCustomer();

        //Pay bill
        services.payBill();



    }
}
