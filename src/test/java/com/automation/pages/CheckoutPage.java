package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(xpath = "//div[contains(@class, 'inventory_item_price')]")
    List<WebElement> productPrices;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    WebElement subTotalLabel;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    WebElement taxLabel;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    WebElement totalLabel;

    List<Double> productPricesList = new ArrayList<>();

    double sum=0;

    public boolean isCheckOutPageDisplayed(){
        return checkOutBtnTitle.isDisplayed();
    }

    public void fillShippingInfo(){
        firstnameInput.sendKeys(ConfigReader.getConfigValue("shipping.firstname"));
        lastnameInput.sendKeys(ConfigReader.getConfigValue("shipping.lastname"));
        postalCodeInput.sendKeys(ConfigReader.getConfigValue("shipping.zipcode"));
    }

    public void clickContinueButton() {
        continueBtn.click();
    }

    public void calculateEachPrices() {
        String subtotalLabelText = subTotalLabel.getText();
        String[] subtotalFullText = subtotalLabelText.split("\\$");
        double subTotalValue = Double.parseDouble(subtotalFullText[1].trim());
        String taxLabelText = taxLabel.getText();
        String[] fulltext = taxLabelText.split("\\$");
        double taxValue = Double.parseDouble(fulltext[1].trim());
        double calculatedTotal = subTotalValue + taxValue;

        String totalLabelText = totalLabel.getText();
        String[] totalLabelFullText = totalLabelText.split("\\$");
        double totalValue = Double.parseDouble(totalLabelFullText[1].trim());

        ConfigReader.setConfigValue("calculated.total",String.valueOf(calculatedTotal));
        ConfigReader.setConfigValue("actual.total",String.valueOf(totalValue));
    }

    public void comparePrices(double key, double value){
        Assert.assertEquals(key,value);
    }


}


