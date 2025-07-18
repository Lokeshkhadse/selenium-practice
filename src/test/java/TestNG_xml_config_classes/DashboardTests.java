package TestNG_xml_config_classes;


import org.testng.annotations.*;

public class DashboardTests {

    @Test
    public void userDashboardTest() {
        System.out.println("User dashboard test");
    }

    @Test(groups = "regression")
    public void adminDashboardTest() {
        System.out.println("Admin dashboard test");
    }
}
