package com.maroti;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;

import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private WebDriver driver;

    @BeforeClass
    public void loadDriver(){
        ChromeDriverService service = new ChromeDriverService.Builder().build();
        driver = new ChromeDriver(service);
    }

    @Test
    public void validateUrl(){
         try {
                driver.get("https://google.com");
                /* driver.navigate().to("https://www.selenium.dev");
                driver.navigate().back();
                driver.navigate().refresh();*/

                String  name=driver.getWindowHandle();
                System.out.println("Window Handle name:"+name);
                driver.manage().window().maximize();
               int width=driver.manage().window().getSize().getWidth();
               int height = driver.manage().window().getSize().getHeight();

             System.out.println("Width: "+ width + "Height : "+height);

             File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
             FileUtils.copyFile(srcFile, new File("./image.jpg"));

         } catch (IOException e) {
             throw new RuntimeException(e);
         } finally {

            }

    }




    /*@Test
    public void validateTitle(){
        String title=driver.getTitle();
        assertEquals(title, "Google");
    }

    @Test
    public void search(){
        WebElement element =driver.findElement(By.name("q"));
        element.sendKeys("Samsung galaxy A54", Keys.ENTER);
    }
    @Test
    public void validateSearch(){
        WebElement element=new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
        String text=element.getText();
        assertEquals(text,"Buy Galaxy A54 5G - Price & Offers | Samsung India");
        element.click();

    }
*/
}
