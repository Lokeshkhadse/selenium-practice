package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scroll_Up_Down {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) driver;

//        // Scroll down 5 times
//        for (int i = 0; i < 5; i++) {
//            Thread.sleep(2000);
//            js.executeScript("window.scrollBy(0, 1000);");    //(0,1000) -> x axis , y axis
//                                                                    // x -> (+) scroll right , (-) scroll left
//        }                                                        // y -> (+) scroll downward , (-) scroll upward
//
//        // Scroll up 2 times
//        for (int i = 0; i < 2; i++) {
//            js.executeScript("window.scrollBy(0, -1000);");
//            Thread.sleep(2000);
//
//        }
        for (int i = 0; i < 6; i++) {
            Thread.sleep(1500);
            js.executeScript("window.scrollBy(0, 1000);");
        }

        Thread.sleep(3000);
        WebElement scrollTillHereValue = driver.findElement(By.xpath("//*[@id='content']/div/div/div/div/div[5]"));
        js.executeScript("arguments[0].scrollIntoView(true);", scrollTillHereValue);
        Thread.sleep(2000);
        driver.quit();
    }
}
