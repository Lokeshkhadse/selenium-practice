package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SearchSuggestion {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium");
       Thread.sleep(4000);

        boolean clicked = false;

        // Loop max 3 times to handle re-rendering (if Google refreshes DOM)
        for (int attempt = 0; attempt < 3; attempt++) {
            List<WebElement> suggestions = driver.findElements(By.xpath("//ul[@role='listbox']//li//span"));

            for (WebElement suggestion : suggestions) {
                String text = suggestion.getText();
                System.out.println("👉 Suggestion: " + text);

                if (text.equalsIgnoreCase("selenium webdriver")) {
                    suggestion.click();
                    clicked = true;
                    break;
                }
            }


            if (clicked) break;

            // Optional short wait before retry
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }

        if (!clicked) {
            System.out.println("❌ 'selenium webdriver' suggestion not found.");
        }
    }
}
