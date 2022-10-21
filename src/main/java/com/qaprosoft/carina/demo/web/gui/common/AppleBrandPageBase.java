package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.demo.web.enums.AppleDevices;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.components.FooterMenu;

public abstract class AppleBrandPageBase extends AbstractPage {
    public AppleBrandPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDeviceTypePresent(AppleDevices appleDevices);

    public abstract FooterMenu getFooterMenu();
}
