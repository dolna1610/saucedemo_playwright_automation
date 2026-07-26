package com.saucedemo.web.components;

import com.saucedemo.web.enums.PaymentMethod;
import com.microsoft.playwright.Locator;

public class PaymentInfoCard extends BaseComponent {
    public PaymentInfoCard(Locator element) {
        super(element);
    }

    public PaymentConfirmationModal selectPaymentMethod(PaymentMethod paymentMethod) {
        element.getByTestId("payment_method_" + paymentMethod.getValue()).click();
        return new PaymentConfirmationModal(element);
    }
}
