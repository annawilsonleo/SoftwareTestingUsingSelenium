package com.automation.test;

import com.automation.utils.ExcelUtils;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginLogoutTest extends BaseTest{

    @Test(dataProvider = "getValidCredentials")
    public void verifyUserCanLogin(String username,String password){
        loginPage.openWebsite();
        loginPage.doLogin(username, password);
        Allure.addAttachment("screenshot",takeScreenshot());
        Assert.assertTrue(homePage.isHomePageDisplayed());
    }

    @DataProvider
    public Object[][] getValidCredentials() throws IOException {
        ExcelUtils excelUtils = new ExcelUtils("Credentials.xlsx", "ValidData");
        List<List<String>> tableData = excelUtils.getData();
        Object[][] data = new Object[tableData.size()][tableData.get(0).size()];
        for (int i = 0; i< tableData.size();i++) {
            List<String> row = tableData.get(i);
            for (int j = 0; j < row.size(); j++) {
                data[i][j] = tableData.get(i).get(j);
            }
        }
        return data;
    }
}
