package com.maroti.assignment.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class FirstCryMouseOver {
    public static void main(String[] args) {
        int count=0;
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.firstcry.com");
        driver.manage().window().maximize();
        WebElement toysMenu =driver.findElement(By.xpath("//div[@class='menu-container']/ul/child::li[5]"));
        Actions act = new Actions(driver);
        act.moveToElement(toysMenu).build().perform();
        List<WebElement> toysSubMenu =driver.findElements(By.xpath("//div[@class='option-container submenu1-4']/ul"));
        for(WebElement subMenu : toysSubMenu){
            count++;
            System.out.println("Toys Sub Menu :"+subMenu.getText());
        }
        System.out.println("Toys Sub menu total : "+count);
    }
}
/*OUTPUT:
Toys Sub Menu :SHOP BY CATEGORY
Musical Toys
Learning & Educational Toys
Soft Toys
Backyard Play
Play Gyms & Playmats
Sports & Games
Role & Pretend Play Toys
Blocks & Construction Sets
Stacking Toys
Kids Puzzles
Baby Rattles
Toys Cars Trains & Vehicles
Kids Musical Instruments
Dolls & Dollhouses
Push & Pull Along Toys
Art Crafts & Hobby Kits
Board Games
Toys Sub Menu :Action Figures & Collectibles
Radio & Remote Control Toys
Bath Toys
Toys Guns & Weapons
PC Games & Gaming Consoles
Kids Gadgets NEW
RIDE-ONS & SCOOTERS
Battery Operated Ride-ons
Manual Push Ride-ons
Swing cars/twisters
Scooters
Rocking Ride Ons
Tricycles
Bicycles
Balance Bike
COMBO PACKS
Toys Sub Menu :BOARD GAMES
IQ Games
Ludo, Snakes & Ladders
Words, Pictures & Scrabble Games
Playing Cards
Life & Travel Board Games
Animal, Birds & Marine Life Games
Business/Monopoly
HOME PLAY ACTIVITIES
Play Dough, Sand & Moulds
Coloring, Sequencing & Engraving Art
Activity Kit
Building Construction Sets
Multi Model Making Sets
Kitchen Sets
Play Foods
Kids' Doctor Sets
Piano & Keyboards
Drum Sets & Percussion
Toys Sub Menu :SHOP BY BRANDS
Fisher Price
Intellikit
Babyhug
Intelliskills
Intellibaby
Fab n Funky
Hotwheels
Disney
Barbie
Giggles
Lego
Bonfino
Pine Kids
SHOP BY PRICE
Under 299
Under 499
Under 699
Under 999
Toys Sub Menu :
Toys Sub menu total : 5
*/
