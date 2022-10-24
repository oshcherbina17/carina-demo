package com.qaprosoft.carina.demo.web.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.enums.SocialLinks;

public class LoginForm extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(id = "auth_email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "auth_pass")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'button--green auth-modal__submit')]")
    private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//button[contains(@class,'button--gray button--with-icon') and contains(., '%s')]")
    private ExtendedWebElement universalSocialBtn;

    public LoginForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isEmailInputPresent() {
        return emailInput.isElementPresent();
    }

    public boolean isPasswordInputPresent() {
        return passwordInput.isElementPresent();
    }

    public boolean isSignInButtonPresent() {
        return signInBtn.isElementPresent();
    }

    public boolean isSocialButtonPresent(SocialLinks socialLinks) {
        return universalSocialBtn.format(socialLinks.getIcon()).isElementPresent();
    }
}
