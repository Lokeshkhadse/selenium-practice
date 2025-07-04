package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class File_Upload {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/upload");

            // Upload file
        WebElement fileUpload = driver.findElement(By.id("file-upload"));
        Thread.sleep(3000);
        fileUpload.sendKeys("C:\\Users\\Sreenivas Bandaru\\Downloads\\MBA_ADMITCARD.pdf");
        Thread.sleep(3000);

            // Click Upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        Thread.sleep(3000);
        uploadButton.click();




    }
}
