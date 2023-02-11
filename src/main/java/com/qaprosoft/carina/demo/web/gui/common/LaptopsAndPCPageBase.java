package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.Devices;

public abstract class LaptopsAndPCPageBase extends AbstractPage {

    public LaptopsAndPCPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean getTitleText(String param);

    public abstract ProductListPageBase clickOnCategoriesLink(Devices devices);

    public abstract String reverseWords(String str);
}
