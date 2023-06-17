package com.maroti.github.services;

import org.openqa.selenium.WebDriver;

public interface GitHubServices {
    public void homePage();
    public void login();
    public void createRepository() throws InterruptedException;
    public void getRepositoryInfo();

    public void deleteRepository();


}
