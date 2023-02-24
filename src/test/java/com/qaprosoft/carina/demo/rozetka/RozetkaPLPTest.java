package com.qaprosoft.carina.demo.rozetka;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.enums.Devices;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.enums.ProductStatus;
import com.qaprosoft.carina.demo.web.gui.common.HouseholdGoodsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.LaptopsAndPCPageBase;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.components.ProductFilter;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;

public class RozetkaPLPTest implements IAbstractTest {

    final int INDEX_ONE = 1;

    @Test(description = "User can choose brand, type max price.")
    @MethodOwner(owner = "oshcherbina")
    public void testCheckFiltersBrandAndPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase =
                (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        ProductListPageBase productListPage = phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.PHONES);
        ProductFilter productFilter = productListPage.getFilter();
        productFilter.selectFilter(FilterType.BRAND_SIGMA);
        productListPage.setSortingPrice("max", 4000);
        productFilter.selectStateCheckBox(ProductStatus.AVAILABLE);
        Assert.assertTrue(productListPage.checkBrandInDescription(FilterType.BRAND_SIGMA, INDEX_ONE),
                "Brand name text not contains in description");
    }

    @Test(dataProvider = "DataProvider", description = "Search brands with XLS sheet.")
    @XlsDataSourceParameters(path = "xls/listBrands.xlsx", sheet = "phoneSheet", dsUid = "TUID", dsArgs = "brand")
    @MethodOwner(owner = "oshcherbina")
    public void verifySearchingBrandsTestWithXLS(String searchPhone) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase = headerMenu.searchBrand(searchPhone);
        Assert.assertEquals(searchPageBase.getPageTitleText().toLowerCase(), searchPhone.toLowerCase(),
                "Titles are not equals");
        Assert.assertTrue(searchPageBase.getProductsText().stream().allMatch(item -> item.contains(searchPhone.toLowerCase())),
                "Search result is not as required");
    }

    @Test(dataProvider = "DataProvider", description = "Search brands in category headphones with XLS sheet.")
    @XlsDataSourceParameters(path = "xls/allModels.xlsx", sheet = "AllPhoneSheet", dsUid = "TUID")
    @MethodOwner(owner = "oshcherbina")
    public void verifySearchingProcessWithXLS(HashMap<String, String> args) {
        final String BRAND_NAME = args.get("brand");
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase = headerMenu.searchBrand(BRAND_NAME);
        searchPageBase.productNameFilterClick(FilterType.FILTER_HEADPHONES);
        Assert.assertTrue(searchPageBase.checkSubcategoryTitleText(FilterType.FILTER_HEADPHONES.getType()),
                "Titles subcategory are not equals");
        Assert.assertEquals(searchPageBase.getPageTitleText().toLowerCase(), BRAND_NAME.toLowerCase(),
                "Titles are not equals");
        Assert.assertTrue(searchPageBase.getProductsText().stream().allMatch(item -> item.contains(BRAND_NAME.toLowerCase())),
                "Search result is not as required");
    }

    @Test(dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/price.xlsx", sheet = "price", dsUid = "TUID", dsArgs = "min_price, max_price")
    public void testFilterPhonesByPrice(String min_price, String max_price) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase =
                (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        Assert.assertTrue(phonesAndElectronicsPageBase.isPageOpened(), "Category page is not opened");
        ProductListPageBase productListPage = phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.PHONES);
        Assert.assertTrue(Integer.parseInt(min_price) >= 123,
                "Minimum price is less than the minimum given price");
        Assert.assertTrue(Integer.parseInt(max_price) <= 492408,
                "Maximum price is large than the maximum given price");
        Assert.assertFalse(Integer.parseInt(min_price) > Integer.parseInt(max_price),
                "Incorrect min and max values");
        productListPage.filterProductsByPrice("min", "max", min_price, max_price);
        Assert.assertTrue(productListPage.verifyPriceLimits(min_price, max_price),
                "Products not filtered by price");
    }

    @DataProvider(parallel = true, name = "searchBrands")
    public static Object[][] dataprovider() {
        return new Object[][]{
                {"TUID: id1", "Xiaomi"},
                {"TUID: id2", "Nokia"},
                {"TUID: id3", "Samsung"}};
    }

    @Test(dataProvider = "searchBrands", description = "Search brands.")
    @MethodOwner(owner = "oshcherbina")
    public void verifySearchingBrandsTest(String TUID, String searchPhone) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase = headerMenu.searchBrand(searchPhone);
        Assert.assertEquals(searchPageBase.getPageTitleText().toLowerCase(), searchPhone.toLowerCase(),
                "Titles are not equals");
        Assert.assertTrue(searchPageBase.getProductsText().stream().allMatch(item -> item.contains(searchPhone.toLowerCase())),
                "Search result is not as required");
    }

    @DataProvider(parallel = true, name = "chooseCategory")
    public static Object[][] chooseCategory() {
        return new Object[][]{
                {"TUID:01: Laptops_computer", "Ноутбуки та комп’ютери"},
                {"TUID:02: Phones_Tv_electronics", "Смартфони, ТВ і електроніка"},
                {"TUID:03: Household_goods", "Товари для дому"}};
    }

    @Test(dataProvider = "chooseCategory", description = "Choose menu category.")
    @MethodOwner(owner = "oshcherbina")
    public void verifyMenuCategory(String TUID, String categoryName) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(3), "Home page isn't opened");
        homePage.clickOnClosePopupButton();
        switch (categoryName) {
            case "Ноутбуки та комп’ютери":
                LaptopsAndPCPageBase laptopsAndPCPageBase = (LaptopsAndPCPageBase)
                        homePage.clickOnCategoryMenu(MenuCategory.LAPTOPS_COMPUTERS);
                Assert.assertTrue(laptopsAndPCPageBase.getTitleText(categoryName),
                        "Title and category name are not equals");
                break;
            case "Смартфони, ТВ і електроніка":
                PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase)
                        homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
                Assert.assertEquals(categoryName.toLowerCase(), phonesAndElectronicsPageBase.getTitleText(),
                        "Title and category name are not equals");
                break;
            case "Товари для дому":
                HouseholdGoodsPageBase householdGoodsPageBase = (HouseholdGoodsPageBase)
                        homePage.clickOnCategoryMenu(MenuCategory.HOUSEHOLD_GOODS);
                Assert.assertEquals(categoryName.toLowerCase(), householdGoodsPageBase.getTitleText(),
                        "Title and category name are not equals");
                break;
        }
    }
}
