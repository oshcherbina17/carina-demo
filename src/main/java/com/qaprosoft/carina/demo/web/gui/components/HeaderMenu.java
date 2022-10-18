package com.qaprosoft.carina.demo.web.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.gui.common.CoffeeMachinePageBase;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;

public class HeaderMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//button[@class='header__button ng-tns-c94-1']")
    private ExtendedWebElement burgerMenu;

    @FindBy(xpath = "//input[contains(@class, 'search-form__input')]")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'search-form__submit')]")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//a[contains(@class, 'js-menu-categories__link') and contains(.,'Товари для дому')]")
    private ExtendedWebElement universalCategoryMenu;

    @FindBy(id = "fat-menu")
    private ExtendedWebElement catalogBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CoffeeMachinePageBase searchProductItems(String productName) {
        searchInput.type(productName);
        searchBtn.click();
        return initPage(getDriver(), CoffeeMachinePageBase.class);
    }

    public boolean isCatalogButtonPresent() {
       return catalogBtn.isElementPresent();
    }

    public void clickOnCatalogButton() {
        catalogBtn.click();
    }

    public AbstractPage clickOnCategoryMenu(MenuCategory menuCategory) {
        universalCategoryMenu.format(menuCategory.getNamePage()).click();
        return initPage(getDriver(), menuCategory.getPageClass());
    }
}
