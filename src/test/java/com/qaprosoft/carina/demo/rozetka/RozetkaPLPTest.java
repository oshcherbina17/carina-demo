package com.qaprosoft.carina.demo.rozetka;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.enums.Devices;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.enums.ProductStatus;
import com.qaprosoft.carina.demo.web.gui.common.PhonePageBase;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;

public class RozetkaPLPTest implements IAbstractTest {

    final int INDEX_ONE = 1;

    @Test(description = "User can choose brand, type max price.")
    @MethodOwner(owner = "oshcherbina")
    public void testCheckFiltersBrandAndPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        PhonePageBase phonePageBase = (PhonePageBase) phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.PHONES);
        phonePageBase.selectBrand(FilterType.BRAND_SIGMA);
        phonePageBase.setSortingPrice("max", 4000);
        phonePageBase.selectStateCheckBox(ProductStatus.AVAILABLE);
        Assert.assertTrue(phonePageBase.checkBrandInDescription(FilterType.BRAND_SIGMA, INDEX_ONE),
                "Brand name text not contains in description");
    }

    @Test(dataProvider = "DataProvider", description = "Search brands with XLS sheet.")
    @XlsDataSourceParameters(path = "xls/listBrands.xlsx", sheet = "phoneSheet", dsUid = "TUID", dsArgs = "brand")
    @MethodOwner(owner = "oshcherbina")
    public void verifySearchingBrandsTest(String searchPhone) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
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
        homePage.clickOnClosePopupButton();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase = headerMenu.searchBrand(BRAND_NAME);
        searchPageBase.productNameFilterClick(FilterType.FILTER_HEADPHONES);
        Assert.assertEquals(searchPageBase.getPageTitleText().toLowerCase(), BRAND_NAME.toLowerCase(),
                "Titles are not equals");
        Assert.assertTrue(searchPageBase.getProductsText().stream().allMatch(item -> item.contains(BRAND_NAME.toLowerCase())),
                "Search result is not as required");
    }

    @Test(description = "Search brands with parallel threads.")
    @Parameters({"phoneSearch"})
    @MethodOwner(owner = "oshcherbina")
    public void verifySearchingProcess(String search) {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        SearchPageBase searchPageBase = headerMenu.searchBrand(search);
        Assert.assertEquals(searchPageBase.getPageTitleText().toLowerCase(), search.toLowerCase(),
                "Titles are not equals");
        Assert.assertTrue(searchPageBase.getProductsText().stream().allMatch(item -> item.contains(search.toLowerCase())),
                "Search result is not as required");
    }
}
