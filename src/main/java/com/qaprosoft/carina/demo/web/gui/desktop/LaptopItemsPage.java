package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.LaptopItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.components.Basket;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LaptopItemsPageBase.class)
public class LaptopItemsPage extends LaptopItemsPageBase {

    @FindBy(xpath = "//h1[@class='product__title']")
    private ExtendedWebElement productTitleText;

    @FindBy(xpath = "//span[text()=' Купити ']")
    private ExtendedWebElement buyBtn;

    @FindBy(xpath = "//span[text()=' В кошику ']")
    private ExtendedWebElement basketItemBtn;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder--large')]")
    private Basket basket;
    @FindBy(xpath = "//div[contains(@class, 'modal__holder')]")
    private ExtendedWebElement basketModal;

    @FindBy(xpath = "//h3[@class='modal__heading']")
    private ExtendedWebElement basketTitle;

    public LaptopItemsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductTitleText() {
        return productTitleText.getText();
    }

    @Override
    public void clickOnBuyButton() {
        buyBtn.click();
        if (!basketModal.isElementPresent()){
            basketItemBtn.click();
        }
    }

    @Override
    public void moveToTitleText() {
        productTitleText.hover();
        waitUntil(ExpectedConditions.visibilityOfElementLocated(productTitleText.getBy()), 2);
    }

    @Override
    public Basket getBasketMenu() {
        return basket;
    }
}
