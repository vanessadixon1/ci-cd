package com.amcsoftware.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    public static ExtentReports extent;

    public static ExtentReports getReports() {
        if(extent == null) {
            String timeStamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
            ExtentSparkReporter reporter = new ExtentSparkReporter("report/report_"+timeStamp+".html");
            reporter.config().setDocumentTitle("Practice");
            reporter.config().setTheme(Theme.DARK);
            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
}
