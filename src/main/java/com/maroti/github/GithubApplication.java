package com.maroti.github;

import com.maroti.github.services.GitHubServices;
import com.maroti.github.services.GitHubServicesImpl;
import org.openqa.selenium.chrome.ChromeDriver;

/*
* @Developer: Maroti Pawar
* @Topics   : Create and delete repository in Github application
*/
public class GithubApplication {
    public static void main(String[] args) throws InterruptedException {

        GitHubServices github=
                 GitHubServicesImpl
                .builder()
                .driver(new ChromeDriver())
                .url("https://github.com/")
                .build();
        github.homePage();
        github.login();
        Thread.sleep(10000);
        github.createRepository();
        github.getRepositoryInfo();
        github.deleteRepository();
    }
}
