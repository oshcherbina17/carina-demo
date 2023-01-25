package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.gui.components.Basket;

import java.util.List;

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
}
