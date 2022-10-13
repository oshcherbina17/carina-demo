package com.qaprosoft.carina.demo.web.components;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.gui.common.CoffeeMachinePageBase;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//button[@class='header__button ng-tns-c94-1']")
    private ExtendedWebElement burgerMenu;

    @FindBy(xpath = "//input[@class='search-form__input ng-untouched ng-pristine ng-valid']")
    private ExtendedWebElement searchInput;

    @FindBy(xpath = "//button[@class='button button_color_green button_size_medium search-form__submit ng-star-inserted']")
    private ExtendedWebElement searchBtn;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CoffeeMachinePageBase searchProductItems(String productName) {
        searchInput.type(productName);
        searchBtn.click();
        return initPage(getDriver(), CoffeeMachinePageBase.class);
    }
}
