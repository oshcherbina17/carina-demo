package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;
import com.qaprosoft.carina.demo.web.enums.Devices;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PhonesAndElectronicsPageBase.class)
public class PhonesAndElectronicsPage extends PhonesAndElectronicsPageBase {

    @FindBy(xpath = "//a[contains(@class,'tile-cats__heading_type_center') and contains(.,' %s ')]")
    private ExtendedWebElement universalCategoriesMenu;

    @FindBy(xpath = "//a[contains(@class, 'portal-brands__item')]//img[@class='  ng-lazyloaded']")
    private List<ExtendedWebElement> brandsLink;


    public PhonesAndElectronicsPage(WebDriver driver) {
        super(driver);
        setPageURL("telefony-tv-i-ehlektronika/c4627949/");
    }

    @Override
    public AbstractPage clickOnCategoriesLink(Devices devices) {
        universalCategoriesMenu.format(devices.getNamePage()).click();
        return initPage(getDriver(), devices.getPageClass());
    }

    @Override
    public AppleBrandPage clickOnBrandLink(int index) {
        brandsLink.get(index).click();
        return new AppleBrandPage(getDriver());
    }
}
