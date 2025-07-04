package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateCheckoutRadioButton {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[@type=\"checkbox\"][1]"));
        Thread.sleep(3000);
        checkbox1.click();

        WebElement checkbox2 = driver.findElement(By.xpath("//form[@id=\"checkboxes\"]/input[@type=\"checkbox\"][2]"));
        checkbox2.click();
    }
}
