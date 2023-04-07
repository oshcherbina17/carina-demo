package com.qaprosoft.carina.demo.rozetka;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.enums.AppleDevices;
import com.qaprosoft.carina.demo.web.enums.Devices;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.FooterLinks;
import com.qaprosoft.carina.demo.web.enums.FurnitureSubcategory;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.enums.ProductStatus;
import com.qaprosoft.carina.demo.web.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.enums.SocialLinks;
import com.qaprosoft.carina.demo.web.enums.SortDropdown;
import com.qaprosoft.carina.demo.web.gui.common.AppleBrandPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ComparisonPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ContactsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.HouseholdGoodsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.LaptopsAndPCPageBase;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductDetailsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;
import com.qaprosoft.carina.demo.web.gui.components.Basket;
import com.qaprosoft.carina.demo.web.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.web.gui.components.HamburgerMenu;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.components.LoginForm;
import com.qaprosoft.carina.demo.web.gui.components.ProductFilter;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;

public class RozetkaWebTest implements IAbstractTest {
    final int INDEX_ZERO = 0;
    final int INDEX_ONE = 1;
    final int INDEX_TWO = 2;

    @Test(description = "User can add filters for products.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyCheckBrand() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        getDriver().manage().window().fullscreen();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        LaptopsAndPCPageBase laptopsAndPCPageBase =
                (LaptopsAndPCPageBase) homePage.clickOnCategoryMenu(MenuCategory.LAPTOPS_COMPUTERS);
        ProductListPageBase productListPage = laptopsAndPCPageBase.clickOnCategoriesLink(Devices.TABLETS);
        getDriver().manage().window().fullscreen();
        ProductFilter productFilter = productListPage.getFilter();
        productFilter.selectFilter(FilterType.BRAND_APPLE);
        productFilter.selectFilter(FilterType.RAM);
        productFilter.selectStateCheckBox(ProductStatus.AVAILABLE);
        Assert.assertTrue(productListPage.checkChosenBrand(INDEX_ZERO, FilterType.BRAND_APPLE.getType()),
                "Chosen brand isn't selected");
    }

