package com.maroti.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class FacebookExample {

    public static String reverseTitle(){
        String rev = "";
         WebDriver driver =new ChromeDriver();
         driver.get("https://www.facebook.com");
         String title= driver.getTitle();
         String facebook =title.substring(0,8);
         String remText=title.substring(8,28);
         for(int i=facebook.length()-1; i>=0; i--){
                rev+=facebook.charAt(i);
            }
            return rev+remText;
    }
    public static void main(String[] args) {
        String revString=reverseTitle();
        System.out.println(revString);
    }
}
