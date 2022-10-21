package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.demo.web.enums.FilterType;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;


public abstract class PCTablesPageBase extends AbstractPage {

    public PCTablesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectRegulate(FilterType filterType);

    public abstract void selectColor(FilterType filterType);

    public abstract TableItemsPageBase clickOnProductTitle(int index);
}
