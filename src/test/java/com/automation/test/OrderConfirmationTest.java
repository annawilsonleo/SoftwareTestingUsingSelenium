package com.automation.test;

import com.automation.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class OrderConfirmationTest extends BaseTest{

        @Test
        public void verifyUserCanPlaceOrder(){


            LoginPage loginPage = new LoginPage();
            loginPage.openWebsite();
            loginPage.doLogin("standard_user","secret_sauce");

            HomePage homePage = new HomePage();
            Assert.assertTrue(homePage.isHomePageDisplayed());

            homePage.clickOnAddToCartOfFirstItem();
            homePage.clickOnShoppingCartLink();

            CartPage cartPage = new CartPage();
            Assert.assertTrue(cartPage.isCartPageDisplayed());
            cartPage.clickCheckOutBtn();

            CheckoutPage checkOutPage = new CheckoutPage();
            Assert.assertTrue(checkOutPage.isCheckOutPageDisplayed());

            checkOutPage.isCheckOutPageDisplayed();
            checkOutPage.fillShippingInfo();
            checkOutPage.clickContinueButton();

            ReviewPage reviewPage = new ReviewPage();
            Assert.assertTrue(reviewPage.isReviewPageDisplayed());
            reviewPage.clickFinishButton();

            OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage();
            Assert.assertTrue(orderConfirmationPage.isOrderConfirmationMsgDisplayed());


        }



    }


