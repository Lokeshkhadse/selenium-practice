package DB_ConnectionScenario;


//scenario
//Selenium → Fill "Register" form → Submit
//↓
//Connect to DB → Run SELECT query to check if data inserted

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.*;
import java.time.Duration;

public class Selenium_DB_Connection {

    public static void main(String[] args) {
        String name = "Lokesh";
        String email = "lokesh@gmail.com";
        String phone = "1234567890";

        WebDriver driver = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Step 1: Launch browser and fill the form
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get("http://localhost:3000/register");

            driver.findElement(By.id("name")).sendKeys(name);
            driver.findElement(By.id("email")).sendKeys(email);
            driver.findElement(By.id("phone")).sendKeys(phone);
            driver.findElement(By.id("submit")).click();


            // Step 2: Connect to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");

            String query = "SELECT name, email, phone FROM Employee WHERE email = ?";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                String dbName = rs.getString("name");
                String dbEmail = rs.getString("email");
                String dbPhone = rs.getString("phone");

                if (dbName.equals(name) && dbEmail.equals(email) && dbPhone.equals(phone)) {
                    System.out.println("✅ Data is properly added to DB.");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("❌ Something went wrong: Data not found in DB.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Step 3: Cleanup
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
                if (driver != null) driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
