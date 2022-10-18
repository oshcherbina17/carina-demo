package com.qaprosoft.carina.demo.web.gui.components;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.utils.factory.ICustomTypePageFactory;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.web.gui.common.ContactsPageBase;
import com.qaprosoft.carina.demo.web.enums.FooterLinks;
import com.qaprosoft.carina.demo.web.enums.SocialLinks;

public class FooterMenu extends AbstractUIObject implements ICustomTypePageFactory {

    @FindBy(xpath = "//a[contains(@class, 'socials__link--facebook')]")
    private WebElement facebookIcon;

    @FindBy(xpath = "//h3[@class='footer-stores__heading']")
    private ExtendedWebElement footerTitleText;

    @FindBy(xpath = "//a[(@title='%s')]")
    private ExtendedWebElement universalSocialIcon;

    @FindBy(xpath = "//a[contains(@class, 'ng-tns-c91-0') and contains(.,'%s')]")
    private ExtendedWebElement universalFooterLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isSocialIconPresent(SocialLinks socialLinks) {
        return universalSocialIcon.format(socialLinks.getIcon()).isElementPresent();
    }

    public ContactsPageBase clickOnFooterLink(FooterLinks footerLinks) {
        universalFooterLink.format(footerLinks.getLink()).click();
        return initPage(getDriver(), ContactsPageBase.class);
    }
}
