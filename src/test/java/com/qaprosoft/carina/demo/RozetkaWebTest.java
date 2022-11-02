package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.web.enums.ProductStatus;
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
import com.qaprosoft.carina.demo.web.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.enums.SocialLinks;
import com.qaprosoft.carina.demo.web.enums.SortDropdown;
import com.qaprosoft.carina.demo.web.gui.common.AppleBrandPageBase;
import com.qaprosoft.carina.demo.web.gui.common.CoffeeMachinePageBase;
import com.qaprosoft.carina.demo.web.gui.common.ComparisonPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ContactsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.HouseholdGoodsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.LaptopItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.LaptopsAndPCPageBase;
import com.qaprosoft.carina.demo.web.gui.common.OrderPageBase;
import com.qaprosoft.carina.demo.web.gui.common.PCTablesPageBase;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;
import com.qaprosoft.carina.demo.web.gui.common.TableItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.TabletsPageBase;
import com.qaprosoft.carina.demo.web.gui.components.Basket;
import com.qaprosoft.carina.demo.web.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.web.gui.components.HamburgerMenu;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.components.LoginForm;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import com.zebrunner.agent.core.annotation.TestLabel;

public class RozetkaWebTest implements IAbstractTest {

    final int INDEX_ZERO = 0;
    final int INDEX_ONE = 1;
    final int INDEX_TWO = 2;
    final int INDEX_FOUR = 4;

