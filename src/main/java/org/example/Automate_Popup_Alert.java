package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automate_Popup_Alert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();


        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
         driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();

        Thread.sleep(4000);

        driver.switchTo().alert().sendKeys("lokesh");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();

    }
}

//accept means -> ok
//dismiss means -> cancel