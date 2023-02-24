package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;
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

    @FindBy(xpath = "//span[contains(@class, 'categories-filter') and contains(.,'%s')]")
    private ExtendedWebElement productNameFilter;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder--large')]")
    private Basket basket;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> titleProductList;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<WebElement> titleProductList1;

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
        for (ExtendedWebElement webElement : titleProductList) {
            productsText.add(webElement.getText().toLowerCase());
        }
        return productsText;
    }

    @Override
    public void productNameFilterClick(FilterType filterType) {
        productNameFilter.format(filterType.getType()).click();
    }

    @Override
    public ProductListPageBase productTypeLinkClick(FilterType filterType) {
        productNameFilter.format(filterType.getType()).click();
        waitUntil(ExpectedConditions.visibilityOfAllElements(titleProductList1), 3);
        //new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("span.DropDown__matched-option-chars"))));
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public boolean checkSubcategoryTitleText(String subcategory) {
        return subcategoryTitleText.format(subcategory).getText().toLowerCase().contains(subcategory.toLowerCase());
    }

    @Override
    public boolean isTitleTextContainsProductType(FilterType filterType) {
        return  titleProductList.stream().allMatch((type)->
                StringUtils.containsIgnoreCase(type.getText(),filterType.getType()));
    }
}