package com.saucedemo.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckoutPage extends BasePage{
    public CheckoutPage(Page page){
        super(page);
    }

    @Override
    public String getPageId(){
        return "";
    }

    @Override
    public String getUrl(){
        return "";
    }

    public CheckoutPage fillCheckoutFirstName(String firstName){
        page.locator("[data-test='firstName']").fill(firstName);
        return this;
    }

    public CheckoutPage fillCheckoutLastName(String lastName){
        page.locator("[data-test='lastName']").fill(lastName);
        return this;
    }

    public CheckoutPage fillCheckoutPostalCode(String postalCode){
        page.locator("[data-test='postalCode']").fill(postalCode);
        return this;
    }

    public CheckoutPage clickCheckoutContinueButton(){
        page.locator("[data-test='continue']").click();
        return this;
    }

    public CheckoutPage clickCheckoutFinishButton(){
        page.locator("[data-test='finish']").click();
        return this;
    }

    public CheckoutPage clickCancelButton(){
        page.locator("[data-test='cancel']").click();
        return this;
    }

    public Locator getCheckoutCompleteHeading() {
        return page.locator(".complete-header");
    }

    public Locator getCheckoutOverviewTitleLocator() {
        return page.locator(".title");
    }

    public Locator getCheckoutCancelButton() {
        return page.locator("[data-test='cancel']");
    }

    public Locator getCheckoutContinueButton() {
        return page.locator("[data-test='continue']");
    }

    public Locator getCheckoutFinishButton() {
        return page.locator("[data-test='finish']");
    }

    public Locator getContinueButton(){
        return page.locator("#continue");
    }

    public CheckoutPage waitForPageLoad() {
        page.waitForURL("**/checkout-step-one.html");
        return this;
    }

    public Locator getCheckoutFirstNameField() {
        return page.locator("[data-test='firstName']");
    }

    public Locator getCheckoutLastNameField() {
        return page.locator("[data-test='lastName']");
    }

    public Locator getCheckoutPostalCodeField() {
        return page.locator("[data-test='postalCode']");
    }

    public Locator getCheckoutErrorMessage() {
        return page.locator("[data-test='error']");
    }

    public Locator getCheckoutErrorMessageCloseButton() {
        return page.locator("[data-test='error'] button");
    }

    public Locator getProductTitleLocator() {
        return page.locator(".inventory_item_name");
    }

    public Locator getTitle(){
        return page.locator(".title");
    }

    public Locator getErrorMessageLocator() {
        return page.locator("[data-test='error']");
    }

    public boolean isCheckoutErrorMessageVisible() {
        return getCheckoutErrorMessage().count() > 0;
    }

    public Locator clickBackToProductsButton() {
        return page.locator("[data-test='back-to-products']");
    }

    public Locator getCheckoutTitleLocator() {
        return page.locator(".title");
    }

    public Locator getCheckoutFormLocator() {
        return page.locator(".checkout_info");
    }
}
