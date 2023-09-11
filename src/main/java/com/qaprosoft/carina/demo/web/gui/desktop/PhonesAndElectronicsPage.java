package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.Devices;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PhonesAndElectronicsPageBase.class)
public class PhonesAndElectronicsPage extends PhonesAndElectronicsPageBase {

    @FindBy(xpath = "//a[contains(@class,'tile-cats__heading_type_center') and contains(.,' %s ')]")
    private ExtendedWebElement universalCategoriesMenu;

    @FindBy(xpath = "//img[contains(@src, 'apple.jpg')]")
    private ExtendedWebElement appleBrandsLink;

    @FindBy(xpath = "//h1[contains(@class, 'portal__heading')]")
    private ExtendedWebElement titleText;

    public PhonesAndElectronicsPage(WebDriver driver) {
        super(driver);
        setPageURL("telefony-tv-i-ehlektronika/c4627949/");
    }

    @Override
    public ProductListPageBase clickOnCategoriesLink(Devices devices) {
        universalCategoriesMenu.format(devices.getNamePage()).click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public AppleBrandPage clickOnBrandLink() {
        appleBrandsLink.click();
        return new AppleBrandPage(getDriver());
    }

    @Override
    public String getTitleText() {
        return titleText.getText().toLowerCase();
    }
}
