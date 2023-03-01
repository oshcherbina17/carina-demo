package com.qaprosoft.carina.demo.web.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.ProductStatus;
import com.qaprosoft.carina.demo.web.enums.SortDropdown;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductFilter extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalCheckbox;

    @FindBy(xpath = "//option[contains(.,'За рейтингом')][1]")
    private ExtendedWebElement ratingDropdownMenu;

    @FindBy(xpath = "//option[@class='ng-star-inserted' and contains(.,'%s')]")
    private ExtendedWebElement universalDropdownMenu;

    public ProductFilter(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void selectFilter(FilterType filterType) { //filter
        universalCheckbox.format(filterType.getType()).click();
    }

    public void selectStateCheckBox(ProductStatus productStatus) {
        waitUntil(ExpectedConditions.titleContains("Статус товару"),3);
        universalCheckbox.format(productStatus.getStatusType()).click();
    }

    public void sortDropdownMenu(SortDropdown sortDropdown) {
        ratingDropdownMenu.click();
        universalDropdownMenu.format(sortDropdown.getSortType()).click();
    }
}
