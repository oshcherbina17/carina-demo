package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.web.gui.common.AppleBrandPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.components.FooterMenu;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AppleBrandPageBase.class)
public class AppleBrandPage extends AppleBrandPageBase {

    @FindBy(xpath = "//a[contains(@class, 'tile-cats__heading') and contains(.,'%s')]")
    private ExtendedWebElement universalDeviceTypeLink;

    @FindBy(xpath = "//footer[(@class='footer')]")
    private FooterMenu footerMenu;

    public AppleBrandPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDeviceTypePresent(String device) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(universalDeviceTypeLink.format(device).getBy()),5);
        return universalDeviceTypeLink.format(device).isElementPresent();
    }

    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }
}
