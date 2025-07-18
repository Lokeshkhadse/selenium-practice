package TestNG;

import org.testng.annotations.Test;

public class AllDependenciesTest {

    // 🔹 Group: init
    @Test(groups = "init")
    public void setupEnvironment() {
        System.out.println("✅ setupEnvironment - [Group: init]");
    }

    // 🔹 Group: init
    @Test(groups = "init")
    public void loadTestData() {
        System.out.println("✅ loadTestData - [Group: init]");
    }

    // 🔸 Depends on Group: init
    @Test(dependsOnGroups = "init")
    public void loginTest() {
        System.out.println("🚀 loginTest - Depends on group 'init'");
    }

    // 🔸 Simple independent method
    @Test
    public void openHomePage() {
        System.out.println("🏠 openHomePage - Independent test");
    }

    // 🔸 Depends on Method: loginTest
    @Test(dependsOnMethods = "loginTest")
    public void openUserDashboard() {
        System.out.println("📊 openUserDashboard - Depends on loginTest");
    }

    // 🔸 Depends on Method: openUserDashboard
    @Test(dependsOnGroups = "openUserDashboard")
    public void updateUserProfile() {
        System.out.println("📝 updateUserProfile - Depends on openUserDashboard");
    }

    // 🔸 Depends on both group and method
    @Test(dependsOnGroups = "init", dependsOnMethods = "openHomePage")
    public void finalValidation() {
        System.out.println("✅ finalValidation - Depends on group 'init' and method 'openHomePage'");
    }
}
