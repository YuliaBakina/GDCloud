package com.qa25.tests.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends HelperBase{

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void fillLoginField(String text) {
      type(By.id("username"),text);
    }

    public void fillPasswordField(String text) {
        type(By.id("password"),text);
    }

    public void clickLoginButton() {
        click(By.id("login_button"));
    }

    public boolean ifUserSectionPresented() {
        return ifElementExists(By.cssSelector("[class='username-section']"));
    }

    public boolean ifErrorPresented() {
        return ifElementExists(By.id("error"));
    }

    public boolean ifLogoPresented() {
        return ifElementExists(By.className("login_corp"));

    }

    public boolean ifCheckBoxPresented() {
        return ifElementExists(By.cssSelector("[class='checkbox first']"));
    }

    public int countLoginButtons() {
        List<WebElement> list = getItemsList(By.cssSelector("[class='login-button']"));
        return list.size();
    }
}
