package TestNG_xml_config_classes;


import org.testng.annotations.*;

public class ProductTests {

    @Test(groups = "regression")
    public void addProductTest() {
        System.out.println("Adding product test");
    }

    @Test(groups = "smoke")
    public void viewProductTest() {
        System.out.println("Viewing product test");
    }
}
