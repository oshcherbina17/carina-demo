package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.gui.common.PCTablesPageBase;
import com.qaprosoft.carina.demo.web.gui.common.TableItemsPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PCTablesPageBase.class)
public class PCTablesPage extends PCTablesPageBase {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalCheckbox;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> titleProductList;

    @FindBy(xpath = "//button[contains(@class, 'goods-tile__buy-button')]")
    private List<ExtendedWebElement> basketIcon;

    public PCTablesPage(WebDriver driver) {
        super(driver);
        setPageURL("kompyuternye-stoly/c155285/");
    }

    @Override
    public void selectRegulate(FilterType filterType) {
        universalCheckbox.format(filterType.getType()).click();
    }

    @Override
    public void selectColor(FilterType filterType) {
        universalCheckbox.format(filterType.getType()).click();
    }

    @Override
    public TableItemsPageBase clickOnProductTitle(int index) {
        basketIcon.get(index).sendKeys(Keys.PAGE_UP);
        titleProductList.get(index).click();
        return initPage(getDriver(), TableItemsPageBase.class);
    }
}
