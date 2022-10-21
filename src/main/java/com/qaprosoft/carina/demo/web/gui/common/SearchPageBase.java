package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.components.Basket;

public abstract class SearchPageBase extends AbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnBasketIcon(int index);

    public abstract void clickOnBasketButton();

    public abstract Basket getBasketMenu();
}
