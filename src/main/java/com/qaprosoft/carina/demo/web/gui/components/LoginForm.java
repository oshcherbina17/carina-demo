package com.qaprosoft.carina.demo.web.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.enums.SocialLinks;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;

public class LoginForm extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(id = "auth_email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "auth_pass")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//button[contains(@class,'button--green auth-modal__submit')]")
    private ExtendedWebElement signInBtn;

    @FindBy(xpath = "//p[@class = 'error-message ng-star-inserted']")
    private ExtendedWebElement loginFailedText;

    @FindBy(id = "ngrecaptcha-0")
    private ExtendedWebElement recaptchaBtn;

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

    public void typeEmailField(String email) {
        emailInput.type(email);
    }

    public void typePasswordField(String password) {
        passwordInput.type(password);
    }

    public void clickOnRecaptchaButton() {
        waitUntil(ExpectedConditions.visibilityOfElementLocated(recaptchaBtn.getBy()), 2);
        recaptchaBtn.click();
    }

    public void loginBtnClick() {
        signInBtn.click();
    }

    public HomePage loginButtonClick() {
        loginBtnClick();
        return new HomePage(driver);
    }

    public boolean isLoginFailedTextPresent() {
        return loginFailedText.isPresent();
    }
}
