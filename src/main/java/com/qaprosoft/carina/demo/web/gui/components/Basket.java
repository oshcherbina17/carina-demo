package com.qaprosoft.carina.demo.web.gui.components;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.gui.common.OrderPageBase;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;

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

    @FindBy(xpath = "//h4[@class='cart-dummy__heading']")
    private ExtendedWebElement cardStatus;

    @FindBy(xpath = "//a[@class='cart-product__title']")
    private List<ExtendedWebElement> itemsTitleText;

    @FindBy(xpath = "//button[contains(@class,'popup-menu__toggle--context')]")
    private List<ExtendedWebElement> itemsOptionBtn;

    @FindBy(xpath = "//button[contains(@class,'context-menu-actions__button')]")
    private ExtendedWebElement itemsDeleteBtn;

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

    public Integer getSizeTitleText() {
        return itemsTitleText.size();
    }

    public SearchPageBase clickOnContinueBuyButton() {
        continueBuyBtn.click();
        return initPage(getDriver(), SearchPageBase.class);
    }

    public boolean getCardStatus() {
        return cardStatus.isElementPresent();
    }

    public void deleteItemsFromBasket() {
        while (!cardStatus.isElementPresent()) {
            for (int i = 0; i < itemsTitleText.size(); i++) {
                if (itemsTitleText.get(i).isElementPresent()) {
                    itemsOptionBtn.get(i).click();
                    itemsDeleteBtn.click();
                }
            }
        }
    }


}
