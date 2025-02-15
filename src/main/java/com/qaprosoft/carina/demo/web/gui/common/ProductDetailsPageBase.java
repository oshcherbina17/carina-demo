package com.qaprosoft.carina.demo.web.gui.common;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.enums.SortDropdown;
import com.qaprosoft.carina.demo.web.gui.components.Basket;
import com.qaprosoft.carina.demo.web.gui.components.PhotoModal;

public abstract class ProductDetailsPageBase extends AbstractPage {

    public ProductDetailsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductTitleText();

    public abstract void clickOnBuyButton();

    public abstract void moveToTitleText();

    public abstract Basket getBasketMenu();

    public abstract void clickOnTab(ProductTabs product);

    public abstract void selectDropdownOption(SortDropdown sortDropdown);

    public abstract boolean isChosenColorCorrect(FilterType filterType);

    public abstract List<Date> getListOfCommentsDate();

    public abstract boolean isOpinionsSortedByDate();

    public abstract void clickOnPhotoTab(int index);

    public abstract PhotoModal getPhotoModal();
}
