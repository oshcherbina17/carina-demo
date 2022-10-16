package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.common.HomePageBase;
import com.qaprosoft.carina.demo.web.utils.enums.MenuCategory;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//a[@class='menu-categories__link' and contains(., '%s')]")
    private ExtendedWebElement universalCategoryMenu;

    @FindBy(xpath = "//div[@class='header-layout']")
    private HeaderMenu headerMenu;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AbstractPage clickOnCategoryMenu(MenuCategory menuCategory) {
        universalCategoryMenu.format(menuCategory.getNamePage()).click();
        return initPage(getDriver(), menuCategory.getPageClass());
    }

    public HeaderMenu getHeader() {
        return headerMenu;
    }
}
