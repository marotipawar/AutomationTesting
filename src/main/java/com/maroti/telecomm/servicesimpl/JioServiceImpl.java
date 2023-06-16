package com.maroti.telecomm.servicesimpl;

import com.maroti.telecomm.model.Customer;
import com.maroti.telecomm.model.TariffPlan;
import com.maroti.telecomm.services.JioServices;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Slf4j
public class JioServiceImpl implements JioServices {
    private WebDriver driver;
    private String custId;



    @Override
    public WebDriver start(WebDriver driver,String url) {
        this.driver = driver;
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    @Override
    public void addCustomer() {

        driver.findElement(By.xpath("//a[@href='addcustomer.php']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        Customer customer =getCustomer();

        JavascriptExecutor ex = (JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();", customer.getBackground());
        if(checkElementStatus(customer.getFirstName()))customer.getFirstName().sendKeys("Maroti");
        if(checkElementStatus(customer.getLastName()))customer.getLastName().sendKeys("Pawar");
        if(checkElementStatus(customer.getEmail()))customer.getEmail().sendKeys("pr.maroti@gmail.com");
        if(checkElementStatus(customer.getEmail()))customer.getMobile().sendKeys("9876543210");
        if(checkElementStatus(customer.getEmail()))customer.getAddress().sendKeys("Somewhere in Maharashtra");
        if(checkElementStatus(customer.getBtnSubmit()))customer.getBtnSubmit().click();
        String customerId=driver.findElement(By.xpath("//table[@class='alt access']/tbody/tr[1]/td[2]/h3")).getText();
        System.out.println("Customer ID :"+ customerId);
        setCustId(customerId);
        driver.findElement(By.xpath("//a[@href='index.html']")).click();

    }

    @Override
    public void setTariffPlan() {
        driver.findElement(By.xpath("//div/h3/a[@href='addtariffplans.php']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        TariffPlan plan = getTariffPlan();
        if(checkElementStatus(plan.getRental()))plan.getRental().sendKeys("459");
        if(checkElementStatus(plan.getLocal_minutes()))plan.getLocal_minutes().sendKeys("10000");
        if(checkElementStatus(plan.getInter_minutes()))plan.getInter_minutes().sendKeys("50000");
        if(checkElementStatus(plan.getSms_pack()))plan.getSms_pack().sendKeys("1000");
        if(checkElementStatus(plan.getMinutes_charges()))plan.getMinutes_charges().sendKeys("2");
        if(checkElementStatus(plan.getInter_charges()))plan.getInter_charges().sendKeys("4");
        if(checkElementStatus(plan.getSms_charges()))plan.getSms_charges().sendKeys("1");
        if(checkElementStatus(plan.getBtnSubmit()))plan.getBtnSubmit().click();
        WebElement status=driver.findElement(By.xpath("//div/h2"));
        System.out.println("Add Tariff Plan :"+status.getText());
        driver.findElement(By.xpath("//a[@href='index.html']")).click();

    }
    public TariffPlan getTariffPlan(){
        return TariffPlan.builder()
                .rental(driver.findElement(By.xpath("//input[@name='rental']")))
                .local_minutes(driver.findElement(By.xpath("//input[@name='local_minutes']")))
                .inter_minutes(driver.findElement(By.xpath("//input[@name='inter_minutes']")))
                .sms_pack(driver.findElement(By.xpath("//input[@name='sms_pack']")))
                .minutes_charges(driver.findElement(By.xpath("//input[@name='minutes_charges']")))
                .inter_charges(driver.findElement(By.xpath("//input[@name='inter_charges']")))
                .sms_charges(driver.findElement(By.xpath("//input[@name='sms_charges']")))
                .btnSubmit(driver.findElement(By.xpath("//input[@name='submit']")))
                .build();
    }

    @Override
    public Customer getCustomer() {

        return  Customer.builder()
                .background(driver.findElement(By.xpath("//input[@id='done']")))
                .firstName(driver.findElement(By.xpath("//input[@name='fname']")))
                .lastName(driver.findElement(By.xpath("//input[@name='lname']")))
                .email(driver.findElement(By.xpath("//input[@name='emailid']")))
                .address(driver.findElement(By.xpath("//textarea[@name='addr']")))
                .mobile(driver.findElement(By.xpath("//input[@name='telephoneno']")))
                .btnSubmit(driver.findElement(By.xpath("//input[@name='submit']")))
                .btnReset(driver.findElement(By.xpath("//input[@class='alt']")))
                .build();
    }

    @Override
    public void addTariffPlanToCustomer() {
        driver.findElement(By.xpath("//div/h3/a[@href='assigntariffplantocustomer.php']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys("528842");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        WebElement plan=driver.findElement(By.xpath("//input[@name='tariff_plan']"));
        JavascriptExecutor exe = (JavascriptExecutor)driver;
        exe.executeScript("arguments[0].click()",plan);
        driver.findElement(By.xpath("//input[@class='fit']")).click();
        String result=driver.findElement(By.xpath("//section[@class='wrapper']/div/h2")).getText();
        System.out.println("Plan Status :"+ result);
        driver.findElement(By.xpath("//a[@href='index.html']")).click();
    }

    @Override
    public void payBill() {
        driver.findElement(By.xpath("//div/h3/a[@href='billing.php']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));

        driver.findElement(By.xpath("//input[@name='customer_id']")).sendKeys("528842");
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        String customerDetails=driver.findElement(By.xpath("//div[@class='inner']/h3")).getText();
        System.out.println(customerDetails);
        String plan=driver.findElement(By.xpath("//table[@class='alt']/tbody/tr[4]/td[2]")).getText();
        String usagesCharge=driver.findElement(By.xpath("//table[@class='alt']/tbody/tr[5]/td[2]")).getText();
        String totalBill=driver.findElement(By.xpath("//table[@class='alt']/tbody/tr[6]/td[2]")).getText();
        System.out.println("Tariff Plan Amount :"+plan);
        System.out.println("Usages Charges :"+usagesCharge);
        System.out.println("Total Bill :"+totalBill);
    }

    public boolean checkElementStatus(WebElement element){
        return element.isDisplayed()&&element.isEnabled();
    }



    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
}
