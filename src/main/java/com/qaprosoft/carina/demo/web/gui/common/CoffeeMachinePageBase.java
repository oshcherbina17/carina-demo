package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;


public abstract class CoffeeMachinePageBase extends AbstractPage {

    public CoffeeMachinePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void productNameFilterClick(String productName);

    public abstract boolean isTitleTextContainsProductType(String product);

    public abstract void selectBrand(String brand);

    public abstract void clickOnCompareIcon(int index);

    public abstract boolean addedItemsCompareCounterIsPresent();

    public abstract void clickOnAddedCompareBtn();

    public abstract ComparisonPageBase clickOnProductType();
}
