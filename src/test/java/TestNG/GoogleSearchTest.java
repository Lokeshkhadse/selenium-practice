package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;

public class GoogleSearchTest {

    WebDriver driver;

    // 🔹 Runs once before all tests (e.g., DB setup, report init)
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("✅ [BeforeSuite] Setup global test suite (DB, logs, reports)");
    }

    // 🔹 Runs before any <test> tag in testng.xml
    @BeforeTest
    public void beforeTest() {
        System.out.println("🚀 [BeforeTest] Setup test environment (browser, config)");
    }

    // 🔹 Runs once before all tests in this class
    @BeforeClass
    public void setup() {
        System.out.println("🔧 [BeforeClass] Launching Chrome browser");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    // 🔹 Runs before each @Test method
    @BeforeMethod
    public void beforeEachTest() {
        System.out.println("📄 [BeforeMethod] Opening Google homepage before each test");
        driver.get("https://www.google.com");
    }

    // 🧪 Test case 1 (priority = 1)
    @Test(priority = 1)
    public void searchIPhoneTest() {
        System.out.println("🔍 [Test - Priority 1] Searching for 'iPhone'");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("iPhone");
        searchBox.submit();

    }

//    // 🧪 Test case 2 (priority = 2)
//    @Test(priority = 2)
//    public void searchSeleniumTest() {
//        System.out.println("🔍 [Test - Priority 2] Searching for 'Selenium Tutorial'");
//
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("Selenium Tutorial");
//        searchBox.submit();
//
//        WebElement result = driver.findElement(By.id("result-stats"));
//        Assert.assertTrue(result.isDisplayed(), "❌ Results not displayed for Selenium");
//    }

    // 🔹 Runs after each @Test method
    @AfterMethod
    public void afterEachTest() {
        System.out.println("🧹 [AfterMethod] Finished test method");
    }

    // 🔹 Runs once after all tests in the class
    @AfterClass
    public void tearDown() {
        System.out.println("❌ [AfterClass] Closing the browser");
        if (driver != null) {
            driver.quit();
        }
    }

    // 🔹 Runs after all <test> tags in testng.xml
    @AfterTest
    public void afterTest() {
        System.out.println("📦 [AfterTest] Final cleanup after test group");
    }

    // 🔹 Runs once after all tests in the suite
    @AfterSuite
    public void afterSuite() {
        System.out.println("✅ [AfterSuite] All tests completed. Finalizing report");
    }
}
