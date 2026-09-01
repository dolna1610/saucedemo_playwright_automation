package com.saucedemo.web;

import com.saucedemo.web.pages.HomePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.saucedemo.web.pages.ProductPage;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class FooterTest extends BaseTest {
    @Test(groups = {"smoke"})
    public void verifyFacebookIconIsVisibleInFooterSectionShouldSucceed() {

        ProductPage productPage = login();

        Locator facebookIcon = productPage.getFooter().getFacebookIconLocator();
        String expectedUrl = facebookIcon.getAttribute("href");

        assertThat(facebookIcon).isVisible();

        Page newPage = page.waitForPopup(facebookIcon::click);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        String actualUrl = newPage.url();
        assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test(groups = {"smoke"})
    public void verifyTwitterIconIsVisibleInFooterSectionShouldSucceed() {
        ProductPage productPage = login();

        Locator twitterIcon = productPage.getFooter().getTwitterIconLocator();
        String expectedUrl = twitterIcon.getAttribute("href");

        assertThat(twitterIcon).isVisible();

        Page newPage = page.waitForPopup(twitterIcon::click);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        String actualUrl = newPage.url();

        assertTrue(actualUrl.contains("twitter.com") || actualUrl.contains("x.com"));
    }

    @Test(groups = {"smoke"})
    public void verifyLinkedinIconIsVisibleInFooterSectionShouldSucceed() {
        ProductPage productPage = login();

        Locator linkedinIcon = productPage.getFooter().getLinkedinIconLocator();
        String expectedUrl = linkedinIcon.getAttribute("href");

        assertThat(linkedinIcon).isVisible();

        Page newPage = page.waitForPopup(linkedinIcon::click);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        String actualUrl = newPage.url();

        assertTrue(actualUrl.contains("linkedin.com"));
    }
}
