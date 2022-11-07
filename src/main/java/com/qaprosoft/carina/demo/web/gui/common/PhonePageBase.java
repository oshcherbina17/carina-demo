package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.FilterType;

public abstract class PhonePageBase extends AbstractPage {
    public PhonePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectBrand(FilterType filterType);

    public abstract PhoneItemsPageBase clickOnProductTitle(int index);
}
