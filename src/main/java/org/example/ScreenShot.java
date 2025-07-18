package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShot {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriver driver = new ChromeDriver();


//       driver.get("https://jqueryui.com/droppable/");
//
//       TakesScreenshot take_screenshot = (TakesScreenshot) driver;
//
//        File src = take_screenshot.getScreenshotAs(OutputType.FILE); //OutputType.FILE is used when you want the screenshot in file format
//
//        FileHandler.copy(src,new File("C:/Users/Sreenivas Bandaru/Videos/Screenshot/first.jpeg"));


        //EXAMPLE 2

//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        // Step 1: Go to droppable page
//        driver.get("https://jqueryui.com/droppable/");
//        Thread.sleep(2000);
//
//        // Step 2: Full page screenshot
//        TakesScreenshot fullPageSS = (TakesScreenshot) driver;
//        File fullPageSrc = fullPageSS.getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(fullPageSrc, new File("C:/Users/Sreenivas Bandaru/Videos/Screenshot/step1_droppable_page.jpeg"));
//
//        // Step 3: Locate and take screenshot of 'Development' element
//        WebElement development = driver.findElement(By.xpath("//*[@id='menu-top']/li[5]/a"));
//        File devElementSS = development.getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(devElementSS, new File("C:/Users/Sreenivas Bandaru/Videos/Screenshot/step2_development_element.jpeg"));
//
//        // Step 4: Click on 'Development'
//        development.click();
//        Thread.sleep(3000); // wait for page to load
//
//        // Step 5: Take screenshot of new page
//        File devPageSS = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        FileHandler.copy(devPageSS, new File("C:/Users/Sreenivas Bandaru/Videos/Screenshot/step3_development_page.jpeg"));
//
//        driver.quit();




         // EXAMPLE 3

        driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         driver.get("https://the-internet.herokuapp.com/");
         Thread.sleep(3000);

         //take a whole page ss
        TakesScreenshot page = (TakesScreenshot) driver;
        File src1 = page.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src1,new File("C:\\Users\\Sreenivas Bandaru\\Videos\\Screenshot\\Example3_1.jpeg"));

        //element ss
        WebElement checkboxEleSS = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a"));
        File src2 = checkboxEleSS.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src2,new File("C:\\Users\\Sreenivas Bandaru\\Videos\\Screenshot\\Example3_2.jpeg"));

        //click
        checkboxEleSS.click();
        Thread.sleep(2000);

        //Take screenshot of new page
        File src3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src3,new File("C:\\Users\\Sreenivas Bandaru\\Videos\\Screenshot\\Example3_3.jpeg"));
    }
}
