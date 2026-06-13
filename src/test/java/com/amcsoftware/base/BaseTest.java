package com.amcsoftware.base;

import com.amcsoftware.driver.DriverFactory;
import org.testng.annotations.*;

import java.net.MalformedURLException;

public class BaseTest extends DriverFactory {
//
    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) throws MalformedURLException {
        String username = System.getenv("BROWSERSTACK_USERNAME");
        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        System.out.println("BROWSER FROM XML = [" + browser + "]");
        System.out.println("USERNAME=" + System.getenv("BROWSERSTACK_USERNAME"));
        System.out.println("KEY EXISTS=" + (System.getenv("BROWSERSTACK_ACCESS_KEY") ));
        DriverFactory.initDriver(browser);
    }

    @AfterMethod
    public void afterMethod() {
        DriverFactory.closeDriver();
    }

}