    @Test(description = "User can sort dropdown menu and check if products add to basket.")
    @MethodOwner(owner = "oshcherbina")
    public void testSortLowToHigh() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        getDriver().manage().window().fullscreen();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        LaptopsAndPCPageBase laptopsAndPCPageBase =
                (LaptopsAndPCPageBase) homePage.clickOnCategoryMenu(MenuCategory.LAPTOPS_COMPUTERS);
        ProductListPageBase productListPage = laptopsAndPCPageBase.clickOnCategoriesLink(Devices.TABLETS);
        getDriver().manage().window().fullscreen();
        ProductFilter productFilter = productListPage.getFilter();
        productFilter.selectFilter(FilterType.BRAND_APPLE);
        productFilter.sortDropdownMenu(SortDropdown.LOW_TO_HIGH);
        Assert.assertTrue(productListPage.sortLowToHighPrice(), "Price not sorted ");
        productListPage.clickOnBasketIcon(INDEX_ONE);
        Assert.assertTrue(productListPage.addedItemsCounterIsPresent(), "Added Items Counter not exist");
    }

    @Test(description = "User can add filters for products. Check if device title and sum equals chosen product.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyBrandCheckTitleAndSum() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase =
                (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        ProductListPageBase productListPage = phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.TABLETS);
        ProductFilter productFilter = productListPage.getFilter();
        productFilter.selectFilter(FilterType.BRAND_LENOVO);
        productFilter.sortDropdownMenu(SortDropdown.NEW);
        String deviceTitleText = productListPage.getTabletTitleText(INDEX_ZERO);
        ProductDetailsPageBase productDetailsPage = productListPage.clickOnDeviceTitle(INDEX_ZERO);
        productDetailsPage.moveToTitleText();
        String productTitleText = productDetailsPage.getProductTitleText();
        Assert.assertEquals(productTitleText, deviceTitleText, "Texts are not equals");
        productDetailsPage.clickOnBuyButton();
        Basket basket = productDetailsPage.getBasketMenu();
        String sumPrice = basket.getSumPriceText();
        String itemsSum = basket.getItemPriceText();
        Assert.assertEquals(itemsSum, sumPrice, "Sum are not equals");
    }

    @Test(description = "User can type in search field name of products. " +
            "Add filters and compare two different products.")
    @MethodOwner(owner = "oshcherbina")
    public void testCompareProducts() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase= headerMenu.searchItems(FilterType.COFFEE_MACHINE);
        ProductListPageBase productListPageBase = searchPageBase.productTypeLinkClick(FilterType.FILTER_COFFEE_MACHINE);
        productListPageBase.productTypeLinkClick(FilterType.FILTER_COFFEE_MACHINE);
        ProductFilter productFilter = productListPageBase.getFilter();
        productFilter.selectFilter(FilterType.BRAND_DELONGHI);
        productListPageBase.clickOnCompareIcon(INDEX_ZERO);
        productListPageBase.clickOnCompareIcon(INDEX_TWO);
        Assert.assertTrue(productListPageBase.addedItemsCompareCounterIsPresent(),
                "Added Items Counter isn't present");
        productListPageBase.clickOnAddedCompareBtn();
        ComparisonPageBase comparisonPageBase = productListPageBase.clickOnProductType();
        Assert.assertTrue(comparisonPageBase.allParameterBtnIsPresent(),
                "All Parameter button isn't present");
    }

    @Test(description = "User can add filters for products. And check reviews which sorted by date.")
    @MethodOwner(owner = "oshcherbina")
    public void testCheckReviewsForDate() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        Assert.assertTrue(headerMenu.isCatalogButtonPresent(), "Catalog button isn't presented");
        headerMenu.clickOnCatalogButton();
        HouseholdGoodsPageBase householdGoodsPageBase =
                (HouseholdGoodsPageBase) headerMenu.clickOnCategoryMenu(MenuCategory.HOUSEHOLD_GOODS);
        ProductListPageBase productListPage =
                (ProductListPageBase) householdGoodsPageBase.clickOnCategoriesLink(FurnitureSubcategory.PC_TABLES);
        ProductFilter productFilter = productListPage.getFilter();
        productFilter.selectFilter(FilterType.ELECTRIC_TYPE);
        ProductDetailsPageBase productDetailsPageBase= productListPage.clickOnProductTitle(INDEX_ONE);
        productDetailsPageBase.clickOnTab(ProductTabs.REVIEWS);
        productDetailsPageBase.selectDropdownOption(SortDropdown.DATE);
        Assert.assertTrue(productDetailsPageBase.isOpinionsSortedByDate(), "List isn't sorted by date");
    }

    @Test(description = "User can check device type, if footer menu contains social icon. Check delivery addresses.")
    @MethodOwner(owner = "oshcherbina")
    public void testCheckDeviceTypeAndFooterMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");

        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase =
                (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        AppleBrandPageBase appleBrandPageBase = phonesAndElectronicsPageBase.clickOnBrandLink();
        Assert.assertTrue(appleBrandPageBase.isDeviceTypePresent(AppleDevices.STYLUS),
                "Device type isn't presented");
        FooterMenu footerMenu = appleBrandPageBase.getFooterMenu();
        Assert.assertTrue(footerMenu.isSocialIconPresent(SocialLinks.TELEGRAM),
                "Social icon isn't presented");
        Assert.assertTrue(footerMenu.isFooterLinksPresent(FooterLinks.CONTACTS),
                "Footer link isn't presented");
        ContactsPageBase contactsPageBase = footerMenu.clickOnFooterLink(FooterLinks.CONTACTS);
        Assert.assertTrue(contactsPageBase.isAddressListPresent(INDEX_ZERO),
                "Address list aren't presented");
    }

    @Test(description = "User can check if buttons present on Hamburger Menu. And compare the language that its are equals.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyHamburgerMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");

        HeaderMenu headerMenu = homePage.getHeader();
        String textLanguage = headerMenu.getLanguageText();
        Assert.assertTrue(headerMenu.isHamburgerMenuPresent(), "Hamburger Menu isn't presented");
        headerMenu.clickOnHamburgerMenu();
        HamburgerMenu hamburgerMenu = headerMenu.getHamburgerMenu();
        Assert.assertTrue(hamburgerMenu.isLoginButtonPresent(), "Login Button isn't presented");
        Assert.assertTrue(hamburgerMenu.isCatalogButtonPresent(), "Catalog isn't presented");
        Assert.assertTrue(hamburgerMenu.isBasketButtonPresent(), "Basket Button isn't presented");
        String textLanguageFromHamburger = hamburgerMenu.getLanguageTextFromHamburgerMenu();
        Assert.assertEquals(textLanguageFromHamburger, textLanguage, "Language texts are not equals");
    }

    @Test(description = "User can add items to basket. Check if basket not empty. And can delete all items in basket.")
    @MethodOwner(owner = "oshcherbina")
    public void testAddAndDeleteItemsFromBasket() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");

        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase = headerMenu.searchItems(FilterType.SEARCH_BRIT);
        searchPageBase.clickAddToBagButton(INDEX_ONE);
        searchPageBase.clickAddToBagButton(INDEX_TWO);
        searchPageBase.clickOnBasketButton();
        Basket basket = searchPageBase.getBasketMenu();
        Assert.assertFalse(basket.getCardStatus(), "Basket is empty");
        basket.deleteItemsFromBasket();
        Assert.assertTrue(basket.getCardStatus(), "Basket isn't empty");
    }

    @Test(description = "User can check if login form is opened and all input fields are presented.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyLoginForm() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        homePage.clickOnLoginButton();
        LoginForm loginForm = homePage.getLoginForm();
        Assert.assertTrue(loginForm.isEmailInputPresent(), "Email input isn't presented");
        Assert.assertTrue(loginForm.isPasswordInputPresent(), "Password input isn't presented");
        Assert.assertTrue(loginForm.isSignInButtonPresent(), "Sign In Button isn't presented");
        Assert.assertTrue(loginForm.isSocialButtonPresent(SocialLinks.FACEBOOK), "Facebook Button isn't presented");
        Assert.assertTrue(loginForm.isSocialButtonPresent(SocialLinks.GOOGLE), "Google Button isn't presented");
    }
}
