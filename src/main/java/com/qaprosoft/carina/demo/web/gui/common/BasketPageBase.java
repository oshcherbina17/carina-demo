package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class BasketPageBase extends AbstractPage {
    public BasketPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getSumPriceText();

    public abstract String getItemPriceText();
}
