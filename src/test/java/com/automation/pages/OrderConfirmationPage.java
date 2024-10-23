package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmationPage extends BasePage{
    @FindBy(css = ".complete-header")
    WebElement confirmationMsg;

    @FindBy(xpath="//button[@id='back-to-products']")
    WebElement backToHomeButton;

    public boolean isOrderConfirmationMsgDisplayed(){

        System.out.println(confirmationMsg.getText());
        return confirmationMsg.isDisplayed();
    }

    public void clickBackHomeButton(){
        backToHomeButton.click();
    }

}
