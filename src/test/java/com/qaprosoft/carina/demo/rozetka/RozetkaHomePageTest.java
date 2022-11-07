package com.qaprosoft.carina.demo.rozetka;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.components.LoginForm;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;

public class RozetkaHomePageTest implements IAbstractTest {

    final String USER_EMAIL_VALID = "oshcherbina@solvd.com";
    final String INCORRECT_EMAIL = "gfjdksllvb@ff";
    final String PASSWORD_VALID = "solvD1717";

    @Test(description = "User can login.")
    @MethodOwner(owner = "oshcherbina")
    public void verifySuccessLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        Assert.assertTrue(homePage.isHeaderPresent(), "Header isn't presented");
        HeaderMenu header = homePage.getHeader();
        Assert.assertTrue(header.isLoginIconPresent(), "Login icon isn't presented");
        LoginForm loginForm = header.openLoginField();
        Assert.assertTrue(loginForm.isEmailInputPresent(), "Email field isn't presented");
        loginForm.typeEmailField(USER_EMAIL_VALID);
        loginForm.typePasswordField(PASSWORD_VALID);
        loginForm.loginBtnClick();
        loginForm.clickOnRecaptchaButton();
        loginForm.loginBtnClick();
        Assert.assertTrue(homePage.getHeader().isOrderButtonPresent(), "Operation login are not successful");
    }

    @Test(description = "User can't login with wrong email.")
    @MethodOwner(owner = "oshcherbina")
    public void verifyLoginWithWrongEmail() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        Assert.assertTrue(homePage.isHeaderPresent(), "Header isn't presented");
        HeaderMenu header = homePage.getHeader();
        Assert.assertTrue(header.isLoginIconPresent(), "Login icon isn't presented");
        LoginForm loginForm = header.openLoginField();
        Assert.assertTrue(loginForm.isEmailInputPresent(), "Email field isn't presented");
        loginForm.typeEmailField(INCORRECT_EMAIL);
        loginForm.typePasswordField(PASSWORD_VALID);
        loginForm.loginBtnClick();
        loginForm.loginBtnClick();
        Assert.assertTrue(loginForm.isLoginFailedTextPresent(), "Incorrect email.");
    }
}
