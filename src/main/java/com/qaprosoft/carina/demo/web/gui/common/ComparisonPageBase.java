package com.qaprosoft.carina.demo.web.gui.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ComparisonPageBase extends AbstractPage {

    public ComparisonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean allParameterBtnIsPresent();
}
