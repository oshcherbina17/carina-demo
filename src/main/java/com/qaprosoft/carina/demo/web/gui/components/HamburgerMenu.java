package com.qaprosoft.carina.demo.web.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;

public class HamburgerMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//button[contains(@class, 'side-menu__auth-button') and contains(., 'Вхід')]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//ul[contains(@class,'lang ng')]/*/following-sibling::li/span[contains(@class,'active') and contains(.,'UA')]")
    private ExtendedWebElement languageUA;

    @FindBy(xpath = "//button[contains(@class, 'side-menu__button') and contains(.,'Кошик')]")
    private ExtendedWebElement basketBtn;

    @FindBy(xpath = "//li//button[@id= 'fat-menu']")
    private ExtendedWebElement catalogBtn;

    public HamburgerMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isLoginButtonPresent() {
        return loginBtn.isElementPresent();
    }

    public boolean isCatalogButtonPresent() {
        return catalogBtn.isElementPresent();
    }

    public boolean isBasketButtonPresent() {
        return basketBtn.isElementPresent();
    }

    public String getLanguageTextFromHamburgerMenu() {
        return languageUA.getText().replace(" ", "");
    }
}
