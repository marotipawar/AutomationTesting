package com.maroti;

import com.maroti.assignment.service.AssignmentServices;
import com.maroti.assignment.serviceImpl.AssignmentServiceImpl;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @Author: Maroti Pawar
 *
 */
public class AssignmentApplication
{

    public static void main( String[] args ) throws InterruptedException {

        AssignmentServices services = new AssignmentServiceImpl(new ChromeDriver());
        // 1) Open a Google application
            services.openUrl("https://www.google.com");
        // 2) capture URl
            System.out.println("Google Url : "+services.captureUrl());

            services.navigateTo("https://www.github.com");
        // 4) capture url
            System.out.println("Github Url :"+services.captureUrl());
        // 5) navigate to Selenium application
            services.navigateTo("https://www.selenium.dev");
        // 6) capture URl
            System.out.println("Selenium Url :"+services.captureUrl());
        // 7) navigate back
            services.navigateBack();
        // 8) capture title
            System.out.println("Github Title :"+services.captureTitle());
        // 9) navigate back
            services.navigateBack();
        // 10) capture title
            System.out.println("Google Title :"+services.captureTitle());
        // 11) navigate forward
            services.navigateForward();
        // 12) capture title
            System.out.println("Github Title :"+services.captureTitle());
        // 13) refresh the web page
            services.getRefresh();

    }
}
