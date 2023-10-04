package com.maroti.telecomm.services;

import com.maroti.telecomm.ui.CustomerElement;
import org.openqa.selenium.WebDriver;


public interface JioServices {
    WebDriver start(WebDriver driver,String url);
    CustomerElement getCustomer();
    void addCustomer();
    void setTariffPlan();
    void addTariffPlanToCustomer();
    void payBill();
}
