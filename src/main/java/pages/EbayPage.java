package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EbayPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public EbayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToHomePage() {
        driver.get("https://www.ebay.com");
        driver.manage().window().maximize();
    }

    public void searchProduct(String productName) {
        WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("gh-ac")));
        searchBox.sendKeys(productName);
        WebElement searchButton = driver.findElement(By.id("gh-search-btn"));
        searchButton.click();
    }

    public void clickFirstProductFromCarousel() {
        try {
            WebElement firstResult = wait.until(ExpectedConditions.presenceOfElementLocated(
                    By.className("s-item__link")));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", firstResult);
            Thread.sleep(1000); // Small wait to stabilize layout
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstResult);
            Thread.sleep(3000); // Small wait to stabilize layout


        } catch (Exception e) {
            System.out.println("❌ Failed to click first product: " + e.getMessage());
        }
    }

}
