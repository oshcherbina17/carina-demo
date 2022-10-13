package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.LaptopItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.OrderPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LaptopItemsPageBase.class)
public class LaptopItemsPage extends LaptopItemsPageBase {

    @FindBy(xpath = "//h1[@class='product__title']")
    private ExtendedWebElement productTitleText;

    @FindBy(xpath = "//span[.=' Купити ']")
    private ExtendedWebElement buyBtn;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']//span[1]")
    private ExtendedWebElement sumPrice;

    @FindBy(xpath = "//a[@class='button button_size_large button_color_green cart-receipt__submit ng-star-inserted']")
    private ExtendedWebElement toOrderBtn;

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
    }

    @Override
    public String getSumPriceText() {
        return sumPrice.getText();
    }

    @Override
    public OrderPageBase clickOnOrderButton() {
        toOrderBtn.click();
        return initPage(getDriver(), OrderPageBase.class);
    }
}
