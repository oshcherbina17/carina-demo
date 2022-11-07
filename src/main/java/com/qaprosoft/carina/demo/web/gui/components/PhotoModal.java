package com.qaprosoft.carina.demo.web.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.gui.common.PhoneItemsPageBase;

import java.util.List;

public class PhotoModal extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//div[contains(@class, 'zoom-wrap')]//img")
    private List<ExtendedWebElement> photoSlider;

    @FindBy(xpath = "//div[@class='simple-slider__holder']/following-sibling::button[contains(@class,'simple-slider__control--next')]")
    private ExtendedWebElement rightArrowBtn;

    @FindBy(xpath = "//button[@class='modal__close']")
    private ExtendedWebElement closeModalBtn;

    public PhotoModal(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPhotoSliderPresent(int index) {
        return photoSlider.get(index).isElementPresent();
    }

    public void clickOnSlider() {
        do {
            rightArrowBtn.click();
        } while (rightArrowBtn.isElementPresent());
    }

    public PhoneItemsPageBase clickOnModalCloseButton() {
        closeModalBtn.click();
        return initPage(getDriver(), PhoneItemsPageBase.class);
    }
}

