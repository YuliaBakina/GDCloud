package com.qa25.tests.test;

import com.qa25.tests.fw.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    String baseURL = "https://gdcloud.ru/release-17/auth/login";
    MainPage mainPage;

    @BeforeMethod(alwaysRun = true)
    public void init() {

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get(baseURL);

        mainPage = new MainPage(driver);

     }

    @AfterMethod(alwaysRun = true, enabled = false)
    public void stop() {
        driver.quit();
    }

}
