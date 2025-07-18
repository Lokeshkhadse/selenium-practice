package TestNG_xml_config_classes;


import org.testng.annotations.*;

public class OrderTests {

    @Test(groups = "smoke")
    public void createOrderTest() {
        System.out.println("Creating order test");
    }

    @Test
    public void cancelOrderTest() {
        System.out.println("Cancelling order test");
    }
}
