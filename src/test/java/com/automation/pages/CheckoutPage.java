package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//span[contains(@class,'title') and text()='Checkout: Your Information']")
    WebElement checkOutBtnTitle;

    @FindBy(id="first-name")
    WebElement firstnameInput;

    @FindBy(id="last-name")
    WebElement lastnameInput;

    @FindBy(id="postal-code")
    WebElement postalCodeInput;

    @FindBy(id="continue")
    WebElement continueBtn;

    public boolean isCheckOutPageDisplayed(){
        return checkOutBtnTitle.isDisplayed();
    }

    public void fillShippingInfo(){
        firstnameInput.sendKeys("Test");
        lastnameInput.sendKeys("Automation");
        postalCodeInput.sendKeys("23455678");
    }

    public void clickContinueButton() {
        continueBtn.click();
    }

}
