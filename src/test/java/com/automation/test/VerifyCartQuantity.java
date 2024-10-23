package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyCartQuantity extends BaseTest{

    @Test
    public void verifyCartProductQuantity(){
        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));

        Assert.assertTrue(homePage.isHomePageDisplayed());
        homePage.createAddToCartList();
        homePage.clickOnShoppingCartLink();
        homePage.compareQuantityOnCart();


    }
}
