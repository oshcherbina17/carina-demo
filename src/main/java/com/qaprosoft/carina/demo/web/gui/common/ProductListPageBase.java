package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.gui.components.ProductFilter;

public abstract class ProductListPageBase extends AbstractPage {

    public ProductListPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean sortLowToHighPrice();

    public abstract String getTabletTitleText(int index);

    public abstract void clickOnBasketIcon(int index);

    public abstract boolean addedItemsCounterIsPresent();

    public abstract ProductDetailsPageBase clickOnDeviceTitle(int index);

    public abstract boolean checkChosenBrand(int index, String brandName);

    public abstract ProductFilter getFilter();

    public abstract ProductDetailsPageBase clickOnProductTitle(int index);

    public abstract void clickOnCompareIcon(int index);

    public abstract boolean addedItemsCompareCounterIsPresent();

    public abstract void clickOnAddedCompareBtn();

    public abstract ComparisonPageBase clickOnProductType();

    ///////////////
    public abstract void setSortingPrice(String param, int price);

    public abstract boolean checkBrandInDescription(FilterType filterType, int index);

    public abstract void filterProductsByPrice(String paramMin, String paramMax, String min, String max);

    public abstract boolean verifyPriceLimits(String min, String max);
}
