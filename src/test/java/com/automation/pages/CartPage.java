package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public boolean isCartPageDisplayed(){
        return checkoutBtn.isDisplayed();
    }

    public void clickCheckOutBtn(){
        checkoutBtn.click();
    }

}

