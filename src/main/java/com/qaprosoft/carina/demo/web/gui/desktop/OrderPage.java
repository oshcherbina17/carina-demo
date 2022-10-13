package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.OrderPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = OrderPageBase.class)
public class OrderPage extends OrderPageBase {

    @FindBy(xpath = "//dd[@class='checkout-total__value checkout-total__value_size_large']")
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
