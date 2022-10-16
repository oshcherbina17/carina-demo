package com.qaprosoft.carina.demo.web.gui.common;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.demo.web.utils.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.utils.enums.SortDropdown;
import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class TableItemsPageBase extends AbstractPage {

    public TableItemsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnTab(ProductTabs product);

    public abstract void selectDropdownOption(SortDropdown sortDropdown);

    public abstract boolean isChosenColorCorrect(String color);

    public abstract List<Date> getListOfCommentsDate();

    public abstract boolean isOpinionsSortedByDate();
}
