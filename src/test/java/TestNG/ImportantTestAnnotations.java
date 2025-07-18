package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ImportantTestAnnotations {

    // 1️⃣ Test with priority = 1
    @Test(priority = 1, description = "Login test to verify credentials")
    public void loginTest() {
        System.out.println("✅ loginTest - Valid login check");
        Assert.assertTrue(true); // Simulate login success
    }

    // 2️⃣ Test depends on loginTest (runs only if loginTest passes)
    @Test(priority = 2, dependsOnMethods = "loginTest", description = "Dashboard test after login")
    public void dashboardTest() {
        System.out.println("✅ dashboardTest - Dashboard loaded after login");
    }

    // 3️⃣ Disabled test (won’t run)
    @Test(enabled = false, description = "Feature under development")
    public void underDevelopmentTest() {
        System.out.println("🚧 This test is disabled");
    }

    // 4️⃣ Test runs 3 times
    @Test(priority = 3, invocationCount = 3, description = "Repeated search to validate stability")
    public void searchTest() {
        System.out.println("🔁 Running searchTest (load test)");
    }

    // 5️⃣ Test must finish within 1 second (1000 ms)
    @Test(priority = 4, timeOut = 1000, description = "Slow operation with timeout")
    public void timeSensitiveTest() throws InterruptedException {
        Thread.sleep(500); // Simulates delay
        System.out.println("⏱ timeSensitiveTest completed within time");
    }

    // 6️⃣ Test belonging to "smoke" group
    @Test(priority = 5, groups = {"smoke"}, description = "Smoke test for quick checks")
    public void smokeTest() {
        System.out.println("🔥 smokeTest running as part of 'smoke' group");
    }

    // 7️⃣ Test expecting an exception
    @Test(priority = 6, expectedExceptions = ArithmeticException.class, description = "Exception handling test")
    public void exceptionTest() {
        System.out.println("💥 exceptionTest should throw ArithmeticException");
        int result = 1 / 0; // Throws ArithmeticException
    }
}
