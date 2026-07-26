package com.saucedemo.web;

import com.saucedemo.web.components.DatePicker;
import com.saucedemo.web.pages.*;
import com.saucedemo.web.utils.Credential;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.BoundingBox;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotSame;
import static org.testng.AssertJUnit.assertTrue;

public class HomeTest extends BaseTest {

    @Test
    public void clickNotificationIconDisplaysNotificationDropdownShouldSucceed() {
        Credential credential = loadDefaultCredential();

        HomePage homePage = goTo(new HomePage(page));
        homePage.getTopbar()
                .getHeading()
                .fillUserName(credential.getUserName())
                .fillPassword(credential.getPassword())
                .clickLogin();

        homePage.getTopbar().clickNotificationIcon();

        assertThat(homePage.getTopbar().getNotificationDropdownLocator()).isVisible();
    }

    @Test
    public void changingTheHotDealsCardsAfterAnIntervalShouldSucceed() {
        HomePage homePage = goTo(new HomePage(page));

        Locator locator = homePage.getTravelerOffers().getOffers().getFirst();
        double beforeValue = locator.boundingBox().x;

        page.waitForCondition(() -> {
            BoundingBox box = locator.boundingBox();
            return box != null && box.x < 0;
        });

        double afterValue = locator.boundingBox().x;
        assertTrue(afterValue < beforeValue);
    }

    @Test
    public void verifyTravelOfferCardsMovesOnArrowClickShouldSucceed() {
        HomePage homePage = goTo(new HomePage(page));
        if (homePage.getWelcomeModalLocator().count() > 0) {
            homePage.getWelcomeModal().close();
        }

        Locator firstLocator = homePage.getTravelerOffers().getOffers().getFirst();
        double beforePreviousClickValue = firstLocator.boundingBox().x;

        homePage.getTravelerOffers().clickPreviousArrow();

        page.waitForCondition(() -> {
            BoundingBox box = firstLocator.boundingBox();
            return box != null && box.x < beforePreviousClickValue;
        });

        double afterPreviousClickValue = firstLocator.boundingBox().x;
        assertTrue(afterPreviousClickValue < beforePreviousClickValue);

        Locator lastLocator = homePage.getTravelerOffers().getOffers().getLast();
        double beforeNextClickValue = lastLocator.boundingBox().x;

        homePage.getTravelerOffers().clickNextArrow();

        page.waitForCondition(() -> {
            BoundingBox box = lastLocator.boundingBox();
            return box != null && box.x < beforeNextClickValue;
        });

        double afterNextClickValue = lastLocator.boundingBox().x;
        assertTrue(afterNextClickValue < beforeNextClickValue);
    }
}