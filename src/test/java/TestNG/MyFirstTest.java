package TestNG;

import org.testng.annotations.Test;
import org.testng.Assert;

public class MyFirstTest {

    @Test
    public void testAddition() {
        int sum = 5 + 3;
        Assert.assertEquals(sum, 8);
    }

    @Test
    public void substraction(){
        int sub = 5-3;
        Assert.assertEquals(sub ,2);
    }
}
