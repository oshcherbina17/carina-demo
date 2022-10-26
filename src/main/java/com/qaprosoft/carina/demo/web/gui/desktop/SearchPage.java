package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;
import com.qaprosoft.carina.demo.web.gui.components.Basket;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(xpath = "//button[contains(@class, 'goods-tile__buy-button')]")
    private List<ExtendedWebElement> addToBackBtn;

    @FindBy(xpath = "//button[contains(@class,'header__button--active')]")
    private ExtendedWebElement basketBtn;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder--large')]")
    private Basket basket;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> productTitleText;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageURL("search/");
    }

    @Override
    public void clickAddToBackButton(int index) {
        waitUntil(ExpectedConditions.titleContains("Brit"), 5);
        addToBackBtn.get(index).click();
    }

    @Override
    public void clickOnBasketButton() {
        basketBtn.click();
    }

    @Override
    public Basket getBasketMenu() {
        return basket;
    }
}
