package com.maroti.github.services;

import com.maroti.github.elements.DeleteRepo;
import com.maroti.github.elements.NewRepository;
import com.maroti.github.elements.RepoInfo;
import com.maroti.github.elements.SignIn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GitHubServicesImpl implements GitHubServices{
    private WebDriver driver;
    private String url;
    private WebElement find(By path){
        return driver.findElement(path);
    }

    private void javascript(WebElement element){
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].click();",element);
    }
    @Override
    public void homePage() {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public void login() {
        SignIn signIn=SignIn.builder().build();
        find(signIn.getLoginLink()).click();
        find(signIn.getUserName()).sendKeys(signIn.getUser());
        find(signIn.getPassword()).sendKeys(signIn.getPass());
        find(signIn.getBtnLogin()).click();

    }

    @Override
    public void createRepository() throws InterruptedException {
        NewRepository newRepo = NewRepository.builder().build();
        javascript(find(newRepo.getNewRepoLink()));
        find(newRepo.getBtnOwner()).click();
        System.out.println("Owner Name :"+ find(newRepo.getOwnerName()).getText());
        find(newRepo.getOwnerName()).click();
        find(newRepo.getRepoName()).sendKeys("TestRepository");
        find(newRepo.getDesc()).sendKeys("This is an created for testng purpose only.");
        find(newRepo.getPrivacyPublic()).click();
        javascript(find(newRepo.getAddReadMe()));
        find(newRepo.getSelectIgnore()).click();
        find(newRepo.getChooseIgnore()).click();
        find(newRepo.getSelectLicense()).click();
        find(newRepo.getChooseLicense()).click();
        find(newRepo.getBtnCreate()).click();
    }

    @Override
    public void getRepositoryInfo() {
        RepoInfo repo = RepoInfo.builder().build();
        System.out.println("Repository Name :"+find(repo.getName()).getText());
        find((repo.getSelectCodeButton())).click();
        System.out.println("Clone URL :"+find(repo.getCloneUrl()).getAttribute("value"));

    }


    @Override
    public void deleteRepository() {
        DeleteRepo del = DeleteRepo.builder().build();
        javascript( find(del.getSetting()));
        find(del.getBtnDelete()).click();
        find(del.getBtnProceed()).click();
        find(del.getProcced()).click();
        find(del.getEnterRepoName()).sendKeys("marotipawar/TestRepository");
        find(del.getProcced()).click();
        System.out.println("Delete Status :"+find(del.getDeleteStatus()).getText());

    }
}
