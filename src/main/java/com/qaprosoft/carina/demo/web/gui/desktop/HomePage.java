package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.components.LoginForm;
import com.qaprosoft.carina.demo.web.gui.common.HomePageBase;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//a[@class='menu-categories__link' and contains(., '%s')]")
    private ExtendedWebElement universalCategoryMenu;

    @FindBy(xpath = "//span[@class='exponea-close-cross']")
    private ExtendedWebElement closePopupBtn;

    @FindBy(xpath = "//button[contains(@class,'button--navy button--small')]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class,'modal__holder modal__holder_show_animation')]")
    private LoginForm loginForm;
    @FindBy(xpath = "//div[@class='header-layout']")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[@class='header-layout']")
    private ExtendedWebElement header;

    @FindBy(xpath = "//div[@class='header-topline__language-item']")
    private ExtendedWebElement languagesBtn;
  
    @FindBy(xpath = "//ul[@class='header-topline__language-dropdown']")
    private ExtendedWebElement languageList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AbstractPage clickOnCategoryMenu(MenuCategory menuCategory) {
        universalCategoryMenu.format(menuCategory.getNamePage()).click();
        return initPage(getDriver(), menuCategory.getPageClass());
    }

    public AbstractPage clickOnCategoryMenuWithL10N(MenuCategory menuCategory) {
        universalCategoryMenu.format(L10N.getText(menuCategory.getNamePage())).click();
        return initPage(getDriver(), menuCategory.getPageClass());
    }

    public HeaderMenu getHeader() {
        return headerMenu;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void clickOnClosePopupButton(){
        closePopupBtn.clickIfPresent(3);
    }

    public void clickOnLoginButton(){
        loginBtn.click();
    }

    public boolean isHeaderPresent() {
        return header.isPresent();
    }

    public String getCategoryText(MenuCategory menuCategory) {
        return universalCategoryMenu.format(menuCategory.getNamePage()).getText();
    }
}
