package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.ContactsPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ContactsPageBase.class)
public class ContactsPage extends ContactsPageBase {

    @FindBy(xpath = "//button[contains(@class, 'modal-map__toggle')]")
    private List<ExtendedWebElement> addressList;

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAddressListPresent(int index) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(addressList.get(index).getBy()),5);
        return addressList.get(index).isElementPresent();
    }
}
