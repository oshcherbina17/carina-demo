package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.gui.common.PhoneItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.PhonePageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PhonePageBase.class)
public class PhonePage extends PhonePageBase {
    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalCheckbox;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> titleProductList;

    public PhonePage(WebDriver driver) {
        super(driver);
        setPageURL("mobile-phones/c80003/");
    }

    @Override
    public void selectBrand(FilterType filterType) {
        universalCheckbox.format(filterType.getType()).click();
    }

    @Override
    public PhoneItemsPageBase clickOnProductTitle(int index) {
        titleProductList.get(index).click();
        return initPage(getDriver(), PhoneItemsPageBase.class);
    }
}
