package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

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
