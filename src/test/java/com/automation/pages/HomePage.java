package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePage extends BasePage{

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement  shoppingCartLink;

    @FindBy(xpath = "//button[contains(@id,\"add-to-cart\")]")
    List<WebElement> addToCartBtnList;

    @FindBy(xpath = "//div[contains(@class, 'inventory_item_name')] ")
    List<WebElement> beforeSortingProducts;

    @FindBy(xpath = "//div[contains(@class, 'inventory_item_name')] ")
    List<WebElement> afterSortingProducts;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    WebElement dropDownBox;

    @FindBy(xpath = "//div[contains(@class, 'inventory_item_price')]")
    List<WebElement> beforeSortingProductsPrice;

    @FindBy(xpath = "//div[contains(@class, 'inventory_item_price')] ")
    List<WebElement> afterSortingProductsPrice;

    @FindBy(xpath = "//span[contains(@class,'shopping_cart_badge')]")
    WebElement cartIconQuantity;

    List<String> afterSortingProductsList = new ArrayList<>();
    List<String> beforeSortingProductsList = new ArrayList<>();

    List<Double> afterSortingProductsPriceList = new ArrayList<>();
    List<Double> beforeSortingProductsPriceList = new ArrayList<>();

    int count=0;

    public boolean isHomePageDisplayed(){
        return shoppingCartLink.isDisplayed();
    }

    public void clickOnAddToCartOfFirstItem(){
        addToCartBtnList.get(0).click();


    }

    public void clickOnShoppingCartLink(){
        shoppingCartLink.click();

    }

    public void createBeforeSortingProductsPriceList(){
        for(WebElement p: beforeSortingProductsPrice){
            beforeSortingProductsPriceList.add(Double.valueOf(p.getText().replace('$', ' ')));
        }
    }

    public void clickDropDownOptionForPrice(){
        Select dropdown = new Select(dropDownBox);
        dropdown.getOptions().get(3).click();
    }

    public void createAfterSortingProductsPriceList(){
        for(WebElement q: afterSortingProductsPrice){
            afterSortingProductsPriceList.add(Double.valueOf(q.getText().replace('$', ' ')));
        }
    }

    public void compareProductsPriceList(){
        Collections.sort(beforeSortingProductsPriceList);
        Collections.sort(afterSortingProductsPriceList);
        Assert.assertEquals(beforeSortingProductsPriceList,afterSortingProductsPriceList);
    }


    public void createBeforeSortingProductsList(){
        for(WebElement p: beforeSortingProducts){
            beforeSortingProductsList.add(p.getText());
        }
    }

    public void clickDropDownOption(){
        Select dropdown = new Select(dropDownBox);
        dropdown.getOptions().get(1).click();
    }

    public void createAfterSortingProductsList(){
        for(WebElement q: afterSortingProducts){
            afterSortingProductsList.add(q.getText());
        }
    }

    public void compareProductsList(){
        Collections.sort(afterSortingProductsList);
        Assert.assertEquals(beforeSortingProductsList,afterSortingProductsList);
    }

    public void createAddToCartList(){
        for (WebElement webElement : addToCartBtnList){
            webElement.click();
            count=count+1;
        }

    }
    public void compareQuantityOnCart(){
        Assert.assertEquals(count,Integer.parseInt(cartIconQuantity.getText()));
    }

    public void verifyNoRemoveButton(){
        for (WebElement webElement : addToCartBtnList){
            String temp = webElement.getText();
            Assert.assertEquals(temp,"Add to cart");
        }
    }







}
