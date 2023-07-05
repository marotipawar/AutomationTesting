package com.maroti.guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.HashMap;
import java.util.Map;


@Test(groups = "register", priority = 1)
public class RegisterTest {

    private static WebDriver driver;
    private BaseLayer baseLayer;
    private static String username;
    private static String password;

    @Parameters({"browser"})
    @BeforeTest
    public void setup(String dri) throws InterruptedException {

        if (dri.equals("chrome")) {
            baseLayer = BaseLayer.getInstance(new ChromeDriver());
            driver = baseLayer.driver;
        }
        if (dri.equals("edge")) {
            baseLayer = BaseLayer.getInstance(new EdgeDriver());
            driver = baseLayer.driver;

        }/*if (dri.equals("firefox")) {
            baseLayer = BaseLayer.getInstance(new FirefoxDriver());
            driver = baseLayer.driver;

        }*/
    }


    @DataProvider(name = "browserDriver")
    public static Object[][] browserDriver() {
        return new Object[][]{
                new Object[]{driver}
        };
    }

    @DataProvider(name = "userInfo")
    public static Object[][] userInfo() {
        return new Object[][]{
                new Object[]{username, password}
        };
    }

    @Test(priority = 1)
    public void contactInfo() {
      System.out.println("Contact Driver Name :"+driver.toString());
        Map<String, String> contactInfo = new HashMap<>();
        contactInfo.put("firstName", "Maroti");
        contactInfo.put("lastName", "Pawar");
        contactInfo.put("phone", "9923230741");
        contactInfo.put("userName", "pr.maroti@gmail.com");
        baseLayer.findElementByNameAndSendKeys(driver, contactInfo);
    }

    @Test(priority = 2)
    public void mailingInfo() {
        System.out.println("Mailing Info Driver Name :" + driver.toString());
        Map<String, String> mailingInfo = new HashMap<>();
        mailingInfo.put("address1", "Nanded");
        mailingInfo.put("city", "Nanded");
        mailingInfo.put("state", "Maharashtra");
        mailingInfo.put("postalCode", "410001");
        mailingInfo.put("country", "India");
        baseLayer.findElementByNameAndSendKeys(driver, mailingInfo);

    }

    @Test(priority = 3)
    public void userInformation() {
        System.out.println("User Info Driver Name :" + driver.toString());
        Map<String, String> user = new HashMap<>();
        user.put("email", "pr.maroti@gmail.com");
        user.put("password", "12345");
        user.put("confirmPassword", "12345");
        baseLayer.findElementByNameAndSendKeys(driver, user);
        username = user.get("email");
        password = user.get("password");

    }

    @Test(priority = 4)
    public void submit() throws InterruptedException {
        System.out.println("Submit Driver Name :" + driver.toString());
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

}
