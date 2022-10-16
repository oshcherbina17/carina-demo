package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.CoffeeMachinePageBase;
import com.qaprosoft.carina.demo.web.gui.common.ComparisonPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CoffeeMachinePageBase.class)
public class CoffeeMachinePage extends CoffeeMachinePageBase {

    @FindBy(xpath = "//span[contains(@class, 'categories-filter__link-title') and contains(.,'%s')]")
    private ExtendedWebElement productNameFilter;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalBrandCheckbox;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> titleProductList;

    @FindBy(xpath = "//button[contains(@class, 'compare-button')]")
    private List<ExtendedWebElement> compareBtn;

    @FindBy(xpath = " //span[contains(@class, 'counter--gray')]")
    private ExtendedWebElement addedItemsCompareCounter;

    @FindBy(xpath = "//button[@aria-label='Списки порівнянь']")
    private ExtendedWebElement addedCompareBtn;

    @FindBy(xpath = "//a[@class='comparison-modal__link']")
    private ExtendedWebElement productTypeBtn;


    public CoffeeMachinePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void productNameFilterClick(String productName) {
        productNameFilter.format(productName).click();
    }

    @Override
    public boolean isTitleTextContainsProductType(String product) {
        boolean res = false;
        for (ExtendedWebElement type : titleProductList) {
            res = (StringUtils.containsIgnoreCase(type.getText(), product));
        }
        return res;
    }

    @Override
    public void selectBrand(String brand) {
        universalBrandCheckbox.format(brand).click();
    }

    @Override
    public void clickOnCompareIcon(int index) {
        System.out.println("hhh");
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
}
