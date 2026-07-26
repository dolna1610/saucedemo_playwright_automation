package com.saucedemo.web;

import com.saucedemo.web.pages.HomePage;
import com.saucedemo.web.pages.LoginPage;
import com.saucedemo.web.utils.Credential;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void loginShouldSucceed() {
        Credential credential = loadDefaultCredential();
        LoginPage loginPage = goTo(new LoginPage(page), credential.getBaseUrl());

        page.onDialog(dialog -> {
            System.out.println("Alert Message: " + dialog.message());
            dialog.accept();
        });

        loginPage.getTopbar()
                .getHeading()
                .fillUserName(credential.getUserName())
                .fillPassword(credential.getPassword())
                .clickLogin();
        this.page.waitForLoadState(LoadState.NETWORKIDLE);
        HomePage homePage = new HomePage(page);
        assertThat(homePage.getTopbar().getProductsLocator()).isVisible();
    }

    @Test(groups = {"smoke"})
    public void verifyLoginWithInvalidCredentialsShouldNotSucceed(){
        Credential credential=loadDefaultCredential();
        LoginPage loginPage=goTo(new LoginPage(page),credential.getBaseUrl());
        loginPage.getTopbar()
                .getHeading()
                .fillUserName("wrong username")
                .fillPassword("wrong password")
                .clickLogin();
        this.page.waitForLoadState(LoadState.NETWORKIDLE);
        HomePage homePage=new HomePage(page);
        assertThat(homePage.getError().getText());
    }

    @Test(groups = {"smoke"})
    public void verifyLoginWithEmptyFieldsShouldNotSucceed(){
        Credential credential=loadDefaultCredential();
        LoginPage loginPage=goTo(new LoginPage(page),credential.getBaseUrl());
        loginPage.getTopbar()
                .getHeading()
                .fillUserName("")
                .fillPassword("")
                .clickLogin();
        this.page.waitForLoadState(LoadState.NETWORKIDLE);
        HomePage homePage=new HomePage(page);
        assertThat(homePage.getError().isVisible());

    }

    @Test(groups = {"smoke"})
    public void verifyUserIsLogOutAfterClickingLogOutButtonShouldSucceed() {
        Credential credential = loadDefaultCredential();

        HomePage homePage = goTo(new HomePage(page),credential.getBaseUrl());

        homePage.getTopbar()
                .getHeading()
                .fillUserName(credential.getUserName())
                .fillPassword(credential.getPassword())
                .clickLogin()
                .clickMenuBar()
                .clickLogoutButton();
        this.page.waitForLoadState(LoadState.NETWORKIDLE);
        assertThat(homePage.getTitle()).isVisible();
    }
}