    @Test(description = "User can add filters for products.")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"web"})
    public void testVerifyCheckBrand() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        LaptopsAndPCPageBase laptopsAndPCPageBase = (LaptopsAndPCPageBase) homePage.clickOnCategoryMenu(MenuCategory.LAPTOPS_COMPUTERS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) laptopsAndPCPageBase.clickOnCategoriesLink(Devices.TABLETS);
        tabletsPageBase.selectBrand(FilterType.BRAND_APPLE);
        tabletsPageBase.selectRAM(FilterType.RAM);
        tabletsPageBase.selectStateCheckBox(ProductStatus.AVAILABLE);
        Assert.assertTrue(tabletsPageBase.checkChosenBrand(INDEX_ZERO, FilterType.BRAND_APPLE.getType()));
    }

    @Test(description = "User can sort dropdown menu and check if products add to basket.")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"web"})
    public void testSortLowToHigh() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        LaptopsAndPCPageBase laptopsAndPCPageBase = (LaptopsAndPCPageBase) homePage.clickOnCategoryMenu(MenuCategory.LAPTOPS_COMPUTERS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) laptopsAndPCPageBase.clickOnCategoriesLink(Devices.TABLETS);
        tabletsPageBase.selectBrand(FilterType.BRAND_APPLE);
        tabletsPageBase.sortDropdownMenu(SortDropdown.LOW_TO_HIGH);
        Assert.assertTrue(tabletsPageBase.sortLowToHighPrice(), "Price not sorted ");
        tabletsPageBase.clickOnBasketIcon(INDEX_ONE);
        Assert.assertTrue(tabletsPageBase.addedItemsCounterIsPresent(), "Added Items Counter not exist");
    }

    @Test(description = "User can add filters for products. Check if device title and sum equals chosen product.")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"web"})
    public void testVerifyBrandCheckTitleAndSum() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.TABLETS);
        tabletsPageBase.selectBrand(FilterType.BRAND_LENOVO);
        tabletsPageBase.sortDropdownMenu(SortDropdown.NEW);
        String deviceTitleText = tabletsPageBase.getTabletTitleText(INDEX_ZERO);
        LaptopItemsPageBase laptopItemsPageBase = tabletsPageBase.clickOnLaptopDevice(INDEX_ZERO);
        laptopItemsPageBase.moveToTitleText();
        String productTitleText = laptopItemsPageBase.getProductTitleText();
        Assert.assertEquals(productTitleText, deviceTitleText, "Texts are not equals");
        laptopItemsPageBase.clickOnBuyButton();
        Basket basket = laptopItemsPageBase.getBasketMenu();
        String sumPrice = basket.getSumPriceText();
        OrderPageBase orderPageBase = basket.clickOnOrderButton();
        String param = "Разом";
        String paymentSum = orderPageBase.getPaymentSumText(param);
        Assert.assertEquals(paymentSum, sumPrice, "Sum are not equals");
    }

    @Test(description = "User can type in search field name of products. Add filters and compare two different products.")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"web"})
    public void testCompareProducts() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        CoffeeMachinePageBase coffeeMachinePageBase = headerMenu.searchProductItems(FilterType.COFFEE_MACHINE);
        coffeeMachinePageBase.productNameFilterClick(FilterType.FILTER_COFFEE_MACHINE);
        Assert.assertTrue(coffeeMachinePageBase.isTitleTextContainsProductType(FilterType.COFFEE_MACHINE), "Title text don't contains this product");
        coffeeMachinePageBase.selectBrand(FilterType.BRAND_DELONGHI);
        coffeeMachinePageBase.clickOnCompareIcon(INDEX_ZERO);
        coffeeMachinePageBase.clickOnCompareIcon(INDEX_TWO);
        Assert.assertTrue(coffeeMachinePageBase.addedItemsCompareCounterIsPresent(), "Added Items Counter isn't present");
        coffeeMachinePageBase.clickOnAddedCompareBtn();
        ComparisonPageBase comparisonPageBase = coffeeMachinePageBase.clickOnProductType();
        Assert.assertTrue(comparisonPageBase.allParameterBtnIsPresent(), "All Parameter button isn't present");
    }

    @Test(description = "User can add filters for products. And check reviews which sorted by date.")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"web"})
    public void testCheckReviewsForDate() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        Assert.assertTrue(headerMenu.isCatalogButtonPresent(), "Catalog button isn't presented");
        headerMenu.clickOnCatalogButton();
        HouseholdGoodsPageBase householdGoodsPageBase = (HouseholdGoodsPageBase) headerMenu.clickOnCategoryMenu(MenuCategory.HOUSEHOLD_GOODS);
        PCTablesPageBase pcTablesPageBase = (PCTablesPageBase) householdGoodsPageBase.clickOnCategoriesLink(FurnitureSubcategory.PC_TABLES);
        pcTablesPageBase.selectRegulate(FilterType.ELECTRIC_TYPE);
        TableItemsPageBase tableItemsPageBase = pcTablesPageBase.clickOnProductTitle(INDEX_ONE);
        tableItemsPageBase.clickOnTab(ProductTabs.REVIEWS);
        tableItemsPageBase.selectDropdownOption(SortDropdown.DATE);
        Assert.assertTrue(tableItemsPageBase.isOpinionsSortedByDate(), "List isn't sorted by date");
    }

    @Test(description = "User can check device type,check if footer menu contains social icon. Check delivery addresses.")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"web"})
    public void testCheckDeviceTypeAndFooterMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        AppleBrandPageBase appleBrandPageBase = phonesAndElectronicsPageBase.clickOnBrandLink();
        Assert.assertTrue(appleBrandPageBase.isDeviceTypePresent(AppleDevices.STYLUS), "Device type isn't presented");
        FooterMenu footerMenu = appleBrandPageBase.getFooterMenu();
        Assert.assertTrue(footerMenu.isSocialIconPresent(SocialLinks.TELEGRAM), "Social icon isn't presented");
        Assert.assertTrue(footerMenu.isFooterLinksPresent(FooterLinks.CONTACTS), "Footer link isn't presented");
        ContactsPageBase contactsPageBase = footerMenu.clickOnFooterLink(FooterLinks.CONTACTS);
        Assert.assertTrue(contactsPageBase.isAddressListPresent(INDEX_ZERO), "Address list aren't presented");
    }

    @Test(description = "User can check if buttons present on Hamburger Menu. And compare the language that its are equals.")
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"web"})
    public void testVerifyHamburgerMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
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
    @TestLabel(name = "feature", value = {"web"})
    public void testAddAndDeleteItemsFromBasket() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase = headerMenu.searchItems(FilterType.SEARCH_BRIT);
        searchPageBase.clickAddToBagButton(INDEX_ONE);
        searchPageBase.clickOnBasketButton();
        Basket basket = searchPageBase.getBasketMenu();
        Assert.assertFalse(basket.getCardStatus(), "Basket is empty");
        basket.clickOnContinueBuyButton();
        searchPageBase.clickAddToBagButton(INDEX_FOUR);
        searchPageBase.clickOnBasketButton();
        int itemsSize = 2;
        Assert.assertEquals(basket.getSizeTitleText(), itemsSize, "The size list are equals");
        basket.deleteItemsFromBasket();
        Assert.assertTrue(basket.getCardStatus(), "Basket isn't empty");
    }

    @Test(description = "User can check if login form is opened and all input fields are presented.") //
    @MethodOwner(owner = "oshcherbina")
    @TestLabel(name = "feature", value = {"web"})
    public void testVerifyLoginForm() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        homePage.clickOnLoginButton();
        LoginForm loginForm = homePage.getLoginForm();
        Assert.assertTrue(loginForm.isEmailInputPresent(), "Email input isn't presented");
        Assert.assertTrue(loginForm.isPasswordInputPresent(), "Password input isn't presented");
        Assert.assertTrue(loginForm.isSignInButtonPresent(), "Sign In Button isn't presented");
        Assert.assertTrue(loginForm.isSocialButtonPresent(SocialLinks.FACEBOOK), "Facebook Button isn't presented");
        Assert.assertTrue(loginForm.isSocialButtonPresent(SocialLinks.GOOGLE), "Google Button isn't presented");
    }
}
