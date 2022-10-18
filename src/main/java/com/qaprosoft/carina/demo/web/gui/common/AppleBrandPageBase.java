package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.demo.web.gui.components.FooterMenu;
import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class AppleBrandPageBase extends AbstractPage {
    public AppleBrandPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDeviceTypePresent(String device);

    public abstract FooterMenu getFooterMenu();
}
