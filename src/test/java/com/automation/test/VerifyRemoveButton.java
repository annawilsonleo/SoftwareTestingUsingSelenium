package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.annotations.Test;

public class VerifyRemoveButton extends BaseTest{
    @Test
    public void removeButtonIsDisplayed(){

        loginPage.openWebsite();
        loginPage.doLogin(ConfigReader.getConfigValue("login.username"), ConfigReader.getConfigValue("login.password"));
        homePage.isHomePageDisplayed();
        homePage.createAddToCartList();
        homePage.clickOnShoppingCartLink();
        cartPage.isCartPageDisplayed();
        cartPage.clickCheckOutBtn();
        checkOutPage.isCheckOutPageDisplayed();
        checkOutPage.fillShippingInfo();
        checkOutPage.clickContinueButton();
        reviewPage.isReviewPageDisplayed();
        reviewPage.clickFinishButton();
        orderConfirmationPage.isOrderConfirmationMsgDisplayed();
        orderConfirmationPage.clickBackHomeButton();
        homePage.isHomePageDisplayed();
        homePage.verifyNoRemoveButton();
    }
}
