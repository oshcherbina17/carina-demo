package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.demo.web.enums.FilterType;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;


public abstract class CoffeeMachinePageBase extends AbstractPage {

    public CoffeeMachinePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void productNameFilterClick(FilterType filterType);

    public abstract boolean isTitleTextContainsProductType(FilterType filterType);

    public abstract void selectBrand(FilterType filterType);

    public abstract void clickOnCompareIcon(int index);

    public abstract boolean addedItemsCompareCounterIsPresent();

    public abstract void clickOnAddedCompareBtn();

    public abstract ComparisonPageBase clickOnProductType();
}
