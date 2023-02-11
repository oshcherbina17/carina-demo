package com.qaprosoft.carina.demo.web.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;

public class HeaderMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//button[@class='header__button ng-tns-c94-1']")
    private ExtendedWebElement hamburgerMenuBtn;

    @FindBy(xpath = "//input[contains(@class, 'search-form__input')]")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'search-form__submit')]")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//a[contains(@class, 'js-menu-categories__link') and contains(.,'Товари для дому')]")
    private ExtendedWebElement universalCategoryMenu;

    @FindBy(xpath = "//span[contains(@class,'lang__link--active') and contains(.,'UA')]")
    private ExtendedWebElement languageUA;

    @FindBy(xpath = "//div[contains(@class, 'side-menu drawer-content')]")
    private HamburgerMenu hamburgerMenu;

    @FindBy(id = "fat-menu")
    private ExtendedWebElement catalogBtn;

    @FindBy(xpath = "//li[contains(@class,'user')]/*/button[contains(@class,'button')]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//li[contains(@class,'user')]/*/a[contains(@class,'header__button')]")
    private ExtendedWebElement orderBtn;

    @FindBy(xpath = "//div[contains(@class,'modal__holder modal__holder_show_animation')]")
    private LoginForm loginForm;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

   /* public CoffeeMachinePageBase searchProductItems(FilterType filterType) {
        searchInput.type(filterType.getType());
        searchBtn.click();
        return initPage(getDriver(), CoffeeMachinePageBase.class);
    }*/

    public SearchPageBase searchItems(FilterType filterType) {
        searchInput.type(filterType.getType());
        searchBtn.click();
        return initPage(getDriver(), SearchPageBase.class);
    }

    public SearchPageBase searchBrand(String param) {
        searchInput.type(param);
        searchBtn.click();
        return initPage(getDriver(), SearchPageBase.class);
    }

    public boolean isCatalogButtonPresent() {
        return catalogBtn.isElementPresent();
    }

    public boolean isLoginIconPresent() {
        return loginBtn.isElementPresent();
    }

    public boolean isOrderButtonPresent() {
        return orderBtn.isPresent();
    }

    public LoginForm openLoginField() {
        loginBtn.click();
        return loginForm;
    }

    public void clickOnCatalogButton() {
        catalogBtn.click();
    }

    public AbstractPage clickOnCategoryMenu(MenuCategory menuCategory) {
        universalCategoryMenu.format(menuCategory.getNamePage()).click();
        return initPage(getDriver(), menuCategory.getPageClass());
    }

    public boolean isHamburgerMenuPresent() {
        return hamburgerMenuBtn.isElementPresent();
    }

    public HamburgerMenu getHamburgerMenu() {
        return hamburgerMenu;
    }

    public void clickOnHamburgerMenu() {
        hamburgerMenuBtn.click();
    }

    public String getLanguageText() {
        return languageUA.getText().replace(" ", "");
    }
}
