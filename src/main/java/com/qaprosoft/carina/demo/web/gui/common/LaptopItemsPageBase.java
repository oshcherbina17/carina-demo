package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LaptopItemsPageBase extends AbstractPage {
    public LaptopItemsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitleText();

    public abstract void clickOnBuyButton();

    public abstract String getSumPriceText();

    public abstract OrderPageBase clickOnOrderButton();
}
