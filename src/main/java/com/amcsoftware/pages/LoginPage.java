package com.amcsoftware.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public LoginPage() {
        super();
    }

    /**
     * this method fill in the login form and click the login button
     * @param userEmail
     * @param password
     * @param locator
     */
    public void login(String userEmail, String password, By locator) {
        waitForClickable(locator);
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(password);
        loginButton.click();
    }
}
