package com.qaprosoft.carina.demo.rozetka;

import org.testng.annotations.Test;
import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.web.enums.Devices;
import com.qaprosoft.carina.demo.web.enums.FilterType;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.enums.ProductTabs;
import com.qaprosoft.carina.demo.web.gui.common.PhoneItemsPageBase;
import com.qaprosoft.carina.demo.web.gui.common.PhonePageBase;
import com.qaprosoft.carina.demo.web.gui.common.PhonesAndElectronicsPageBase;
import com.qaprosoft.carina.demo.web.gui.components.PhotoModal;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;

public class RozetkaPDPTest implements IAbstractTest {

    final int INDEX_ZERO = 0;

    @Test(description = "User can view product photo.")
    @MethodOwner(owner = "oshcherbina")
    public void testViewProductPhoto() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.clickOnClosePopupButton();
        PhonesAndElectronicsPageBase phonesAndElectronicsPageBase = (PhonesAndElectronicsPageBase) homePage.clickOnCategoryMenu(MenuCategory.PHONES_TV_ELECTRONICS);
        PhonePageBase phonePageBase = (PhonePageBase) phonesAndElectronicsPageBase.clickOnCategoriesLink(Devices.PHONES);
        phonePageBase.selectBrand(FilterType.BRAND_APPLE);
        PhoneItemsPageBase phoneItemsPageBase = phonePageBase.clickOnProductTitle(INDEX_ZERO);
        phoneItemsPageBase.clickOnTab(ProductTabs.PHOTO);
        phoneItemsPageBase.clickOnPhotoTab(INDEX_ZERO);
        PhotoModal photoModal = phoneItemsPageBase.getPhotoModal();
        Assert.assertTrue(photoModal.isPhotoSliderPresent(INDEX_ZERO), "Photo modal isn't presented");
        photoModal.clickOnSlider();
        photoModal.clickOnModalCloseButton();
    }

}
