package TestNG_xml_config_classes;

import org.testng.annotations.*;

public class LoginTests {

    @Test
    public void validLoginTest() {
        System.out.println("Running valid login test");
    }

    @Test
    public void logoutTest() {
        System.out.println("Running logout test");
    }

    @Test
    public void invalidLoginTest() {
        System.out.println("Running invalid login test");
    }
}
