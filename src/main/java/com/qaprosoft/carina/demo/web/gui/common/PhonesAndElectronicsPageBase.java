package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.utils.enums.Devices;

public abstract class PhonesAndElectronicsPageBase extends AbstractPage {
    public PhonesAndElectronicsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AbstractPage clickOnCategoriesLink(Devices devices);
}
