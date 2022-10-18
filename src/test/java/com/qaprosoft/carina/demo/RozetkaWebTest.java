package com.qaprosoft.carina.demo;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.demo.web.gui.components.Basket;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.common.*;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import com.qaprosoft.carina.demo.web.gui.components.FooterMenu;
import com.qaprosoft.carina.demo.web.enums.*;

public class RozetkaWebTest implements IAbstractTest {

    private final String BRAND_APPLE = "Apple";

    private final String BRAND_LENOVO = "Lenovo";

    private final String DEVICE_TYPE = "Стилуси";

    private final String BRAND_DELONGHI = "Delonghi";

    private final String RAM = "8 ГБ";

    private final String PRODUCT = "Кавомашина";

    private final String FILTER_NAME = "Кавоварки";

    private final String ELECTRIC_TYPE = "Електричний";

    private final String COLOR = "Білий";

    @Test
    @MethodOwner(owner = "olga")
    public void testVerifyCheckBrandAndSortLowToHigh() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LaptopsAndPCPageBase laptopsAndPCPageBase = (LaptopsAndPCPageBase) homePage.clickOnCategoryMenu(MenuCategory.LAPTOPS_COMPUTERS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) laptopsAndPCPageBase.clickOnCategoriesLink(Devices.TABLETS);
        tabletsPageBase.selectBrand(BRAND_APPLE);
        tabletsPageBase.selectBrand(RAM);
        tabletsPageBase.selectStateCheckBox(ProductStatus.AVAILABLE);
        tabletsPageBase.sortDropdownMenu(SortDropdown.LOW_TO_HIGH);
        Assert.assertTrue(tabletsPageBase.sortLowToHighPrice(), "Price not sorted ");
        tabletsPageBase.clickOnBasketIcon(2);
        Assert.assertTrue(tabletsPageBase.addedItemsCounterIsPresent(), "Added Items Counter not exist");
    }

    @Test
    @MethodOwner(owner = "olga")
    public void testVerifyBrandCheckTitleAndSum() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.SMARTPHONES_TV_ELECTRONICS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.TABLETS);
        tabletsPageBase.selectBrand(BRAND_LENOVO);
        tabletsPageBase.selectBrand(RAM);
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

    @Test
    @MethodOwner(owner = "olga")
    public void testVerifyProductAndCompareItems() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeader();
        CoffeeMachinePageBase coffeeMachinePageBase = headerMenu.searchProductItems(PRODUCT);
        coffeeMachinePageBase.productNameFilterClick(FILTER_NAME);
        Assert.assertTrue(coffeeMachinePageBase.isTitleTextContainsProductType(PRODUCT), "Title text don't contains this product");
        coffeeMachinePageBase.selectBrand(BRAND_DELONGHI);
        coffeeMachinePageBase.clickOnCompareIcon(0);
        coffeeMachinePageBase.clickOnCompareIcon(2);
        Assert.assertTrue(coffeeMachinePageBase.addedItemsCompareCounterIsPresent(), "Added Items Counter isn't present");
        coffeeMachinePageBase.clickOnAddedCompareBtn();
        ComparisonPageBase comparisonPageBase = coffeeMachinePageBase.clickOnProductType();
        Assert.assertTrue(comparisonPageBase.allParameterBtnIsPresent(), "All Parameter button isn't present");
    }

    @Test
    @MethodOwner(owner = "olga")
    public void testVerifyFiltersAndCheckReviewsForDate() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeader();
        Assert.assertTrue(headerMenu.isCatalogButtonPresent(), "Catalog button isn't presented");
        headerMenu.clickOnCatalogButton();
        HouseholdGoodsPageBase householdGoodsPageBase = (HouseholdGoodsPageBase) headerMenu.clickOnCategoryMenu(MenuCategory.HOUSEHOLD_GOODS);
        PCTablesPageBase pcTablesPageBase = (PCTablesPageBase) householdGoodsPageBase.clickOnCategoriesLink(FurnitureSubcategory.PC_TABLES);
        pcTablesPageBase.selectRegulate(ELECTRIC_TYPE);
        pcTablesPageBase.selectRegulate(COLOR);
        TableItemsPageBase tableItemsPageBase = pcTablesPageBase.clickOnProductTitle(1);
        Assert.assertTrue(tableItemsPageBase.isChosenColorCorrect(COLOR), "Color is not equals the chosen color");
        tableItemsPageBase.clickOnTab(ProductTabs.REVIEWS);
        tableItemsPageBase.selectDropdownOption(SortDropdown.DATE);
        Assert.assertTrue(tableItemsPageBase.isOpinionsSortedByDate(), "List isn't sorted by date");
    }

    @Test
    @MethodOwner(owner = "olga")
    public void testVerifyDeviceTypeAndCheckFooterMenu() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.SMARTPHONES_TV_ELECTRONICS);
        AppleBrandPageBase appleBrandPageBase = phonesAndElectronicsPageBase.clickOnBrandLink(0);
        Assert.assertTrue(appleBrandPageBase.isDeviceTypePresent(DEVICE_TYPE),"Device type isn't presented");
        FooterMenu footerMenu = appleBrandPageBase.getFooterMenu();
        Assert.assertTrue(footerMenu.isSocialIconPresent(SocialLinks.TELEGRAM), "Social icon isn't presented");
        ContactsPageBase contactsPageBase = footerMenu.clickOnFooterLink(FooterLinks.CONTACTS);
        Assert.assertTrue(contactsPageBase.isAddressListPresent(0), "Address list aren't presented");
    }
}
