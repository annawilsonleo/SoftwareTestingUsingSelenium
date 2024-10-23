package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.annotations.Test;

public class TotalPriceValidation extends BaseTest{
    @Test
    public void validateTotalPrice() {

        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        homePage.isHomePageDisplayed();
        homePage.createAddToCartList();
        homePage.compareQuantityOnCart();
        homePage.clickOnShoppingCartLink();
        cartPage.isCartPageDisplayed();
        cartPage.clickCheckOutBtn();
        checkOutPage.isCheckOutPageDisplayed();
        checkOutPage.fillShippingInfo();
        checkOutPage.clickContinueButton();
        checkOutPage.calculateEachPrices();
        double key = Double.parseDouble(ConfigReader.getConfigValue("calculated.total"));
        double value = Double.parseDouble(ConfigReader.getConfigValue("actual.total"));
        checkOutPage.comparePrices(key,value);



    }
}


