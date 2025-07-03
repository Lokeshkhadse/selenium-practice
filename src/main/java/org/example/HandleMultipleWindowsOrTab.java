package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleMultipleWindowsOrTab {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();

        driver.get("https://www.myntra.com/men-casual-shoes");
        driver.manage().window().maximize();

       String parentTitle =  driver.getTitle();
        System.out.println("parent title page " + parentTitle);

        driver.findElement(By.xpath("//*[@id=\"33620364\"]/a/div[1]/div/div/div/picture/img")).click();

        Set<String> handle = driver.getWindowHandles();
        Iterator<String> it = driver.getWindowHandles().iterator();  //or handle.iterator();

        String parentwindowId = it.next();
        System.out.println(parentwindowId);

        String childwindowId = it.next();
        System.out.println(childwindowId);

        driver.switchTo().window(childwindowId);
        String childTitle = driver.getTitle();

        System.out.println("child title - >" + childTitle);




    }
}


