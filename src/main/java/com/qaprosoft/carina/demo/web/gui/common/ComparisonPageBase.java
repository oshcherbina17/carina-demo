package com.qaprosoft.carina.demo.web.gui.common;

import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.gui.AbstractPage;

public abstract class ComparisonPageBase extends AbstractPage {

    public ComparisonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean allParameterBtnIsPresent();
}
