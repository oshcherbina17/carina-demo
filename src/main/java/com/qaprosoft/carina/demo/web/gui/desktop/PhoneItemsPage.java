package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.gui.common.PhoneItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.components.PhotoModal;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PhoneItemsPageBase.class)
public class PhoneItemsPage extends PhoneItemsPageBase {
    @FindBy(xpath = "//a[@class='tabs__link' and contains(.,'%s')]")
    private ExtendedWebElement universalProductTabs;

    @FindBy(xpath = "//li[contains(@class, 'product')]//img")
    private List<ExtendedWebElement> photoTab;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder')]")
    private PhotoModal photoModal;

    public PhoneItemsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnTab(ProductTabs product) {
        universalProductTabs.format(product.getType()).click();
    }

    @Override
    public void clickOnPhotoTab(int index) {
        photoTab.get(index).click();
    }

    @Override
    public PhotoModal getPhotoModal() {
        return photoModal;
    }
}
