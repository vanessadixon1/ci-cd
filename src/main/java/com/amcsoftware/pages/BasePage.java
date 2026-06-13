package com.amcsoftware.pages;

import com.amcsoftware.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

abstract class BasePage {
    protected WebDriverWait wait;

    public BasePage() {
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id="userEmail")
    protected WebElement userEmailField;

    @FindBy(id = "userPassword")
    protected WebElement userPasswordField;

    @FindBy(id = "login")
    protected WebElement loginButton;

    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    protected void waitForClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForTitle(String text) {
        wait.until(ExpectedConditions.titleContains(text));
    }

    protected void waitForVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
