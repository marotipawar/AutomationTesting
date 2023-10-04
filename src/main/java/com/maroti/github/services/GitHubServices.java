package com.maroti.github.services;

import org.openqa.selenium.WebDriver;

public interface GitHubServices {
    void homePage();
    void login();
    void createRepository() throws InterruptedException;
    void getRepositoryInfo();

    void deleteRepository();


}
