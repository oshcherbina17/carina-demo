package com.qaprosoft.carina.demo.web.gui.desktop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.components.LoginForm;
import com.qaprosoft.carina.demo.web.gui.common.HomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {

    @FindBy(xpath = "//a[@class='menu-categories__link' and contains(., '%s')]")
    private ExtendedWebElement universalCategoryMenu;

    @FindBy(xpath = "//span[@class='exponea-close-cross']")
    private ExtendedWebElement closePopupBtn1;
    @FindBy(xpath = "//span[contains(@class,'exponea-close ')]")
    private ExtendedWebElement closePopupBtn;

    @FindBy(xpath = "//a[contains(@class,'exponea-banner')]")
    private WebElement popup;

    @FindBy(xpath = "//button[contains(@class,'button--navy button--small')]")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//div[contains(@class,'modal__holder modal__holder_show_animation')]")
    private LoginForm loginForm;
    @FindBy(xpath = "//div[@class='header-layout']")
    private HeaderMenu headerMenu;

    @FindBy(xpath = "//div[@class='header-layout']")
    private ExtendedWebElement header;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public AbstractPage clickOnCategoryMenu(MenuCategory menuCategory) {
        universalCategoryMenu.format(menuCategory.getNamePage()).click();
        return initPage(getDriver(), menuCategory.getPageClass());
    }

    public HeaderMenu getHeader() {
        return headerMenu;
    }

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public void clickOnClosePopupButton(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        getDriver().switchTo().activeElement().findElement(By.xpath("//a[contains(@class,'exponea-banner')]"));
        closePopupBtn.click();
    }

    public void clickOnLoginButton(){
        loginBtn.click();
    }

    public boolean isHeaderPresent() {
        return header.isPresent();
    }
}
