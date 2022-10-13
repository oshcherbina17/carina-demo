package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.utils.enums.ProductStatusEnum;
import com.qaprosoft.carina.demo.web.utils.enums.SortDropdownEnum;
import org.openqa.selenium.WebDriver;

public abstract class TabletsPageBase extends AbstractPage {

    public TabletsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectBrand(String brand);


    public abstract void selectRAM(String memory);

    public abstract void selectStateCheckBox(ProductStatusEnum productStatusEnum);

    public abstract void sortDropdownMenu(SortDropdownEnum sortDropdownEnum);

    public abstract boolean sortLowToHighPrice();

    public abstract String getTabletTitleText(int index);

/*    public abstract void clickOnBasketIcon(int index);*/

    public abstract void clickOnBasketIcon(int index);

    public abstract boolean addedItemsCounterIsPresent();

    public abstract LaptopItemsPageBase clickOnLaptopDevice(int index);
}
