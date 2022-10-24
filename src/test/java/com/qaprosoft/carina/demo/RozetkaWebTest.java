package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.demo.web.gui.components.LoginForm;
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
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;

public class RozetkaWebTest implements IAbstractTest {

    @Test(description = "User can add different filters for products. Sort dropdown menu and check if products" +
            " add to basket.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyCheckBrandAndSortLowToHigh() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        LaptopsAndPCPageBase laptopsAndPCPageBase = (LaptopsAndPCPageBase) homePage.clickOnCategoryMenu(MenuCategory.LAPTOPS_COMPUTERS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) laptopsAndPCPageBase.clickOnCategoriesLink(Devices.TABLETS);
        tabletsPageBase.selectBrand(FilterType.BRAND_APPLE);
        tabletsPageBase.selectRAM(FilterType.RAM);
        tabletsPageBase.selectStateCheckBox(ProductStatus.AVAILABLE);
        tabletsPageBase.sortDropdownMenu(SortDropdown.LOW_TO_HIGH);
        Assert.assertTrue(tabletsPageBase.sortLowToHighPrice(), "Price not sorted ");
        tabletsPageBase.clickOnBasketIcon(2);
        Assert.assertTrue(tabletsPageBase.addedItemsCounterIsPresent(), "Added Items Counter not exist");
    }

    @Test(description = "User can add different filters for products. Check if device title" +
            " equals chosen product title. Check if sum price of product equals sum chosen product in basket.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyBrandCheckTitleAndSum() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.SMARTPHONES_TV_ELECTRONICS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.TABLETS);
        tabletsPageBase.selectBrand(FilterType.BRAND_LENOVO);
        tabletsPageBase.selectRAM(FilterType.RAM);
        tabletsPageBase.sortDropdownMenu(SortDropdown.NEW);
        String deviceTitleText = tabletsPageBase.getTabletTitleText(0);
        LaptopItemsPageBase laptopItemsPageBase = tabletsPageBase.clickOnLaptopDevice(0);
        String productTitleText = laptopItemsPageBase.getProductTitleText();
        Assert.assertEquals(productTitleText, deviceTitleText, "Texts are not equals");
        laptopItemsPageBase.clickOnBuyButton();
        Basket basket = laptopItemsPageBase.getBasketMenu();
        String sumPrice = basket.getSumPriceText();
        OrderPageBase orderPageBase = basket.clickOnOrderButton();
        String paymentSum = orderPageBase.getPaymentSumText();
        Assert.assertEquals(paymentSum, sumPrice, "Sum are not equals");
    }

    @Test(description = "User can type in search input field different name of products . Add filters and compare" +
            " two different products.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyProductAndCompareItems() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        CoffeeMachinePageBase coffeeMachinePageBase = headerMenu.searchProductItems(FilterType.COFFEE_MACHINE);
        coffeeMachinePageBase.productNameFilterClick(FilterType.FILTER_COFFEE_MACHINE);
        Assert.assertTrue(coffeeMachinePageBase.isTitleTextContainsProductType(FilterType.COFFEE_MACHINE), "Title text don't contains this product");
        coffeeMachinePageBase.selectBrand(FilterType.BRAND_DELONGHI);
        coffeeMachinePageBase.clickOnCompareIcon(0);
        coffeeMachinePageBase.clickOnCompareIcon(2);
        Assert.assertTrue(coffeeMachinePageBase.addedItemsCompareCounterIsPresent(), "Added Items Counter isn't present");
        coffeeMachinePageBase.clickOnAddedCompareBtn();
        ComparisonPageBase comparisonPageBase = coffeeMachinePageBase.clickOnProductType();
        Assert.assertTrue(comparisonPageBase.allParameterBtnIsPresent(), "All Parameter button isn't present");
    }

    @Test(description = "User can add different filters for products. Check if chosen filter color add. And " +
            "check reviews which sorted by date.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyFiltersAndCheckReviewsForDate() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        Assert.assertTrue(headerMenu.isCatalogButtonPresent(), "Catalog button isn't presented");
        headerMenu.clickOnCatalogButton();
        HouseholdGoodsPageBase householdGoodsPageBase = (HouseholdGoodsPageBase) headerMenu.clickOnCategoryMenu(MenuCategory.HOUSEHOLD_GOODS);
        PCTablesPageBase pcTablesPageBase = (PCTablesPageBase) householdGoodsPageBase.clickOnCategoriesLink(FurnitureSubcategory.PC_TABLES);
        pcTablesPageBase.selectRegulate(FilterType.ELECTRIC_TYPE);
        pcTablesPageBase.selectColor(FilterType.COLOR);
        TableItemsPageBase tableItemsPageBase = pcTablesPageBase.clickOnProductTitle(4);
        Assert.assertTrue(tableItemsPageBase.isChosenColorCorrect(FilterType.COLOR), "Color is not equals the chosen color");
        tableItemsPageBase.clickOnTab(ProductTabs.REVIEWS);
        tableItemsPageBase.selectDropdownOption(SortDropdown.DATE);
        Assert.assertTrue(tableItemsPageBase.isOpinionsSortedByDate(), "List isn't sorted by date");
    }

    @Test(description = "User can check chosen device type. And check if footer menu contains different social icon." +
            " And move to contact page and chose delivery addresses.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyDeviceTypeAndCheckFooterMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.SMARTPHONES_TV_ELECTRONICS);
        AppleBrandPageBase appleBrandPageBase = phonesAndElectronicsPageBase.clickOnBrandLink();
        Assert.assertTrue(appleBrandPageBase.isDeviceTypePresent(AppleDevices.STYLUS), "Device type isn't presented");
        FooterMenu footerMenu = appleBrandPageBase.getFooterMenu();
        Assert.assertTrue(footerMenu.isSocialIconPresent(SocialLinks.TELEGRAM), "Social icon isn't presented");
        ContactsPageBase contactsPageBase = footerMenu.clickOnFooterLink(FooterLinks.CONTACTS);
        Assert.assertTrue(contactsPageBase.isAddressListPresent(0), "Address list aren't presented");
    }

    @Test(description = "User can check if different buttons present on Hamburger Menu. And compare the language" +
            "that its are equals.")
    @MethodOwner(owner = "oshcherbina")
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

    @Test(description = "User can add different items to basket. Check if basket not empty." +
            "And can delete all items in basket.")
    @MethodOwner(owner = "oshcherbina")
    public void testVerifyAddAndDeleteItemsFromBasket() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase = headerMenu.searchItems(FilterType.SEARCH_BRIT);
        searchPageBase.clickOnBasketIcon(1);
        searchPageBase.clickOnBasketButton();
        Basket basket = searchPageBase.getBasketMenu();
        Assert.assertFalse(basket.getCardStatus(), "Basket is empty");
        basket.clickOnContinueBuyButton();
        searchPageBase.clickOnBasketIcon(8);
        searchPageBase.clickOnBasketButton();
        searchPageBase.getBasketMenu();
        Assert.assertEquals(basket.getSizeTitleText(), 2, "The size list are equals");
        basket.deleteItemsFromBasket(1);
        basket.deleteItemsFromBasket(0);
        Assert.assertTrue(basket.getCardStatus(), "Basket isn't empty");
    }

    @Test(description = "User can check if login form is opened and all input fields are presented.") //
    @MethodOwner(owner = "oshcherbina")
    public void testVerify() {
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
