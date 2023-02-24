package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.gui.common.ComparisonPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductDetailsPageBase;
import com.qaprosoft.carina.demo.web.gui.components.ProductFilter;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductListPageBase.class)
public class ProductListPage extends ProductListPageBase {

    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<ExtendedWebElement> priceList;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> titleProductList;

    @FindBy(xpath = "//button[contains(@class, 'goods-tile__buy-button')]")
    private List<ExtendedWebElement> basketIcon;

    @FindBy(xpath = "//li[contains(@class, 'cart')]/*/button")
    private WebElement basketBtn;
    @FindBy(xpath = "//span[contains(@class, 'badge--green')]")
    private ExtendedWebElement addedItemsCounter;

    @FindBy(xpath = "//h1[contains(@class, 'catalog-heading')]")
    private ExtendedWebElement deviceTitleText;

    @FindBy(xpath = "//a[contains(@class,'goods-tile__heading')]")
    private List<ExtendedWebElement> searchBrandList;

    @FindBy(css = "rz-filter-stack.ng-star-inserted")
    private ProductFilter filter;

    @FindBy(xpath = "//button[contains(@class, 'compare-button')]")
    private List<ExtendedWebElement> compareBtn;

    @FindBy(xpath = "//span[contains(@class, 'badge--gray')]")
    private ExtendedWebElement addedItemsCompareCounter;

    @FindBy(xpath = "//button[@aria-label='Списки порівнянь']")
    private ExtendedWebElement addedCompareBtn;

    @FindBy(xpath = "//a[@class='comparison-modal__link']")
    private ExtendedWebElement productTypeBtn;

    @FindBy(xpath = "//input[@formcontrolname='%s']")
    private ExtendedWebElement universalPriceInput;

    @FindBy(xpath = "//button[contains(@class,'slider-filter__button')]")
    private ExtendedWebElement okBtn;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean sortLowToHighPrice() {
        boolean result = false;
        int firstPrice;
        int nextPrice;
        for (int i = 0; i < priceList.size() - 1; i++) {
            firstPrice = Integer.valueOf(priceList.get(i).getText().replace(" ", "").replace("₴", ""));
            nextPrice = Integer.valueOf(priceList.get(i + 1).getText().replace(" ", "").replace("₴", ""));
            result = (firstPrice < nextPrice);
        }
        return result;
    }

    @Override
    public String getTabletTitleText(int index) {
        basketIcon.get(index).sendKeys(Keys.PAGE_UP);
        return titleProductList.get(index).getText();
    }

    @Override
    public void clickOnBasketIcon(int index) {
        waitUntil(ExpectedConditions.visibilityOf(basketBtn),4000);
        basketIcon.get(index).click();
    }

    @Override
    public boolean addedItemsCounterIsPresent() {
        return addedItemsCounter.isElementPresent();
    }

    @Override
    public ProductDetailsPageBase clickOnDeviceTitle(int index) {
        titleProductList.get(index).click();
        return initPage(getDriver(), ProductDetailsPageBase.class);
    }

    @Override
    public boolean checkChosenBrand(int index, String brandName) {
        basketIcon.get(index).sendKeys(Keys.PAGE_UP);
        return searchBrandList.stream().allMatch((model) -> StringUtils.containsIgnoreCase(model.getText(), brandName));
    }

    @Override
    public ProductFilter getFilter() {
        return filter;
    }

    @Override
    public ProductDetailsPageBase clickOnProductTitle(int index) {
        basketIcon.get(index).sendKeys(Keys.PAGE_UP);
        titleProductList.get(index).click();
        return initPage(getDriver(), ProductDetailsPageBase.class);
    }

    @Override
    public void clickOnCompareIcon(int index) {
        compareBtn.get(index).sendKeys(Keys.UP);
        compareBtn.get(index).click();
    }

    @Override
    public boolean addedItemsCompareCounterIsPresent() {
        return addedItemsCompareCounter.isElementPresent();
    }

    @Override
    public void clickOnAddedCompareBtn() {
        addedCompareBtn.click();
    }

    @Override
    public ComparisonPageBase clickOnProductType() {
        productTypeBtn.click();
        return initPage(getDriver(), ComparisonPageBase.class);
    }

    @Override
    public void setSortingPrice(String param, int price) {
        universalPriceInput.format(param).type(String.valueOf(price));
        okBtn.click();
    }

    @Override
    public boolean checkBrandInDescription(FilterType filterType, int index) {
        return titleProductList.get(index).getText().contains(filterType.getType());
    }

    @Override
    public void filterProductsByPrice(String paramMin, String paramMax, String min, String max) {
        universalPriceInput.format(paramMin).type(min);
        universalPriceInput.format(paramMax).type(max);
        okBtn.click();
    }

    @Override
    public boolean verifyPriceLimits(String min, String max) {
        List<Integer> pricesList = new ArrayList<>();
        for (ExtendedWebElement webElement : priceList) {
            pricesList.add(Integer.valueOf(webElement.getText().replace(" ", "").replaceAll("[^0-9?!\\\\.]", "")));
        }
        return pricesList.stream().allMatch(price -> price >= Integer.parseInt(min) && price <= Integer.parseInt(max));
    }
}
