package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.ComparisonPageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ComparisonPageBase.class)
public class ComparisonPage extends ComparisonPageBase {

    @FindBy(xpath = "//button[contains(@class, 'comparison-settings__toggle')]")
    private ExtendedWebElement comparisonBtn;

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean allParameterBtnIsPresent() {
      return comparisonBtn.isElementPresent();
    }
}
