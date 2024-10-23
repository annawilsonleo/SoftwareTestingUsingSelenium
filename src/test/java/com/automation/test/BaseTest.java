package com.automation.test;

import com.automation.pages.*;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.ByteArrayInputStream;

public class BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkOutPage;
    ReviewPage reviewPage;
    OrderConfirmationPage orderConfirmationPage;

    WebDriver driver;
    @BeforeMethod
    public void setUp(){

        ConfigReader.initConfig();
        DriverManager.createDriver();
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        checkOutPage = new CheckoutPage();
        reviewPage = new ReviewPage();
        orderConfirmationPage = new OrderConfirmationPage();
    }

    public ByteArrayInputStream takeScreenshot(){
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        return new ByteArrayInputStream(screenshot);
    }
    @AfterMethod
    public void cleanUp(){
        DriverManager.getDriver().quit();
    }
}
