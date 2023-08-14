package com.qaprosoft.carina.demo.web.gui.desktop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.enums.SortDropdown;
import com.qaprosoft.carina.demo.web.gui.common.ProductDetailsPageBase;
import com.qaprosoft.carina.demo.web.gui.components.Basket;
import com.qaprosoft.carina.demo.web.gui.components.PhotoModal;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ProductDetailsPageBase.class)
public class ProductDetailsPage extends ProductDetailsPageBase {

    @FindBy(xpath = "//h1[contains(@class,'product__title')]")
    private ExtendedWebElement productTitleText;

    @FindBy(xpath = "//span[text()=' Купити ']")
    private ExtendedWebElement buyBtn;

    @FindBy(xpath = "//span[text()=' В кошику ']")
    private ExtendedWebElement basketItemBtn;

    @FindBy(xpath = "//button[contains(@class,'header__button--active')]")
    private ExtendedWebElement basketBtn;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder--large')]")
    private Basket basket;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder')]")
    private ExtendedWebElement basketModal;

    @FindBy(xpath = "//h3[@class='modal__heading']")
    private ExtendedWebElement basketTitle;

    @FindBy(xpath = "//a[@class='tabs__link' and contains(.,'%s')]")
    private ExtendedWebElement universalProductTabs;

    @FindBy(xpath = "//option[@class='ng-star-inserted' and contains(.,'%s')]")
    private ExtendedWebElement universalDropdownMenu;

    @FindBy(xpath = "//a[@class='ng-star-inserted' and contains(text(),'Білий')]")
    private ExtendedWebElement chosenColor;

    @FindBy(xpath = "//li[contains(@class, 'product')]//img")
    private List<ExtendedWebElement> photoTab;

    @FindBy(xpath = "//div[contains(@class, 'modal__holder')]")
    private PhotoModal photoModal;

    @FindBy(xpath = "//div[@class='comment__author']/./time[contains(@class,'comment__date')]")
    private List<ExtendedWebElement> dataReviewsList;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductTitleText() {
        return productTitleText.getText();
    }

    @Override
    public void clickOnBuyButton() {
        buyBtn.click();
        if (!basketModal.isElementPresent(2)) {
            basketBtn.click();
        }
    }

    @Override
    public void moveToTitleText() {
        buyBtn.hover();
       // productTitleText.hover();
      //  waitUntil(ExpectedConditions.visibilityOfElementLocated(productTitleText.getBy()), 2);
        //waitUntil(ExpectedConditions.visibilityOfElementLocated(buyBtn.getBy()), 2);
    }

    @Override
    public Basket getBasketMenu() {
        return basket;
    }

    @Override
    public void clickOnTab(ProductTabs product) {
        universalProductTabs.format(product.getType()).click();
    }

    @Override
    public void selectDropdownOption(SortDropdown sortDropdown) {
        waitUntil(ExpectedConditions.visibilityOfElementLocated
                (universalDropdownMenu.format(sortDropdown.getSortType()).getBy()), 5);
        universalDropdownMenu.format(sortDropdown.getSortType()).click();
    }

    @Override
    public boolean isChosenColorCorrect(FilterType filterType) {
        return chosenColor.getText().contains(filterType.getType());
    }

    @Override
    public List<Date> getListOfCommentsDate() {
        List<Date> listOfDate = new ArrayList<Date>();
        for (ExtendedWebElement commentDate : dataReviewsList) {
            String stringDate = commentDate.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
            try {
                Date date = dateFormat.parse(stringDate);
                listOfDate.add(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return listOfDate;
    }

    @Override
    public boolean isOpinionsSortedByDate() {
        List<Date> listOfCommentsDate = getListOfCommentsDate();
        int res = 0;
        for (int i = 0; i < listOfCommentsDate.size() - 1; i++) {
            Date date = listOfCommentsDate.get(i);
            Date nextDate = listOfCommentsDate.get(i + 1);
            res = date.compareTo(nextDate);
        }
        return res >= 0;
    }

    @Override
    public void clickOnPhotoTab(int index) {
        photoTab.get(index).click();
    }

    @Override
    public PhotoModal getPhotoModal() {
        return photoModal;
    }
}
