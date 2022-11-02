package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class OrderPageBase extends AbstractPage {

    public OrderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getPaymentSumText(String param);
}
