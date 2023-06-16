package com.maroti.telecomm.ui;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebElement;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TariffPlanElement {
    private WebElement rental;
    private WebElement local_minutes;
    private WebElement inter_minutes;
    private WebElement sms_pack;
    private WebElement minutes_charges;
    private WebElement inter_charges;
    private WebElement sms_charges;
    private WebElement btnSubmit;
    private WebElement btnReset;
}
