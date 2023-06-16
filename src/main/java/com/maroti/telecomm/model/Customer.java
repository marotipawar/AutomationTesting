package com.maroti.telecomm.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {
    private Integer id;
    private WebElement background;
    private WebElement firstName;
    private WebElement lastName;
    private WebElement email;
    private WebElement address;
    private WebElement mobile;
    private WebElement btnSubmit;
    private WebElement btnReset;



}
