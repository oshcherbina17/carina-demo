package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.demo.web.gui.common.TableItemsPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.demo.web.gui.common.PCTablesPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = PCTablesPageBase.class)
public class PCTablesPage extends PCTablesPageBase {

    @FindBy(xpath = "//a[@data-id='%s']")
    private ExtendedWebElement universalCheckbox;

    @FindBy(xpath = "//span[@class='goods-tile__title']")
    private List<ExtendedWebElement> titleProductList;

    public PCTablesPage(WebDriver driver) {
        super(driver);
        setPageURL("kompyuternye-stoly/c155285/");
    }

    @Override
    public void selectRegulate(String type) {
        universalCheckbox.format(type).click();
    }

    @Override
    public void selectColor(String type) {
        universalCheckbox.format(type).click();
    }

    @Override
    public TableItemsPageBase clickOnProductTitle(int index) {
        titleProductList.get(index).click();
        return initPage(getDriver(), TableItemsPageBase.class);
    }
}
