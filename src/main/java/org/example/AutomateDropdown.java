package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutomateDropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/dropdown");



        List<WebElement>dropdownList =  driver.findElements(By.xpath("//option"));
        Thread.sleep(2000);
        System.out.println(dropdownList);

       for(WebElement dropdownName:dropdownList){
           String dropName = dropdownName.getText();

           if(dropName.equals("Option 2")){
               dropdownName.click();
               System.out.println("dipdownname is -> " + dropName);
               break;
           }
       }

    }
}
