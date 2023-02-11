package com.qaprosoft.carina.demo.web.gui.common;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.gui.components.Basket;

public abstract class SearchPageBase extends AbstractPage {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickAddToBagButton(int index);

    public abstract void clickOnBasketButton();

    public abstract Basket getBasketMenu();

    public abstract String getPageTitleText();

    public abstract List<String> getProductsText();

    public abstract void productNameFilterClick(FilterType filterType);

    public abstract ProductListPageBase productTypeLinkClick(FilterType filterType);

    public abstract boolean checkSubcategoryTitleText(String subcategory);

    public abstract boolean isTitleTextContainsProductType(FilterType filterType);

}
