package com.utility;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtlity {

	static ExtentReports extentReport;
	static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public static void setupExtendSparkReport(String reportName) {
		ExtentSparkReporter extentSparkReport = new ExtentSparkReporter(
				System.getProperty("user.dir") + File.separator + "Reports" + File.separator + reportName);
		extentReport = new ExtentReports();
		extentReport.attachReporter(extentSparkReport);

	}

	public static void createReport(String name) {
		ExtentTest test = extentReport.createTest(name);
		extentTest.set(test);
	}

	public static ExtentTest getExtentTest() {
		return extentTest.get();
	}

	public static void flush() {
		extentReport.flush();
	}

}
