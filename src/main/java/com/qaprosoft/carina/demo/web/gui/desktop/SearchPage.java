package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;
import com.qaprosoft.carina.demo.web.gui.components.Basket;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {

    @FindBy(xpath = "//button[contains(@class, 'goods-tile__buy-button')]")
    private List<ExtendedWebElement> addToBagBtn;

    @FindBy(xpath = "//button[contains(@class,'header__button--active')]")
    private ExtendedWebElement basketBtn;

    @FindBy(xpath = "//h1[contains(@class,'catalog-heading')]")
    private ExtendedWebElement pageTitleText;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and contains(text(),'%s')]")
    private ExtendedWebElement subcategoryTitleText;

    @FindBy(xpath = "//span[contains(@class, 'categories-filter__link-title') and contains(.,'%s')]")
    private ExtendedWebElement productNameFilter;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder--large')]")
    private Basket basket;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> productTitleText;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageURL("search/");
    }

    @Override
    public void clickAddToBagButton(int index) {
        waitUntil(ExpectedConditions.titleContains("Brit"), 5);
        addToBagBtn.get(index).click();
    }

    @Override
    public void clickOnBasketButton() {
        basketBtn.click();
    }

    @Override
    public Basket getBasketMenu() {
        return basket;
    }

    @Override
    public String getPageTitleText() {
        return pageTitleText.getText().replace("«", "").replace("»", "");
    }

    @Override
    public List<String> getProductsText() {
        List<String> productsText = new ArrayList<>();
        for (ExtendedWebElement webElement : productTitleText) {
            productsText.add(webElement.getText().toLowerCase());
        }
        return productsText;
    }

    @Override
    public void productNameFilterClick(FilterType filterType) {
        productNameFilter.format(filterType.getType()).click();
    }

    @Override
    public boolean checkSubcategoryTitleText(String subcategory) {
        return subcategoryTitleText.format(subcategory).getText().toLowerCase().contains(subcategory.toLowerCase());
    }
}