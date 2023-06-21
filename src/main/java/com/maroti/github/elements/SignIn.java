package com.maroti.github.elements;

import lombok.*;
import org.openqa.selenium.By;
@Data
@Builder
public class SignIn {

    @Builder.Default
    private By loginLink = By.xpath("//div/a[@href='/login']");
    @Builder.Default
    private By userName = By.xpath("//main/div/input/following-sibling::div[4]/form/input/following-sibling::input");
    @Builder.Default
    private By password = By.xpath("//form/div//following-sibling::input");
    @Builder.Default
    private By btnLogin = By.xpath("//form/div//following-sibling::input[13]");
    @Builder.Default
    private String user = "pawarmw@gmail.com";
    @Builder.Default
    private String pass = "*********";

}
