package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.OrderPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = OrderPageBase.class)
public class OrderPage extends OrderPageBase {

    @FindBy(xpath = "//dd[contains(@class,'value_size_large')]")
    private ExtendedWebElement toPaymentSum;

    public OrderPage(WebDriver driver) {
        super(driver);
        setPageURL("checkout/");
    }

    @Override
    public String getPaymentSumText() {
        return String.valueOf(toPaymentSum.getText().replace(" ", "").replaceAll("[^0-9?!\\\\.]", ""));
    }
}
