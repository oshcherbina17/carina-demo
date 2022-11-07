package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.gui.components.PhotoModal;

public abstract class PhoneItemsPageBase extends AbstractPage {
    public PhoneItemsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickOnTab(ProductTabs product);

    public abstract void clickOnPhotoTab(int index);

    public abstract PhotoModal getPhotoModal();
}
