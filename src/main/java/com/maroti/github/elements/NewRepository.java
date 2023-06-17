package com.maroti.github.elements;

import lombok.Builder;
import lombok.Data;
import org.openqa.selenium.By;


@Data
@Builder
public class NewRepository {
    @Builder.Default
    private By newRepoLink=By.xpath("//div[@class='js-repos-container']/following::h2/a[@href='/new']");
    @Builder.Default
    private By btnOwner = By.xpath("//div[@class='Box-sc-g0xbh4-0 blYLER']/button");
    @Builder.Default
    private By ownerName = By.xpath("//span[@class='Box-sc-g0xbh4-0 gnKQLm']");
    @Builder.Default
    private By repoName= By.xpath("//fieldset/div/span/following::input[1]");
    @Builder.Default
    private By desc= By.xpath("//fieldset/div/span/following::input[2]");
    @Builder.Default
    private By privacyPublic = By.xpath("//fieldset/div/span/following::input[3]");
    @Builder.Default
    private By privacyPrivate = By.xpath("//fieldset/div/span/following::input[4]");
    @Builder.Default
    private By addReadMe = By.xpath("//fieldset/div/span/following::input[5]");
    @Builder.Default
    private By selectIgnore = By.xpath("//div/following::div[@class='Box-sc-g0xbh4-0 ebrBMq']/button");
    @Builder.Default
    private By chooseIgnore = By.xpath("//ul/following::li/div/span[@class='Box-sc-g0xbh4-0 gnKQLm']");
    @Builder.Default
    private By selectLicense= By.xpath("//div/following::div[@class='Box-sc-g0xbh4-0 ebrBMq']/following::button");
    @Builder.Default
    private By chooseLicense = By.xpath("//ul/following::li/div/span[contains(text(), 'None')]");
    @Builder.Default
    private By btnCreate= By.xpath("//div/following::div[@class='Box-sc-g0xbh4-0 ebrBMq']/following::button[@class='types__StyledButton-sc-ws60qy-0 iWYfoa']");
}
