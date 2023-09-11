package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.AppleDevices;
import com.qaprosoft.carina.demo.web.gui.common.AppleBrandPageBase;
import com.qaprosoft.carina.demo.web.gui.components.FooterMenu;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AppleBrandPageBase.class)
public class AppleBrandPage extends AppleBrandPageBase {

    @FindBy(xpath = "//a[contains(@class, 'tile-cats__heading') and contains(.,'%s')]")
    private ExtendedWebElement universalDeviceTypeLink;

    @FindBy(xpath = "//a[contains(@class, 'tile-cats__heading') and contains(.,'Стилуси')]")
    private ExtendedWebElement stylusTypeLink;

    @FindBy(xpath = "//footer[(@class='footer')]")
    private FooterMenu footerMenu;

    public AppleBrandPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDeviceTypePresent(AppleDevices appleDevices) {
        stylusTypeLink.sendKeys(Keys.PAGE_DOWN);
        stylusTypeLink.sendKeys(Keys.DOWN);
        return universalDeviceTypeLink.format(appleDevices.getDevice()).isElementPresent();
    }

    @Override
    public FooterMenu getFooterMenu() {
        return footerMenu;
    }
}
