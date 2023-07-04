package com.qaprosoft.carina.demo.rozetka.cucumber.stepDefenitions;

import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.web.gui.common.SearchPageBase;
import com.qaprosoft.carina.demo.web.gui.components.HeaderMenu;
import com.qaprosoft.carina.demo.web.gui.desktop.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps extends CommonSteps implements IDriverPool {
    HomePage homePage = null;
    HeaderMenu headerMenu = null;
    SearchPageBase searchPage = null;

    @Given("User is on the Homepage")
    public void openHomepage() {
        homePage = new HomePage(getDriver());
        homePage.open();
    }

    @And("Check all element headerMenu are displayed")
    public void checkHeaderMenuElementsAreDisplayed() {
        homePage = new HomePage(getDriver());
        headerMenu = homePage.getHeader();
        Assert.assertTrue(headerMenu.isCatalogButtonPresent(), "Catalog button isn't presented");
        Assert.assertTrue(headerMenu.isHamburgerMenuPresent(), "Hamburger menu isn't presented");
        Assert.assertTrue(headerMenu.isLoginIconPresent(), "Login icon isn't presented");
    }

    @When("User searches for {string}")
    public void searchBrand(String productName) {
        homePage = new HomePage(getDriver());
        headerMenu = homePage.getHeader();
        searchPage = headerMenu.searchBrand(productName);
        pause(5);
    }

    @Then("^Search page should contains title result \"([^\"]*)\"$")
    public void searchResultsAreDisplayed(String productName) {
        Assert.assertTrue(searchPage.isTitleTextContainsProduct(productName),
                "Search Title is not present");
    }
}
