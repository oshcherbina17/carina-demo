package com.qaprosoft.carina.demo.web.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.OrderPageBase;
import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.gui.AbstractUIObject;


public class Basket extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//h3[@class='modal__heading']")
    private ExtendedWebElement basketTitle;

    @FindBy(xpath = "//button[@class='modal__close']")
    private ExtendedWebElement closeBtn;

    @FindBy(xpath = "//a[contains(@class, 'cart-receipt__submit')]")
    private ExtendedWebElement toOrderBtn;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']//span[1]")
    private ExtendedWebElement sumPrice;

    public Basket(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public OrderPageBase clickOnOrderButton() {
        toOrderBtn.click();
        return initPage(getDriver(), OrderPageBase.class);
    }

    public String getSumPriceText() {
        return sumPrice.getText();
    }
}
