package com.maroti.telecomm.services;

import com.maroti.telecomm.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.List;


public interface JioServices {
    public WebDriver start(WebDriver driver,String url);
    public Customer getCustomer();
    public void addCustomer();
    public void setTariffPlan();
    public void addTariffPlanToCustomer();
    public void payBill();
}
