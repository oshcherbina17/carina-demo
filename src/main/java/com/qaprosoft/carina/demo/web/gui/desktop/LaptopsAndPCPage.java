package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.LaptopsAndPCPageBase;
import com.qaprosoft.carina.demo.web.utils.enums.Devices;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LaptopsAndPCPageBase.class)
public class LaptopsAndPCPage extends LaptopsAndPCPageBase {

    @FindBy(xpath = "//a[contains(@class, 'tile-cats__heading_type_center') and contains(.,' %s ')]")
    private ExtendedWebElement universalCategoriesMenu;

    public LaptopsAndPCPage(WebDriver driver) {
        super(driver);
        setPageURL("computers-notebooks/c80253/");
    }

    @Override
    public AbstractPage clickOnCategoriesLink(Devices devices) {
        universalCategoriesMenu.format(devices.getNamePage()).click();
        return initPage(getDriver(), devices.getPageClass());
    }

}
