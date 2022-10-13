package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.CoffeeMachinePageBase;
import com.qaprosoft.carina.demo.web.gui.common.ComparisonPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CoffeeMachinePageBase.class)
public class CoffeeMachinePage extends CoffeeMachinePageBase {

    @FindBy(xpath = "//span[@class='categories-filter__link-title ng-star-inserted' and contains(.,'%s')]")
    private ExtendedWebElement productNameFilter;

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalBrandCheckbox;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> titleProductList;

    @FindBy(xpath = "//button[@class='compare-button ng-star-inserted']")
    private List<ExtendedWebElement> compareBtn;

    @FindBy(xpath = "//span[@class='counter counter--gray ng-star-inserted']")
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
