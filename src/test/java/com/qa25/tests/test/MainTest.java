package com.qa25.tests.test;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({AllureListener.class})
public class MainTest extends TestBase {

    @BeforeMethod
    public void insurePreconditions()  {
        if(!mainPage.ifLogoPresented()){
            driver.get(baseURL);
        }
    }

    @Test(priority = 1, groups = {"functional"},
            description = "Verify the User can login with valid credentials")
    @Description("Verify the User can login with valid credentials")
    @Epic("EP001")
    @Feature("Login")
    @Story("Story: success login")
    @Step("Login positive")
    @Severity(SeverityLevel.BLOCKER)
    public void checkLoginPositiveTest()  {
        String login = "tester";
        String password = "K35G3U";

        //Fill login field
        mainPage.fillLoginField(login);

        //Fill password field
        mainPage.fillPasswordField(password);

        //Click login button
        mainPage.clickLoginButton();

        //Verify if user is logged in
        Assert.assertTrue(mainPage.ifUserSectionPresented(), "User is not logged in");

    }

    @Test(priority = 1, groups = {"functional"},
            description = "Verify the User can't login with invalid credentials")
    @Description("Verify the User can't login with invalid credentials")
    @Epic("EP001")
    @Feature("Login")
    @Story("Story: unsuccess login")
    @Step("Login negative")
    @Severity(SeverityLevel.BLOCKER)
    public void checkLoginNegativeTest()  {
        String login = "tqwert";
        String password = "K35G3U";

        //Fill login field
        mainPage.fillLoginField(login);

        //Fill password field
        mainPage.fillPasswordField(password);

        //Click login button
        mainPage.clickLoginButton();

        //Verify if user can't log in
        Assert.assertTrue(mainPage.ifErrorPresented(), "There is no error message");

    }

    @Test(enabled = true, priority = 0, groups = {"UI"},
            description = "Verify the Logo is presented")
    @Description("Verify the Logo is presented")
    @Epic("EP001")
    @Feature("Login screen")
    @Story("Story: logo")
    @Step("Check the logo")
    @Severity(SeverityLevel.MINOR)
    public void isLogoPresentedTest(){
        Assert.assertTrue(mainPage.ifLogoPresented(), "Logo is not presented");
    }

    @Test(enabled = true,priority = 0, groups = {"UI"},
            description = "Verify the Remember me check-box is presented")
    @Description("Verify the Remember me check-box is presented")
    @Epic("EP001")
    @Feature("Login screen")
    @Story("Story: check-box")
    @Step("Check the Remember me check-box")
    @Severity(SeverityLevel.NORMAL)
    public void isCheckBoxPresentedTest(){
        Assert.assertTrue(mainPage.ifCheckBoxPresented(), "Check box is not presented");
    }

    @Test(enabled = true,priority = 0, groups = {"UI"},
            description = "Verify the Login buttons are presented")
    @Description("Verify the Login buttons are presented")
    @Epic("EP001")
    @Feature("Login screen")
    @Story("Story: Login buttons")
    @Step("Check the Login buttons ")
    @Severity(SeverityLevel.NORMAL)
    public void isLoginButtonsPresentedTest(){
        int res = mainPage.countLoginButtons();
        System.out.println("Number of login buttons = " + res);
        Assert.assertEquals(res,3,"The invalid number of buttons");
    }

    @Test(priority = 2, groups = {"UI"},
            description = "Verify how the skipping works")
    @Description("Verify how the skipping works")
    @Epic("EP001")
    @Feature("Login screen")
    @Story("Story: skipping the test")
    @Step("Check skipping the test")
    @Severity(SeverityLevel.MINOR)
    public void forSkipTest(){
        throw new SkipException("Skipping this test");
    }

    @Test(enabled = true,priority = 2, groups = {"UI"},
            description = "Verify the Login buttons are presented for test failure example")
    @Description("Verify the Login buttons are presented for test failure example")
    @Epic("EP001")
    @Feature("Login screen")
    @Story("Story: failure the test")
    @Step("Check failure the test")
    @Severity(SeverityLevel.NORMAL)
    public void isLoginButtonsPresentedNegativeTest(){
        int res = mainPage.countLoginButtons();
        System.out.println("Number of login buttons = " + res);
        Assert.assertEquals(res,1,"The invalid number of buttons");
    }

    @AfterMethod
    public void insurePostconditions(){
        driver.close();
    }

}
