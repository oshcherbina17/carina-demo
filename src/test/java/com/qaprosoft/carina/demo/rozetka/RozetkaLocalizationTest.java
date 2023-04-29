package com.qaprosoft.carina.demo.rozetka;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.core.foundation.utils.resources.L10N;
import com.qaprosoft.carina.demo.web.enums.Devices;
import com.qaprosoft.carina.demo.web.enums.MenuCategory;
import com.qaprosoft.carina.demo.web.enums.SortDropdown;
import com.qaprosoft.carina.demo.web.gui.common.LaptopsAndPCPageBase;
import com.qaprosoft.carina.demo.web.gui.common.ProductListPageBase;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.components.ProductFilter;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;

public class RozetkaLocalizationTest implements IAbstractTest {

    @Test(description = "Check language UA.")
    @MethodOwner(owner = "oshcherbina")
    public void testUkrainianLocalization() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        HeaderMenu headerMenu = homePage.getHeader();
        headerMenu.checkAndChangeLanguage();
        String expectedTitle = "Інтернет-магазин ROZETKA™: офіційний сайт найпопулярнішого онлайн-гіпермаркету в Україні";
        Assert.assertEquals(homePage.getTitle(), expectedTitle);
        String expectedCategoryTitle = "Ноутбуки та комп’ютери";
        Assert.assertEquals(homePage.getCategoryText(MenuCategory.LAPTOPS_COMPUTERS), expectedCategoryTitle);
        Assert.assertEquals(headerMenu.getBtnText(), "Знайти");
    }

    @Test(description = "Check language RU.")
    @MethodOwner(owner = "oshcherbina")
    public void testRussianLocalization() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        HeaderMenu headerMenu = homePage.getHeader();
        headerMenu.clickOnLanguageBtn("RU");
        String expectedTitle = "Интернет-магазин ROZETKA™: официальный сайт самого популярного онлайн-гипермаркета в Украине";
        Assert.assertEquals(homePage.getTitle(), expectedTitle);
        String expectedCategoryTitle = "Ноутбуки и компьютеры";
        Assert.assertEquals(homePage.getCategoryText(MenuCategory.LAPTOPS_COMPUTERS_RU), expectedCategoryTitle);
        Assert.assertEquals(headerMenu.getBtnText(), "Найти");
    }

    @Test(description = "Check language with file L10N.")
    @MethodOwner(owner = "oshcherbina")
    public void testLocalizationWithResources() {
        SoftAssert softAssert = new SoftAssert();

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page isn't opened");
        homePage.clickOnClosePopupButton();
        HeaderMenu headerMenu = homePage.getHeader();
        headerMenu.checkAndChangeLanguage();
        LaptopsAndPCPageBase laptopsAndPCPageBase =
                (LaptopsAndPCPageBase) homePage.clickOnCategoryMenuWithL10N(MenuCategory.LAPTOPS_COMPUTER);
        ProductListPageBase productListPage = laptopsAndPCPageBase.clickOnCategoriesLinkWithL10N(Devices.TABLET);
        String expected = L10N.getText("ProductDetailsPageBase.Devices.TABLET");
        Assert.assertEquals(productListPage.getDeviceTitleText(), expected);
        ProductFilter productFilter = productListPage.getFilter();
        productFilter.sortDropdownMenuWithL10N(SortDropdown.ASCENDING);
        String expectedTitle = L10N.getText("ProductFilter.SortDropdown.Ascending");
        Assert.assertEquals(productFilter.getMenuTitleText(SortDropdown.ASCENDING), expectedTitle);

        softAssert.assertAll();
        L10N.assertAll();
    }
}