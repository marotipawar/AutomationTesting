package com.maroti.github.elements;

import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;

@Data
@Builder
public class RepoInfo {
    @Builder.Default
    private By selectCodeButton = By.xpath("//div[@class='position-relative']/following::summary[11]");
    @Builder.Default
    private By cloneUrl= By.xpath("//div/tab-container/child::div[2]/ul/li[1]/tab-container/div[2]/child::div/input");
    @Builder.Default
    private By name = By.xpath("//div/article/child::h1");
}
