package com.qaprosoft.carina.demo.rozetka;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.enums.Devices;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductDetailsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;
import com.qaprosoft.carina.demo.web.gui.components.PhotoModal;
import com.qaprosoft.carina.demo.web.gui.components.ProductFilter;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

public class RozetkaPDPTest implements IAbstractTest {

    final int INDEX_ZERO = 0;
    final int INDEX_TWO = 2;

    @Test(description = "User can view product photo.")
    @MethodOwner(owner = "oshcherbina")
    public void testViewProductPhoto() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase =
                (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        ProductListPageBase productListPage = phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.PHONES);
        ProductFilter productFilter = productListPage.getFilter();
        productFilter.selectFilter(FilterType.BRAND_APPLE);
        ProductDetailsPageBase productDetailsPageBase = productListPage.clickOnDeviceTitle(INDEX_ZERO);
        productDetailsPageBase.clickOnTab(ProductTabs.PHOTO);
        productDetailsPageBase.clickOnPhotoTab(INDEX_ZERO);
        PhotoModal photoModal = productDetailsPageBase.getPhotoModal();
        Assert.assertTrue(photoModal.isPhotoSliderPresent(INDEX_TWO), "Photo modal isn't presented");
        photoModal.clickOnSlider();
        photoModal.clickOnModalCloseButton();
    }
}
