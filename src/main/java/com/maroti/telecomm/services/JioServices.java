package com.maroti.telecomm.services;

import com.maroti.telecomm.ui.CustomerElement;
import org.openqa.selenium.WebDriver;


public interface JioServices {
    public WebDriver start(WebDriver driver,String url);
    public CustomerElement getCustomer();
    public void addCustomer();
    public void setTariffPlan();
    public void addTariffPlanToCustomer();
    public void payBill();
}
