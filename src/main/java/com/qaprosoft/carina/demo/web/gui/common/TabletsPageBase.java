package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.demo.web.enums.FilterType;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.ProductStatus;
import com.qaprosoft.carina.demo.web.enums.SortDropdown;


public abstract class TabletsPageBase extends AbstractPage {

    public TabletsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectBrand(FilterType filterType);

    public abstract void selectRAM(FilterType filterType);

    public abstract void selectStateCheckBox(ProductStatus productStatus);

    public abstract void sortDropdownMenu(SortDropdown sortDropdown);

    public abstract boolean sortLowToHighPrice();

    public abstract String getTabletTitleText(int index);

    public abstract void clickOnBasketIcon(int index);

    public abstract boolean addedItemsCounterIsPresent();

    public abstract LaptopItemsPageBase clickOnLaptopDevice(int index);
}
