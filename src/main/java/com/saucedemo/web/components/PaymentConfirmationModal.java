package com.saucedemo.web.components;

import com.microsoft.playwright.Locator;

public class PaymentConfirmationModal extends BaseComponent {
    public PaymentConfirmationModal(Locator element) {
        super(element);
    }

    public PaymentInfoCard clickConfirm() {
        element.getByText("Confirm").click();
        return new PaymentInfoCard(element);
    }
}
