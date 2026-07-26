package com.saucedemo.web;

import com.saucedemo.web.pages.HomePage;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertTrue;

public class FooterTest extends BaseTest {
    @Test
    public void verifyFacebookIconIsVisibleInFooterSectionShouldSucceed() {

        HomePage homePage = goTo(new HomePage(page));

        Locator facebookIcon = homePage.getFooter().getFacebookIconLocator();
        String expectedUrl = facebookIcon.getAttribute("href");

        assertThat(facebookIcon).isVisible();

        Page newPage = page.waitForPopup(facebookIcon::click);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        String actualUrl = newPage.url();
        assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void verifyTwitterIconIsVisibleInFooterSectionShouldSucceed() {
        HomePage homePage = goTo(new HomePage(page));

        Locator twitterIcon = homePage.getFooter().getTwitterIconLocator();
        String expectedUrl = twitterIcon.getAttribute("href");

        assertThat(twitterIcon).isVisible();

        Page newPage = page.waitForPopup(twitterIcon::click);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        String actualUrl = newPage.url();
        assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void verifyInstagramIconIsVisibleInFooterSectionShouldSucceed() {
        HomePage homePage = goTo(new HomePage(page));

        Locator instagramIcon = homePage.getFooter().getInstagramIconLocator();
        String expectedUrl = instagramIcon.getAttribute("href");

        assertThat(instagramIcon).isVisible();

        Page newPage = page.waitForPopup(instagramIcon::click);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        String actualUrl = newPage.url();
        assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void verifyLinkedinIconIsVisibleInFooterSectionShouldSucceed() {
        HomePage homePage = goTo(new HomePage(page));

        Locator linkedinIcon = homePage.getFooter().getLinkedinIconLocator();
        String expectedUrl = linkedinIcon.getAttribute("href");

        assertThat(linkedinIcon).isVisible();

        Page newPage = page.waitForPopup(linkedinIcon::click);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        String actualUrl = newPage.url();
        assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test
    public void verifyYouTubeIconIsVisibleInFooterSectionShouldSucceed() {
        HomePage homePage = goTo(new HomePage(page));

        Locator youTubeIcon = homePage.getFooter().getYouTubeIconLocator();
        String expectedUrl = youTubeIcon.getAttribute("href");

        assertThat(youTubeIcon).isVisible();

        Page newPage = page.waitForPopup(youTubeIcon::click);
        newPage.waitForLoadState(LoadState.DOMCONTENTLOADED);

        String actualUrl = newPage.url();
        assertTrue(actualUrl.contains(expectedUrl));
    }
}
