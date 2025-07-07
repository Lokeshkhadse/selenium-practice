package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragDrop {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

//        driver.get("https://jqueryui.com/droppable/");
//
//        WebElement iframe = driver.findElement(By.className("demo-frame"));
//        driver.switchTo().frame(iframe);
//
//        WebElement draggableItem = driver.findElement(By.id("draggable"));
//        WebElement droppablePlace = driver.findElement(By.id("droppable"));
//
//        Thread.sleep(3000);
//
//        Actions action = new Actions(driver);
//        action.dragAndDrop(draggableItem,droppablePlace).build().perform();



        //Example 2

        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

            WebElement iframe = driver.findElement(By.cssSelector(".demo-frame.lazyloaded"));
        driver.switchTo().frame(iframe);

        WebElement draggableItem = driver.findElement(By.xpath("//*[@id=\"gallery\"]/li[3]"));
        WebElement droppablePlace = driver.findElement(By.id("trash"));

        Thread.sleep(3000);

        Actions action = new Actions(driver);
        action.dragAndDrop(draggableItem,droppablePlace).build().perform();

    }
}
