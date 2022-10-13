package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class OrderPageBase extends AbstractPage {

    public OrderPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getPaymentSumText();
}
