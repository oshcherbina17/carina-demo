package com.qaprosoft.carina.demo.web.gui.components;

import java.util.List;
import java.util.Locale;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//button[contains(@class, 'header__button ng-tns')]")
    private ExtendedWebElement hamburgerMenuBtn;

    @FindBy(xpath = "//input[contains(@class, 'search-form__input')]")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[contains(@class, 'search-form__submit')]")
    private ExtendedWebElement searchBtn;

    @FindBy(xpath = "//a[contains(@class, 'js-menu-categories__link') and contains(.,'Товари для дому')]")
    private ExtendedWebElement universalCategoryMenu;

    @FindBy(xpath = "//span[contains(@class,'lang__link--active') and contains(.,'UA')]")
    private ExtendedWebElement languageUA;

    @FindBy(xpath = "//a[@class='lang__link ng-star-inserted']")
    private ExtendedWebElement languageRU;

    @FindBy(xpath = "//li[contains(@class, 'lang__item')]/a")
    private ExtendedWebElement currentLanguageBtn;

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

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<WebElement> titleProductList1;

    @FindBy(xpath = "//span[@class='show-more__text']")
    private WebElement showMoreText;

    @FindBy(xpath = "//section[@class='content content_type_catalog']")
    private WebElement catalog;

    @FindBy(xpath = "//li[contains(@class, 'lang__item')]/a")
    private static ExtendedWebElement languageBtn;

    static String languageRu = "ru";
    static String languageUk = "uk";
    static String languageBtnRu = "RU";
    static String languageBtnUa = "UA";

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

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

    public String getBtnText() {
        return searchBtn.getText();
    }

    public void clickOnLanguageBtn(String language) {
        switch (language) {
            case "RU" :
                languageRU.click();
                break;
            case "UA":
                languageUA.click();
                break;
        }
    }

    private static Locale parseLocale(String localeToParse) {
        String[] localeSettings = localeToParse.trim().split("_");
        String lang, country = "";
        lang = localeSettings[0];
        if (localeSettings.length > 1) {
            country = localeSettings[1];
        }
        return new Locale(lang, country);
    }

    public  void checkAndChangeLanguage() {
        String localeConfig = Configuration.get(Configuration.Parameter.LOCALE);
        Locale currentLocale = parseLocale(localeConfig);
        String languageBtnText = languageBtn.getText().strip();

        if (languageBtnText.equals(languageBtnRu) && currentLocale.getLanguage().equals(languageRu)) {
            languageBtn.click();
        } else if (languageBtnText.equals(languageBtnUa) && currentLocale.getLanguage().equals(languageUk)) {
            languageBtn.click();
        }
    }
}
