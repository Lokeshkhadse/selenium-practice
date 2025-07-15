package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataSorted {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List<WebElement> dueColumn = driver.findElements(By.xpath("//td[4]"));

        List<Double> dueAmounts = new ArrayList<>();

        System.out.println("Original Due Amounts:");
        for (WebElement cell : dueColumn) {
            String amountText = cell.getText().replace("$", "").trim();
            System.out.println("$" + amountText);
            dueAmounts.add(Double.parseDouble(amountText)); // convert to number
        }

        // Sort the due amounts
        Collections.sort(dueAmounts);

        System.out.println("\nSorted Due Amounts:");
        for (Double amt : dueAmounts) {
            System.out.println("$" + amt);
        }

        driver.quit();
    }
}
