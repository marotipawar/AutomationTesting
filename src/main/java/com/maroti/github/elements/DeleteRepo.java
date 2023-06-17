package com.maroti.github.elements;

import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;

@Data
@Builder
public class DeleteRepo {
    @Builder.Default
    private By setting = By.xpath("//nav/child::ul[@class='UnderlineNav-body list-style-none']/child::li[9]/a");
    @Builder.Default
    private By btnDelete = By.xpath("//form/button[@id='dialog-show-repo-delete-menu-dialog']");
    @Builder.Default
    private By btnProceed = By.xpath("//div/button[@id='repo-delete-proceed-button']");
    @Builder.Default
    private By procced = By.xpath("//div/button[@id='repo-delete-proceed-button']");
    @Builder.Default
    private By enterRepoName = By.xpath("//primer-text-field/div/input[@id='verification_field']");
    @Builder.Default
    private By deleteStatus = By.xpath("//div[@id='js-flash-container']/child::div/div/div");

}
