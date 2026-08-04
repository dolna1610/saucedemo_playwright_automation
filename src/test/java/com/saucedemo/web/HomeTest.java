package com.saucedemo.web;

import com.saucedemo.web.pages.*;
import com.saucedemo.web.utils.Credential;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import org.testng.annotations.Test;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
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
}