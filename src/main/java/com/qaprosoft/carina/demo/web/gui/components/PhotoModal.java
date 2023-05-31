package com.qaprosoft.carina.demo.web.gui.components;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.gui.common.ProductDetailsPageBase;

public class PhotoModal extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//div[contains(@class, 'zoom-wrap')]//img")
    private List<ExtendedWebElement> photoSlider;

    @FindBy(xpath = "//span[contains(@class,'indicators__item')]")
    private List<ExtendedWebElement> indicatorItems;

    @FindBy(xpath = "//button[contains(@class,'control--next')]")
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
        int count = 0;
        do {
            rightArrowBtn.click();
            count++;
        } while (count != indicatorItems.size()-1);
    }

    public ProductDetailsPageBase clickOnModalCloseButton() {
        closeModalBtn.click();
        return initPage(getDriver(), ProductDetailsPageBase.class);
    }
}

