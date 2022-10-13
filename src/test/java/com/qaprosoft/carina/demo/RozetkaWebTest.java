package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.common.*;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import com.qaprosoft.carina.demo.web.utils.enums.DevicesEnum;
import com.qaprosoft.carina.demo.web.utils.enums.MenuCategoryEnum;
import com.qaprosoft.carina.demo.web.utils.enums.ProductStatusEnum;
import com.qaprosoft.carina.demo.web.utils.enums.SortDropdownEnum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RozetkaWebTest implements IAbstractTest {

    private final String BRAND_APPLE = "Apple";

    private final String BRAND_LENOVO = "Lenovo";

    private final String BRAND_DELONGHI = "Delonghi";

    private final String RAM = "8 ГБ";

    private final String PRODUCT = "Кавомашина";

    private final String FILTER_NAME = "Кавоварки";

    @Test
    @MethodOwner(owner = "olga")
    public void testVerifyCheckBrandAndSortLowToHigh() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        LaptopsAndComputersPageBase laptopsAndComputersPageBase = (LaptopsAndComputersPageBase) homePage.clickOnCategoryMenu(MenuCategoryEnum.LAPTOPS_COMPUTERS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) laptopsAndComputersPageBase.clickOnCategoriesLink(DevicesEnum.TABLETS);
        tabletsPageBase.selectBrand(BRAND_APPLE);
        tabletsPageBase.selectBrand(RAM);
        tabletsPageBase.selectStateCheckBox(ProductStatusEnum.AVAILABLE);
        tabletsPageBase.sortDropdownMenu(SortDropdownEnum.LOW_TO_HIGH);
        Assert.assertTrue(tabletsPageBase.sortLowToHighPrice(), "Price not sorted ");
        tabletsPageBase.clickOnBasketIcon(2);
        Assert.assertTrue(tabletsPageBase.addedItemsCounterIsPresent(), "Added Items Counter not exist");
    }

    @Test
    @MethodOwner(owner = "olga")
    public void testVerifyBrandCheckTitleAndSum() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        SmartphonesTvElectronicsPageBase smartphonesTvElectronicsPageBase = (SmartphonesTvElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategoryEnum.SMARTPHONES_TV_ELECTRONICS);
        TabletsPageBase tabletsPageBase = (TabletsPageBase) smartphonesTvElectronicsPageBase.clickOnCategoriesLink(DevicesEnum.TABLETS);
        tabletsPageBase.selectBrand(BRAND_LENOVO);
        tabletsPageBase.selectBrand(RAM);
        tabletsPageBase.sortDropdownMenu(SortDropdownEnum.NEW);
        String deviceTitleText = tabletsPageBase.getTabletTitleText(0);
        LaptopItemsPageBase laptopItemsPageBase = tabletsPageBase.clickOnLaptopDevice(0);
        String productTitleText = laptopItemsPageBase.getProductTitleText();
        Assert.assertEquals(productTitleText, deviceTitleText, "Texts are not equals");
        laptopItemsPageBase.clickOnBuyButton();
        String sumPrice = laptopItemsPageBase.getSumPriceText();
        OrderPageBase orderPageBase = laptopItemsPageBase.clickOnOrderButton();
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
}
