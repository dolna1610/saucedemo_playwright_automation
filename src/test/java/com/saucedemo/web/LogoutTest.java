package com.saucedemo.web;

import com.saucedemo.web.pages.LoginPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LogoutTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void verifyCheckoutPageLoad(){
        login();
        LoginPage loginPage = new LoginPage(page);
        loginPage.clickMenuBar()
                .clickLogoutButton();
        loginPage.waitForPageLoad();
    }

    @Test(groups = {"smoke"})
    public void verifyLogoutFunctionality(){
        login();
        LoginPage loginPage = new LoginPage(page);
        loginPage.clickMenuBar()
                .clickLogoutButton();
        loginPage.waitForPageLoad();
        assertThat(loginPage.getLoginButtonLocator()).isVisible();
    }
}
