package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Date_Picker {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/datepicker/");

        // 💡 Switch to the iframe first
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        driver.findElement(By.id("datepicker")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[text()='16']")).click();

        // Optional: print selected date
        String selectedDate = driver.findElement(By.id("datepicker")).getAttribute("value");
        System.out.println("Selected date is: " + selectedDate);

        driver.quit();
    }
}
