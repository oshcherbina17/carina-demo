package com.qaprosoft.carina.demo.web.gui.desktop;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.enums.Devices;
import com.qaprosoft.carina.demo.web.gui.common.LaptopsAndPCPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LaptopsAndPCPageBase.class)
public class LaptopsAndPCPage extends LaptopsAndPCPageBase {

    @FindBy(xpath = "//a[contains(@class, 'tile-cats__heading_type_center') and contains(.,' %s ')]")
    private ExtendedWebElement universalCategoriesMenu;

    @FindBy(xpath = "//h1[contains(@class, 'portal__heading')]")
    private ExtendedWebElement titleText;

    public LaptopsAndPCPage(WebDriver driver) {
        super(driver);
        setPageURL("computers-notebooks/c80253/");
    }

    @Override
    public ProductListPageBase clickOnCategoriesLink(Devices devices) {
        universalCategoriesMenu.format(devices.getNamePage()).click();
        return initPage(getDriver(), ProductListPageBase.class);
    }

    @Override
    public String reverseWords(String str) {
        List words = Arrays.asList(str.split(" "));
        Collections.reverse(words);
        return String.join(" ", words).toLowerCase();
    }

    @Override
    public boolean getTitleText(String param) {
        String reverseTitle = reverseWords(titleText.getText().toLowerCase()).replace("'", "");
        String buffer = (param.toLowerCase()).replace("’", "");
        return reverseTitle.contains(buffer);
    }
}
