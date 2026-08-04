package com.saucedemo.web.pages;

import com.microsoft.playwright.Page;

public class OrderCompletionPage extends BasePage{

    public OrderCompletionPage(Page page){
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

    public OrderCompletionPage clickBackHomeButton(){
        page.locator("[data-test='back-to-products']").click();
        return this;
    }
}
