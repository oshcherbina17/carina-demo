package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;


public abstract class PCTablesPageBase extends AbstractPage {

    public PCTablesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void selectRegulate(String type);

    public abstract void selectColor(String type);

    public abstract TableItemsPageBase clickOnProductTitle(int index);
}
