package com.qaprosoft.carina.demo.web.gui.desktop;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.LaptopItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.TabletsPageBase;
import com.qaprosoft.carina.demo.web.utils.enums.ProductStatus;
import com.qaprosoft.carina.demo.web.utils.enums.SortDropdown;

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

    public TabletsPage(WebDriver driver) {
        super(driver);
        setPageURL("tablets/c130309/");
    }

    @Override
    public void selectBrand(String brand) {
        universalCheckbox.format(brand).click();
    }

    @Override
    public void selectRAM(String memory) {
        universalCheckbox.format(memory).click();
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
}
