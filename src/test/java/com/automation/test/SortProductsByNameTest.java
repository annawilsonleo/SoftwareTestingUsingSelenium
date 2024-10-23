package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortProductsByNameTest extends BaseTest{
    @Test
    public void VerifyProductsAreSorted(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.createBeforeSortingProductsList();
        homePage.clickDropDownOption();
        homePage.createAfterSortingProductsList();
        homePage.compareProductsList();
    }
}
