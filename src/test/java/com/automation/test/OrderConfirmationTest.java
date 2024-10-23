package com.automation.test;
import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class OrderConfirmationTest extends BaseTest{

        @Test
        public void verifyUserCanPlaceOrder(){

            loginPage.openWebsite();
            loginPage.doLogin(ConfigReader.getConfigValue("login.username"),ConfigReader.getConfigValue("login.password"));


            Assert.assertTrue(homePage.isHomePageDisplayed());
            homePage.clickOnAddToCartOfFirstItem();
            homePage.clickOnShoppingCartLink();

            Assert.assertTrue(cartPage.isCartPageDisplayed());
            cartPage.clickCheckOutBtn();


            Assert.assertTrue(checkOutPage.isCheckOutPageDisplayed());
            checkOutPage.isCheckOutPageDisplayed();
            checkOutPage.fillShippingInfo();
            checkOutPage.clickContinueButton();


            Assert.assertTrue(reviewPage.isReviewPageDisplayed());
            reviewPage.clickFinishButton();

            Assert.assertTrue(orderConfirmationPage.isOrderConfirmationMsgDisplayed());


        }



    }


