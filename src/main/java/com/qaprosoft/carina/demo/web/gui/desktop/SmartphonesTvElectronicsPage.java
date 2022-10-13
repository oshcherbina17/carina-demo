package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.SmartphonesTvElectronicsPageBase;
import com.qaprosoft.carina.demo.web.utils.enums.DevicesEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SmartphonesTvElectronicsPageBase.class)
public class SmartphonesTvElectronicsPage extends SmartphonesTvElectronicsPageBase {
    @FindBy(xpath = "//a[@class='tile-cats__heading tile-cats__heading_type_center ng-star-inserted' and contains(.,' %s ')]")
    private ExtendedWebElement universalCategoriesMenu;

    public SmartphonesTvElectronicsPage(WebDriver driver) {
        super(driver);
        setPageURL("telefony-tv-i-ehlektronika/c4627949/");
    }

    @Override
    public AbstractPage clickOnCategoriesLink(DevicesEnum devicesEnum) {
        universalCategoriesMenu.format(devicesEnum.getNamePage()).click();
        return initPage(getDriver(), devicesEnum.getPageClass());
    }
}
