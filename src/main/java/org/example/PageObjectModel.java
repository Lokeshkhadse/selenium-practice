package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EbayPage;

public class PageObjectModel {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            EbayPage ebayPage = new EbayPage(driver);

            ebayPage.goToHomePage();
            ebayPage.searchProduct("Headphones");
            ebayPage.clickFirstProductFromCarousel();

            String actualTitle = driver.getTitle();
            System.out.println("📝 Page Title: " + actualTitle);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
