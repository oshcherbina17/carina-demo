package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class ContactsPageBase extends AbstractPage {

    public ContactsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isAddressListPresent(int index);
}
