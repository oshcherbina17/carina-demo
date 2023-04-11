package com.qaprosoft.carina.demo.web.gui.components;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class Basket extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//h3[@class='modal__heading']")
    private ExtendedWebElement basketTitle;

    @FindBy(xpath = "//button[@class='modal__close']")
    private ExtendedWebElement closeBtn;

    @FindBy(xpath = "//a[contains(@class, 'cart-receipt__submit')]")
    private ExtendedWebElement toOrderBtn;

    @FindBy(xpath = "//button[contains(@class, 'cart-footer__continue')]")
    private ExtendedWebElement continueBuyBtn;

    @FindBy(xpath = "//div[@class='cart-receipt__sum-price']//span[1]")
    private ExtendedWebElement sumPrice;

    @FindBy(xpath = "//p[@class='cart-product__price']")
    private ExtendedWebElement itemPrice;
    @FindBy(xpath = "//h4[@class='cart-dummy__heading']")
    private ExtendedWebElement cardStatus;

    @FindBy(xpath = "//a[@class='cart-product__title']")
    private List<ExtendedWebElement> itemsTitleText;

    @FindBy(xpath = "//button[contains(@class,'popup-menu__toggle--context')]")
    private ExtendedWebElement itemsOptionBtn;

    @FindBy(xpath = "//button[contains(@class,'button--with-icon button--link')]")
    private ExtendedWebElement itemsDeleteBtn;

    public Basket(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getSumPriceText() {
        return sumPrice.getText().replace(" ", "").replaceAll("[^0-9?!\\\\.]", "");
    }

    public String getItemPriceText() {
        return itemPrice.getText().replace(" ", "").replaceAll("[^0-9?!\\\\.]", "");
    }

    public boolean getCardStatus() {
        return cardStatus.isElementPresent();
    }

    public void deleteItemsFromBasket() {
        while (!cardStatus.isElementPresent()) {
            for (int i = 0; i < itemsTitleText.size(); i++) {
                    itemsOptionBtn.click();
                    itemsDeleteBtn.click();
            }
        }
    }

}
