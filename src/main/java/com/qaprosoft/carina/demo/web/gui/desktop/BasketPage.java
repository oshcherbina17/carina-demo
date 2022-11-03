package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.BasketPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = BasketPageBase.class)
public class BasketPage extends BasketPageBase {

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']//span[1]")
    private ExtendedWebElement sumPrice;

    @FindBy(xpath = "//p[@data-testid='cost']")
    private ExtendedWebElement itemPrice;

    public BasketPage(WebDriver driver) {
        super(driver);
        setPageURL("cart/");
    }

    @Override
    public String getSumPriceText() {
        return sumPrice.getText();
    }

    @Override
    public String getItemPriceText() {
        return itemPrice.getText().replace(" ", "").replaceAll("[^0-9?!\\\\.]", "");
    }
}
