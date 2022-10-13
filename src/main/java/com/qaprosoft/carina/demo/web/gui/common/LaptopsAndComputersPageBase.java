package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.utils.enums.DevicesEnum;
import org.openqa.selenium.WebDriver;

public abstract class LaptopsAndComputersPageBase extends AbstractPage {

    public LaptopsAndComputersPageBase(WebDriver driver) {
        super(driver);
    }


    public abstract AbstractPage clickOnCategoriesLink(DevicesEnum devicesEnum);
}
