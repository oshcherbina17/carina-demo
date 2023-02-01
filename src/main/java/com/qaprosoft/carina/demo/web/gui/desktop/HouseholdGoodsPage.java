package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.FurnitureSubcategory;
import com.qaprosoft.carina.demo.web.gui.common.HouseholdGoodsPageBase;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HouseholdGoodsPageBase.class)
public class HouseholdGoodsPage extends HouseholdGoodsPageBase {

    @FindBy(xpath = "//li[contains(@class, 'tile-cats__item') and contains(.,'%s')]")
    private ExtendedWebElement universalCategoryBtn;

    @FindBy(xpath = "//h1[contains(@class, 'portal__heading')]")
    private ExtendedWebElement titleText;

    public HouseholdGoodsPage(WebDriver driver) {
        super(driver);
        setPageURL("tovary-dlya-doma/c2394287/");
    }

    @Override
    public AbstractPage clickOnCategoriesLink(FurnitureSubcategory furniture) {
        universalCategoryBtn.format(furniture.getNamePage()).click();
        return initPage(getDriver(), furniture.getPageClass());
    }

    @Override
    public String getTitleText() {
        return titleText.getText().toLowerCase();
    }
}
