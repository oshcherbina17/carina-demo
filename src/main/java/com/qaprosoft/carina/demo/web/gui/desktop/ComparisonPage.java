package com.qaprosoft.carina.demo.web.gui.desktop;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.ComparisonPageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = ComparisonPageBase.class)
public class ComparisonPage extends ComparisonPageBase {

    @FindBy(xpath = "//button[@class='button button--medium button--with-icon button--link comparison-settings__button comparison-settings__toggle ng-star-inserted comparison-settings__toggle--toggled']")
    private ExtendedWebElement allParameterBtn;

    public ComparisonPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean allParameterBtnIsPresent() {
      return allParameterBtn.isElementPresent();
    }
}
