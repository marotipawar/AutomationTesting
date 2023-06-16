package com.maroti.telecomm.util;

import com.maroti.telecomm.services.JioServices;
import com.maroti.telecomm.servicesimpl.JioServiceImpl;
import lombok.*;
import org.openqa.selenium.WebDriver;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StartWebSite {
    private WebDriver driver;
    private String url;


    public JioServices jioServices(){
        return new JioServiceImpl();
    }



}
