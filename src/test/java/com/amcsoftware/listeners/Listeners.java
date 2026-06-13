package com.amcsoftware.listeners;

import com.amcsoftware.driver.DriverFactory;
import com.amcsoftware.util.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

@Slf4j
public class Listeners implements ITestListener {

    private static final ExtentReports extent = ExtentManager.getReports();
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();

        test.get().fail(result.getThrowable());

        try {
            File screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            Path screenshotDir = Path.of("screenshots");
            Files.createDirectories(screenshotDir);

            Path screenshotPath = screenshotDir.resolve(testName + ".png");

            Files.copy(
                    screenshot.toPath(),
                    screenshotPath,
                    StandardCopyOption.REPLACE_EXISTING
            );

            test.get().addScreenCaptureFromPath(
                    screenshotPath.toString(),
                    testName + " failure screenshot"
            );

        } catch (IOException e) {
            log.error("Failed to take screenshot for test: {}", testName, e);
        }

        log.error("Test failed: {}", testName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
        test.remove();
    }
}