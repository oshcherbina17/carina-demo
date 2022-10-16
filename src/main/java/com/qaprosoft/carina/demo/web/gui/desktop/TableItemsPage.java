package com.qaprosoft.carina.demo.web.gui.desktop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.utils.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.utils.enums.SortDropdown;
import com.qaprosoft.carina.demo.web.gui.common.TableItemsPageBase;


@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = TableItemsPageBase.class)
public class TableItemsPage extends TableItemsPageBase {

    @FindBy(xpath = "//a[@class='tabs__link' and contains(.,'%s')]")
    private ExtendedWebElement universalProductTabs;

    @FindBy(xpath = "//option[@class='ng-star-inserted' and contains(.,'%s')]")
    private ExtendedWebElement universalDropdownMenu;

    @FindBy(xpath = "//span[text()='Колір']/../following-sibling::*[@class='characteristics-full__value']//a[contains(@class, 'ng-star-inserted')]")
    private ExtendedWebElement chosenColor;

    @FindBy(xpath = "//*[name()='svg' and contains(@class, 'comment__label')]/following-sibling::*/time[contains(@class, 'comment__date')]")
    private List<ExtendedWebElement> dataReviewsList;

    public TableItemsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickOnTab(ProductTabs product) {
        universalProductTabs.format(product.getType()).click();
    }

    @Override
    public void selectDropdownOption(SortDropdown sortDropdown) {
        universalDropdownMenu.format(sortDropdown.getSortType()).click();
    }

    @Override
    public boolean isChosenColorCorrect(String color) {
        return chosenColor.getText().contains(color);
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
}
