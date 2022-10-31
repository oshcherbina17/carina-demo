package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.ProductStatus;
import com.qaprosoft.carina.demo.web.enums.SortDropdown;
import com.qaprosoft.carina.demo.web.gui.common.LaptopItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.TabletsPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TabletsPageBase.class)
public class TabletsPage extends TabletsPageBase {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalCheckbox;

    @FindBy(xpath = "//option[@class='ng-star-inserted' and contains(.,'%s')]")
    private ExtendedWebElement universalDropdownMenu;

    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    private List<ExtendedWebElement> priceList;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> titleDeviceList;

    @FindBy(xpath = "//button[contains(@class, 'goods-tile__buy-button')]")
    private List<ExtendedWebElement> basketIcon;

    @FindBy(xpath = "//span[contains(@class, 'counter counter--green')]")
    private ExtendedWebElement addedItemsCounter;

    @FindBy(xpath = "//h1[contains(@class, 'catalog-heading')]")
    private ExtendedWebElement deviceTitleText;

    @FindBy(xpath = "//a[@class='goods-tile__heading ng-star-inserted']")
    private List<ExtendedWebElement> searchBrandList;

    public TabletsPage(WebDriver driver) {
        super(driver);
        setPageURL("tablets/c130309/");
    }

    @Override
    public void selectBrand(FilterType filterType) {
        universalCheckbox.format(filterType.getType()).click();
    }

    @Override
    public void selectRAM(FilterType filterType) {
        universalCheckbox.format(filterType.getType()).click();
    }

    @Override
    public void selectStateCheckBox(ProductStatus productStatus) {
        universalCheckbox.format(productStatus.getSortType()).click();
    }

    @Override
    public void sortDropdownMenu(SortDropdown sortDropdown) {
        universalDropdownMenu.format(sortDropdown.getSortType()).click();
    }

    @Override
    public boolean sortLowToHighPrice() {
        boolean result = false;
        int firstPrice;
        int nextPrice;
        for (int i = 0; i < priceList.size() - 1; i++) {
            firstPrice = Integer.valueOf(priceList.get(i).getText().replace(" ", ""));
            nextPrice = Integer.valueOf(priceList.get(i + 1).getText().replace(" ", ""));
            result = (firstPrice < nextPrice);
        }
        return result;
    }

    @Override
    public String getTabletTitleText(int index) {
        basketIcon.get(index).sendKeys(Keys.PAGE_UP);
        return titleDeviceList.get(index).getText();
    }

    @Override
    public void clickOnBasketIcon(int index) {
        basketIcon.get(index).click();
    }

    @Override
    public boolean addedItemsCounterIsPresent() {
        return addedItemsCounter.isElementPresent();
    }

    @Override
    public LaptopItemsPageBase clickOnLaptopDevice(int index) {
        titleDeviceList.get(index).click();
        return initPage(getDriver(), LaptopItemsPageBase.class);
    }

    @Override
    public boolean checkChosenBrand(int index, String brandName) {
        basketIcon.get(index).sendKeys(Keys.PAGE_UP);
        return searchBrandList.stream().allMatch((model) -> StringUtils.containsIgnoreCase(model.getText(), brandName));
    }
}
