package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortProductsByPriceTest extends BaseTest{
    @Test
    public void verifyProductsAreSortedByPrice(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.createBeforeSortingProductsPriceList();
        homePage.clickDropDownOptionForPrice();
        homePage.createAfterSortingProductsPriceList();
        homePage.compareProductsPriceList();

    }
}
