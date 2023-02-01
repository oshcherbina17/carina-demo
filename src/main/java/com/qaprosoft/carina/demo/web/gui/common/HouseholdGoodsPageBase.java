package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.FurnitureSubcategory;

public abstract class HouseholdGoodsPageBase extends AbstractPage {
    public HouseholdGoodsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage clickOnCategoriesLink(FurnitureSubcategory furniture);

    public abstract String getTitleText();
}
