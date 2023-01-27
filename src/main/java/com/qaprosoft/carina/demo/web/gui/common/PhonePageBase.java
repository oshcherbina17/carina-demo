package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.ProductStatus;

public abstract class PhonePageBase extends AbstractPage {
    public PhonePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectBrand(FilterType filterType);


    public abstract void setSortingPrice(String param, int price);

    public abstract void selectStateCheckBox(ProductStatus productStatus);

    public abstract PhoneItemsPageBase clickOnProductTitle(int index);

    public abstract boolean checkBrandInDescription(FilterType filterType, int index);

    public abstract void filterProductsByPrice(String paramMin, String paramMax, String min, String max);

    public abstract boolean verifyPriceLimits(String min, String max);
}
