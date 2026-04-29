package com.ui.listners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.test.BaseTest;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtlity;
import com.utility.LoggerUtility;

public class TestListner implements ITestListener {

	private Logger logger = LoggerUtility.getLogger(getClass());

	public void onStart(ITestContext context) {
		logger.info("Test Suite Started....");
		ExtentReportUtlity.setupExtendSparkReport("reports.html");
	}

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReportUtlity.createReport(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReportUtlity.getExtentTest().log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReportUtlity.getExtentTest().log(Status.FAIL, result.getMethod().getMethodName());
		ExtentReportUtlity.getExtentTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object baseClass = result.getInstance();
		BrowserUtility browserUtility= ((BaseTest)baseClass).getInstance();
		String screenshotpath=browserUtility.getScreenShot(result.getMethod().getMethodName());
		ExtentReportUtlity.getExtentTest().addScreenCaptureFromPath(screenshotpath);

	}

	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReportUtlity.getExtentTest().log(Status.SKIP, result.getMethod().getMethodName());

	}

	public void onFinish(ITestContext context) {
		logger.info("Test Suite Ended");
		ExtentReportUtlity.flush();

	}

}
