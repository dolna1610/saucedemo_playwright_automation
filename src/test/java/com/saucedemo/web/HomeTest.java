package com.saucedemo.web;

import com.saucedemo.web.pages.*;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class HomeTest extends BaseTest {

    @Test(groups = {"smoke"})
    public void verifyLoginWithValidCredentialsShouldSucceed() {
        ProductPage productPage = login();

        assertThat(productPage.getProductTitleLocator())
                .containsText("Products");
    }

    @Test(groups = {"smoke"})
    public void verifyLoginButtonIsVisibleShouldSucceed() {
        HomePage homePage = goTo(new HomePage(page));

        assertThat(homePage.getTopbar()
                .getLoginButton())
                .isVisible();
    }
}