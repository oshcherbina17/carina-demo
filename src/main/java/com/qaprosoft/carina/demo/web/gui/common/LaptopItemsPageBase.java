package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.components.Basket;


public abstract class LaptopItemsPageBase extends AbstractPage {
    public LaptopItemsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitleText();

    public abstract void clickOnBuyButton();

     public abstract Basket getBasketMenu();
}
