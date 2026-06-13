package com.amcsoftware.testcases;

import com.amcsoftware.base.BaseTest;
import com.amcsoftware.dataProivders.DataProviders;
import com.amcsoftware.driver.DriverFactory;
import com.amcsoftware.models.UsersItem;
import com.amcsoftware.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(dataProvider="users", dataProviderClass = DataProviders.class)
    public void testingLogin(UsersItem data) {
        System.getenv("BROWSERSTACK_USERNAME");
        WebDriver driver = DriverFactory.getDriver();
        LoginPage loginPage = new LoginPage();
//        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
        loginPage.login(data.getUsername(), data.getPassword(), By.id("login"));
    }

//    @Test
//    public void testingLogout() {
//        Assert.fail();
//    }

}
